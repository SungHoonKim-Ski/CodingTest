import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static class Edge {
        int to;
        long cost;
        Edge(int to, long cost) {
            this.to = to; this.cost = cost;
        }
    }

    static int n, m, a, b;
    static long c;
    static ArrayList<Edge>[] graph;

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Long.parseLong(st.nextToken());

        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int j = 0; j < m; j++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            graph[x].add(new Edge(y, z));
            graph[y].add(new Edge(x, z));
        }
    }

    static void pro() {
        long left = 1, right = 1L << 60;
        long res = -1;
        while (left <= right) {
            long mid = (left + right) / 2;
            if (dijkstra(mid)) {
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        System.out.println(res);
    }

    static boolean dijkstra(long maxCost) {
        long[] cost = new long[n + 1];
        Arrays.fill(cost, 1L << 60);
        cost[a] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> Long.compare(o1.cost, o2.cost));
        pq.add(new Edge(a, 0));

        while(!pq.isEmpty()) {
            Edge cur = pq.poll();
            if (cur.cost != cost[cur.to]) continue;

            for (Edge next : graph[cur.to]) {
                long nc = cur.cost + next.cost;
                if (next.cost > maxCost) continue;
                if (nc > c) continue;
                if (cost[next.to] <= nc) continue;
                cost[next.to] = nc;
                pq.add(new Edge(next.to, nc));
            }
        }


        return cost[b] != 1L << 60;
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
