import java.io.*;
import java.util.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static class Edge{
        // 간선, 가중치의 정보
        int to, weight;
        Edge(int _to, int _weight) {
            to = _to; weight = _weight;

        }
    }

    static class Info{
        // 시작점 기준으로 idx 정점까지의 비용을 저장하는 class
        // PrioirtyQueue에 사용

        int idx, dist;

        Info(int _idx, int _dist) {
            idx = _idx; dist = _dist;
        }
    }

    static ArrayList<Edge>[] graph;
    static int n, m, t, s, g, h;
    static int[] startToMinDist, candiLoc;
    static void input() throws Exception{

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        // 정점
        m = Integer.parseInt(st.nextToken());
        // 간선
        t = Integer.parseInt(st.nextToken());
        // 목적지 후보의 수

        st = new StringTokenizer(br.readLine());

        s = Integer.parseInt(st.nextToken());
        // 시작점
        g = Integer.parseInt(st.nextToken());
        // g~h 사이
        h = Integer.parseInt(st.nextToken());
        // g~h 사이

        graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        int u, v, w;
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            if (u == g && v == h) {
                graph[u].add(new Edge(v, w * 2 - 1));
                graph[v].add(new Edge(u, w * 2 - 1));
            } else if (u == h && v == g) {
                graph[u].add(new Edge(v, w * 2 - 1));
                graph[v].add(new Edge(u, w * 2 - 1));
            } else {
                graph[u].add(new Edge(v, w * 2));
                graph[v].add(new Edge(u, w * 2));
            }
        }

        candiLoc = new int[t];
        for (int i = 0; i < t; i++) candiLoc[i] = Integer.parseInt(br.readLine());
    }

    static int[] dijkstra(int start) {

        int[] dist = new int[n + 1];
        for (int i = 1; i <= n; i++) dist[i] = 50_000 * 2_000 * 2 + 2;

        dist[start] = 0;

        PriorityQueue<Info> pq = new PriorityQueue<>((o1, o2) -> o1.dist - o2.dist);
        pq.add(new Info(start, 0));

        while (!pq.isEmpty()) {

            Info cur = pq.poll();
            if (dist[cur.idx] != cur.dist) continue; // 최신 정보가 아니라면 continue;
            for (Edge next : graph[cur.idx]) {
                if (dist[next.to] > cur.dist + next.weight) {
                    dist[next.to] = cur.dist + next.weight;
                    pq.add(new Info(next.to, dist[next.to]));
                }
            }
        }
        return dist;
    }

    static void pro() {

        startToMinDist = dijkstra(s);
        Arrays.sort(candiLoc);
        for (int i = 0; i < t; i++) {
            if (startToMinDist[candiLoc[i]] % 2 == 1) {
                sb.append(candiLoc[i]).append(' ');
            }
        }
        sb.append('\n');
    }

    public static void main(String[] args) throws Exception{

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            input();
            pro();
        }
        System.out.println(sb);;

    }
}

/*
 *
 *
 *
 * */

