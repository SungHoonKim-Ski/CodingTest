import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static class Edge {
        int cur, dist;
        Edge(int cur, int dist) {
            this.cur = cur; this.dist = dist;
        }
    }

    static final int MAX = 1_000_000;

    static int n, log;
    static int[] energy;
    static ArrayList<Edge>[] graph;

    static int[][] parent;
    static long[][] dist;

    static void input() throws IOException{
        n = Integer.parseInt(br.readLine());

        graph = new ArrayList[n + 1];
        energy = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            energy[i] = Integer.parseInt(br.readLine());
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            graph[x].add(new Edge(y, z));
            graph[y].add(new Edge(x, z));
        }
    }

    static void pro() {
        while ((1 << log) <= n) {
            log++;
        }

        parent = new int[log + 1][n + 1];
        dist = new long[log + 1][n + 1];

        dfs(1, 0);
        for (int i = 1; i <= log; i++) {
            for (int j = 1; j <= n; j++) {
                int next = parent[i - 1][j];
                parent[i][j] = parent[i - 1][next];
                dist[i][j] = dist[i - 1][next] + dist[i - 1][j];
            }
        }

        for (int i = 1; i <= n; i++) {
            int cur = i;
            long left = energy[i];

            for (int j = log; j >= 0; j--) {
                int next = parent[j][cur];
                if (next == 0) continue;

                long use = dist[j][cur];
                if (left - use >= 0) {
                    left -= use;
                    cur = next;
                }
            }

            sb.append(cur).append('\n');
        }

        System.out.println(sb);
    }

    static void dfs(int cur, int prev) {
        parent[0][cur] = prev;

        for (Edge next : graph[cur]) {
            if (next.cur == prev) continue;
            dist[0][next.cur] = next.dist;
            dfs(next.cur, cur);
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}