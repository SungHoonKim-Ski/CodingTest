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

    static int N, M, X;
    static int[] dist, homeToX, xToHome;
    static ArrayList<Edge>[] edges;

    static void input() throws IOException{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());


        edges = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) edges[i] = new ArrayList<Edge>();
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            edges[from].add(new Edge(to, weight));
        }
        homeToX = new int[N + 1];
        xToHome = new int[N + 1];
        dist = new int[N + 1];
    }

    static void dijkstra(int start) {

        for (int i = 1; i <= N; i++) dist[i] = Integer.MAX_VALUE;

        PriorityQueue<Info> pq = new PriorityQueue<>((o1, o2) -> o1.dist - o2.dist);

        dist[start] = 0;
        pq.add(new Info(start, 0));

        // 거리 정보들이 모두 소진될 때까지 거리 갱신을 반복한다.
        while (!pq.isEmpty()) {
            Info info = pq.poll();

            // 꺼낸 정보가 최신 정보랑 다르면, 의미없이 낡은 정보이므로 폐기한다.
            if (info.dist != dist[info.idx]) continue;
            
            for (Edge e : edges[info.idx]) {
                if (dist[e.to] > info.dist + e.weight) {
                    dist[e.to] = info.dist + e.weight;
                    pq.add(new Info(e.to, dist[e.to]));
                }
            }
        }
    }

    static void pro() {

        for (int i = 1; i <= N; i++) {
            dijkstra(i);
            homeToX[i] = dist[X];
        }
        dijkstra(X);
        for (int i = 1; i <= N; i++) {
            xToHome[i] = dist[i];
        }

        int maxDist = 0;
        for (int i = 1; i <= N; i++) {
            maxDist = Math.max(maxDist, xToHome[i] + homeToX[i]);
        }

        System.out.print(maxDist);
    }

    public static void main(String[] args) throws IOException{
        input();
        pro();
    }


}