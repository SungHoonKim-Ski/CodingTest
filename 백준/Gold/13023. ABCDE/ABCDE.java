import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, m;
    static ArrayList<Integer>[] graph;
    static boolean[] visit;
    static boolean find;

    static void input() throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x].add(y);
            graph[y].add(x);
        }
    }

    public static void pro() {
        for (int i = 0; i < n; i++) {
            if (find) break;
            visit = new boolean[n];
            visit[i] = true;
            dfs(0, i);
        }

        if (find) System.out.println(1);
        else System.out.println(0);
    }

    static void dfs(int depth, int cur) {
        if (depth == 4) {
            find = true;
            return;
        }

        for (int next : graph[cur]) {
            if (visit[next]) continue;

            visit[next] = true;
            dfs(depth + 1, next);
            visit[next] = false;
        }
    }

    public static void main(String[] args) throws Exception{
        input();
        pro();
    }
}