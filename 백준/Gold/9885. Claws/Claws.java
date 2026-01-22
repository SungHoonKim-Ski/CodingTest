import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static class Edge {
        int to;
        int dist;
        Edge(int to, int dist) {
            this.to = to; this.dist = dist;
        }
    }

    static int n, max = 0;
    static ArrayList<Edge>[] graph;
    static boolean[] visit;
    static int[] cost1, cost2;

    static void input() throws IOException {
        n = Integer.parseInt(br.readLine());
        visit = new boolean[n + 1];

        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();

        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int c, p, w;
            c = Integer.parseInt(st.nextToken());
            p = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            graph[p].add(new Edge(c, w));
            visit[c] = true;
        }
    }

    static void pro() {
        int root = -1;
        for (int i = 1; i <= n; i++) {
            if (!visit[i]) root = i;
        }

        cost1 = new int[n + 1];
        cost2 = new int[n + 1];
        dfs1(-1, root, 0);
        dfs2(-1, root, 0);

        System.out.println(max);
    }

    static int dfs1(int prev, int cur, int sum) {
        cost1[cur] = sum;
        int c2 = 0;
        for (Edge edge : graph[cur]) {
            if (edge.to == prev) continue;
            c2 += dfs1(cur, edge.to, sum + edge.dist);
            c2 += edge.dist;
        }
        return cost2[cur] = c2;
    }

    static void dfs2(int prev, int cur, int sum) {
        sum += cost1[cur] + cost2[cur];
        max = Math.max(max, sum);
        for (Edge edge : graph[cur]) {
            if (edge.to == prev) continue;
            dfs2(cur, edge.to, sum);
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
