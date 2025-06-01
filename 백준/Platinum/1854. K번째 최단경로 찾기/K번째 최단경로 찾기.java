import java.io.*;
import java.util.*;

public class Main {

    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static class Edge {
        int idx, cost;
        Edge(int idx, int cost) {
            this.idx = idx; this.cost = cost;
        }
    }

    static int n, m, k;
    static ArrayList<Edge>[] graph;
    static PriorityQueue<Integer>[] dist;

    static int MAX_VALUE = Integer.MAX_VALUE / 2 - 1;

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        dist = new PriorityQueue[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
            dist[i] = new PriorityQueue<>((o1, o2) -> o2 - o1);
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[start].add(new Edge(end, cost));
        }
    }

    static void pro() {
        dijkstra(1);
        for (int i = 1; i <= n; i++) {
            if (dist[i].size() < k) System.out.println(-1);
            else System.out.println(dist[i].poll());
        }
    }

    static void dijkstra(int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);

        dist[start].add(0);
        pq.add(new Edge(start, 0));

        while (pq.size() != 0) {
            Edge cur = pq.poll();

            for (Edge next: graph[cur.idx]) {
                int nextCost = cur.cost + next.cost;
                
                if (dist[next.idx].size() < k) {
                    dist[next.idx].add(nextCost);
                    pq.add(new Edge(next.idx, nextCost));
                    continue;
                }
                
                if (dist[next.idx].peek() <= nextCost) continue;

                nextCost = Math.min(dist[next.idx].poll(), nextCost);
                dist[next.idx].add(nextCost);
                pq.add(new Edge(next.idx, nextCost));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}