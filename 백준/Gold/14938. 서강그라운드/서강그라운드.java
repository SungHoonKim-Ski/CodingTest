import java.util.*;
import java.io.*;

class Main{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static class Info {
        int idx, dist;
        Info(int _idx, int _dist) {
            idx = _idx; dist = _dist;
        }
    }

    static class Edge {
        int to, weight;

        Edge(int _to, int _weight) {
            to = _to; weight = _weight;
        }
    }

    static int n, m, r;
    static int[] cost;

    static ArrayList<Edge>[] graph;

    static void input() throws IOException{
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        cost = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) cost[i] = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[start].add(new Edge(end, cost));
            graph[end].add(new Edge(start, cost));
        }
    }

    static void pro() {
        int maxItem = 0;

        for (int i = 1; i <= n; i++) {
            int[] dist = dijkstra(i);
            int itemSum = 0;
            for (int j = 1; j <= n; j++) {
                if (dist[j] > m) continue;
                itemSum += cost[j];
            }
            maxItem = Math.max(maxItem, itemSum);
        }
        System.out.println(maxItem);
    }

    static int[] dijkstra(int start) {

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<Info> pq = new PriorityQueue<>((o1, o2) -> o1.dist - o2.dist);
        pq.add(new Info(start, 0));

        while(pq.size() != 0) {
            Info cur = pq.poll();

            if (dist[cur.idx] != cur.dist) continue;

            for (Edge next : graph[cur.idx]) {

                if (dist[next.to] <= next.weight + cur.dist) continue;
                dist[next.to] = next.weight + cur.dist;
                pq.add(new Info(next.to, dist[next.to]));

            }
        }
        return dist;
    }


    public static void main(String[] args) throws IOException{
        input();
        pro();
    }
}