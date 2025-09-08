import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int v, e;
    static ArrayList<Edge>[] graph;
    static long mac, star, x, y;
    static long[] macDist, starDist;
    static int[] map;
    static PriorityQueue<Edge> macQue, starQue;

    static class Edge {
        int to;
        long dist;

        Edge(int _to, long _dist) {
            this.to = _to; this.dist = _dist;
        }
    }

    static void input() throws Exception {
        st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        graph = new ArrayList[v + 1];
        for (int i = 1; i <= v; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[u].add(new Edge(v, w));
            graph[v].add(new Edge(u, w));
        }

        macDist = new long[v + 1];
        Arrays.fill(macDist, Long.MAX_VALUE);
        starDist = new long[v + 1];
        Arrays.fill(starDist, Long.MAX_VALUE);
        map = new int[v + 1];
        macQue = new PriorityQueue<Edge>((o1, o2) -> Long.compare(o1.dist, o2.dist));
        starQue = new PriorityQueue<Edge>((o1, o2) -> Long.compare(o1.dist, o2.dist));

        st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        mac = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < x; i++) {
            int m = Integer.parseInt(st.nextToken());
            macDist[m] = 0;
            macQue.add(new Edge(m, 0));
            map[m] = 1;
        }

        st = new StringTokenizer(br.readLine());
        y = Integer.parseInt(st.nextToken());
        star = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < y; i++) {
            int s = Integer.parseInt(st.nextToken());
            starDist[s] = 0;
            starQue.add(new Edge(s, 0));
            map[s] = 2;
        }
    }

    public static void pro() {
        dijkstra(macQue, macDist, mac);
        dijkstra(starQue, starDist, star);

        long min = Long.MAX_VALUE;
        for (int i = 1; i <= v; i++) {
            if (starDist[i] == Long.MAX_VALUE || macDist[i] == Long.MAX_VALUE) continue;
            if (map[i] != 0) continue;
            min = Math.min(min, starDist[i] + macDist[i]);
        }

        if (min == Long.MAX_VALUE) min = -1;

        System.out.println(min);
    }

    static void dijkstra(PriorityQueue<Edge> que, long[] dist, long max) {
        while (!que.isEmpty()) {
            Edge cur = que.poll();
            if (dist[cur.to] != cur.dist) continue;

            for (Edge nextInfo : graph[cur.to]) {
                int next = nextInfo.to;
                long distSum = dist[cur.to] + nextInfo.dist;
                if (dist[next] <= distSum) continue;
                if (distSum > max) continue;
                dist[next] = distSum;
                que.add(new Edge(next, dist[next]));
            }
        }
    }

    public static void main(String[] args) throws Exception {
        input();
        pro();
    }
}