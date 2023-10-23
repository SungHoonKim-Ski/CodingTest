import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static class Edge {
        public int to, weight;

        public Edge(int _to, int _weight) {
            this.to = _to;
            this.weight = _weight;
        }
    }

    static class Info {
        public int idx, dist;

        public Info(int _idx, int _dist) {
            this.idx = _idx;
            this.dist = _dist;
        }
    }

    static int N, M;
    static int[] dist;
    static ArrayList<Edge>[] edges;

    static void input() throws IOException{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dist = new int[N + 1];
        edges = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) edges[i] = new ArrayList<Edge>();
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            // 양방향 그래프이므로 둘 다 입력
            edges[from].add(new Edge(to, weight));
            edges[to].add(new Edge(from, weight));
        }
    }

    static void dijkstra(int start) {

        for (int i = 1; i <= N; i++) dist[i] = Integer.MAX_VALUE;

        PriorityQueue<Info> pq = new PriorityQueue<>((o1, o2) -> o1.dist - o2.dist);

        dist[start] = 0;
        pq.add(new Info(start, 0));

        while (!pq.isEmpty()) {
            Info info = pq.poll();

            if (info.dist != dist[info.idx]) continue;
            
            for (Edge e : edges[info.idx]) {
                if (dist[e.to] > info.dist + e.weight) {
                    dist[e.to] = info.dist + e.weight;
                    pq.add(new Info(e.to, dist[e.to]));
                }
            }
        }
        System.out.println(dist[N]);
    }

    static void pro() {
        dijkstra(1);
    }

    public static void main(String[] args) throws IOException{
        input();
        pro();
    }


}