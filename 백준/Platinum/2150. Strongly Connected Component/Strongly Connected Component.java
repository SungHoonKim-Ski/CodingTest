
import java.util.*;
import java.io.*;

public class Main {

    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int v, e;
    static ArrayList<Integer>[] graph, revGraph;

    static Deque<Integer> stack;
    static boolean[] visit;
    static int[] scc;

    static void input() throws IOException {

        st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        graph = new ArrayList[v + 1];
        revGraph = new ArrayList[v + 1];
        for (int i = 1; i <= v; i++) {
            graph[i] = new ArrayList<>();
            revGraph[i] = new ArrayList<>();
        }

        while (e-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            revGraph[b].add(a);
        }

        stack = new ArrayDeque<>();
        scc = new int[v + 1];
    }

    static void pro(){

        visit = new boolean[v + 1];
        for (int i = 1; i <= v; i++) {
            if (visit[i]) continue;
            dfs(i);
        }

        visit = new boolean[v + 1];
        int num = 0;
        while (!stack.isEmpty()) {
            int start = stack.pop();
            if (visit[start]) continue;
            revDes(start, ++num);
        }

        sb.append(num).append('\n');


        int cur = scc[1];
        int next = -1;
        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= v; j++) {
                if (scc[j] == -1) continue;
                if (cur == scc[j]) {
                    scc[j] = -1;
                    sb.append(j).append(' ');
                }
                else if (next == -1) {
                    next = scc[j];
                }
            }
            sb.append(-1).append('\n');
            cur = next;
            next = -1;
        }

        System.out.println(sb);
    }

    static void dfs(int start) {
        visit[start] = true;

        for (int next : graph[start]) {
            if (visit[next]) continue;
            dfs(next);
        }
        stack.push(start);
    }

    static void revDes(int start, int number) {

        visit[start] = true;
        scc[start] = number;

        for (int next : revGraph[start]) {
            if (visit[next]) continue;
            revDes(next, number);
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}