import java.io.*;
import java.util.*;

public class Main {
    static class Edge {
        int idx;
        long dist, cost;

        Edge(int idx, long dist, long cost) {
            this.idx = idx; this.dist = dist; this.cost = cost;
        }
    }

    static class Info {
        int idx, prev;
        long dist, cost;

        Info(int idx, long dist, long cost, int prev) {
            this.idx = idx; this.dist = dist; this.cost = cost; this.prev = prev;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n, t, m, l;
    static ArrayList<Edge>[] graph;

    static void input() throws IOException{
        n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        t = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();

        l = Integer.parseInt(br.readLine());
        for (int i = 0; i < l; i++) {
            st = new StringTokenizer(br.readLine());

            int x, y;
            long z, w;

            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            z = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            graph[x].add(new Edge(y, z, w));
            graph[y].add(new Edge(x, z, w));
        }
    }

    static void pro() {
        Queue<Info> que = new ArrayDeque<>();

        long[] maxCost = new long[n + 1];

        Arrays.fill(maxCost, Long.MAX_VALUE);

        que.add(new Info(1, 0, 0, -1));
        maxCost[1] = 0;

        while (!que.isEmpty()) {
            Info cur = que.poll();

            for (Edge next : graph[cur.idx]) {
                long nCost = cur.cost + next.cost;
                long nDist = cur.dist + next.dist;

                if (nDist > t || nCost > m) continue;
                if (next.idx == cur.prev) continue;

                if (maxCost[next.idx] > nCost) {
                    maxCost[next.idx] = nCost;
                }

                que.add(new Info(next.idx, nDist, nCost, cur.idx));
            }
        }

        if (maxCost[n] == Long.MAX_VALUE) System.out.println(-1);
        else System.out.println(maxCost[n]);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}