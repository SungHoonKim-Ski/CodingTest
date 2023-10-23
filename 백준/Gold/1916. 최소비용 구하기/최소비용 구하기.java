import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N, M;
    static int start, end;
    static ArrayList<Edge>[] graph;
    static int[] dist;

    static class Edge{
        int to, weight;
        Edge(int _to, int _weight) {
            to = _to; weight = _weight;
        }
    }

    static class Info{
        int idx, dist;
        Info(int _idx, int _dist) {
            idx = _idx; dist = _dist;
        }
    }

    static void input() throws IOException{
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph[s].add(new Edge(e, weight));
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        dist = new int[N + 1];
    }

    static void dijkstra(int start) {

        for (int i = 1; i <= N; i++) dist[i] = Integer.MAX_VALUE;
        dist[start] = 0;

        PriorityQueue<Info> pq = new PriorityQueue<>((o1, o2) -> o1.dist - o2.dist);
        pq.add(new Info(start, 0));

        while (!pq.isEmpty()) {

            Info cur = pq.poll();
            if (dist[cur.idx] != cur.dist) continue;
            for (Edge e : graph[cur.idx]) {
                if (dist[e.to] > e.weight + cur.dist) {
                    dist[e.to] = e.weight + cur.dist;
                    pq.add(new Info(e.to, dist[e.to]));
                }
            }
        }

    }

    static void pro() {
        dijkstra(start);
        System.out.println(dist[end]);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}