import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int n, p, q;
    static ArrayList<Edge>[] graph;
    static ArrayList<Integer> need;

    static class Edge {
        int to;
        long cost;

        Edge(int to, long cost) {
            this.to = to; this.cost = cost;
        }
    }

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        need = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            need.add(Integer.parseInt(br.readLine()));
        }

        graph = new ArrayList[p + 1];
        for (int i = 1; i <= p; i++) graph[i] = new ArrayList<>();
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            graph[x].add(new Edge(y, z));
            graph[y].add(new Edge(x, z));
        }

    }

    static void pro() {
        long[] res = new long[p + 1];

        for (int i = 0; i < n; i++) {
            long[] dist = dijkstra(need.get(i));
            for (int j = 1; j <= p; j++) {
                if (res[j] == 1L << 60 || dist[j] == 1L << 60) {
                    res[j] = 1L << 60;
                    continue;
                }

                res[j] += dist[j] * dist[j];
            }
        }

        long min = 1L << 60, pos = -1;
        for (int i = 1; i <= p; i++) {
            if (res[i] < min) {
                min = res[i];
                pos = i;
            }
        }

        sb.append(pos).append(' ').append(min).append('\n');
    }

    static long[] dijkstra(int start) {
        long[] cost = new long[p + 1];
        Arrays.fill(cost, 1L << 60);

        PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> Long.compare(o1.cost, o2.cost));
        cost[start] = 0;
        pq.add(new Edge(start, 0));

        while(!pq.isEmpty()) {
            Edge cur = pq.poll();
//            System.out.println(cur.to + " " + cur.cost);
            if (cur.cost != cost[cur.to]) continue;

            for (Edge next : graph[cur.to]) {
                long nc = next.cost + cur.cost;

                if (nc >= cost[next.to]) continue;
                cost[next.to] = nc;
                pq.add(new Edge(next.to, nc));
            }
        }

        return cost;
    }

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            input();
            pro();
        }

        System.out.println(sb);
    }
}