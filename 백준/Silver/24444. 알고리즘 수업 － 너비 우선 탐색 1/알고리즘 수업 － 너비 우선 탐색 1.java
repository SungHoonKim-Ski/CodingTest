import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int n, m, r;
    static ArrayList<Integer>[] graph;

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();

        while (m -- > 0) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }

        for (int i = 1; i <= n; i++) Collections.sort(graph[i]);
    }

    static void pro() {
        Queue<Integer> que = new ArrayDeque<>();
        int[] order = new int[n + 1];
        que.add(r);

        int idx = 0;
        order[r] = ++idx;
        while (!que.isEmpty()) {
            int cur = que.poll();

            for (int nxt : graph[cur]) {
                if (order[nxt] != 0) continue;
                order[nxt] = ++idx;
                que.add(nxt);
            }
        }

        for (int i = 1; i <= n; i++) sb.append(order[i]).append('\n');
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}