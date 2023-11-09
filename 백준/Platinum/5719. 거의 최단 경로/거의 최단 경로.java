import java.io.*;
import java.util.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static final int INF = Integer.MAX_VALUE;

//    static class Edge{
//        // 간선, 가중치의 정보
//        int to, weight;
//        Edge(int _to, int _weight) {
//            to = _to; weight = _weight;
//
//        }
//    }

    static class Info{
        // 시작점 기준으로 idx 정점까지의 비용을 저장하는 class
        // PrioirtyQueue에 사용

        int idx;
        long dist;

        Info(int _idx, long _dist) {
            idx = _idx; dist = _dist;
        }
    }

    static int[][] graph, revGraph;
    static int n, m, s, d;
    static long[] minDist, secondMinDist;

    static boolean[][] visitEdge;
    static boolean[] visitVertex;

    static boolean input() throws Exception{

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        // 정점
        m = Integer.parseInt(st.nextToken());
        // 간선
        if (n == 0 && m == 0) return false;

        st = new StringTokenizer(br.readLine());

        s = Integer.parseInt(st.nextToken());
        // 시작점
        d = Integer.parseInt(st.nextToken());
        // 도착점

        graph = new int[n][n];
        revGraph = new int[n][n];

        visitEdge = new boolean[n][n];
        visitVertex = new boolean[n];

        int u, v, w;
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            graph[u][v] = w;
            revGraph[v][u] = w;
        }
        return true;
    }

    static void dijkstra(int start) {

        minDist = new long[n];
        for (int i = 0; i < n; i++) minDist[i] = INF;
        minDist[start] = 0;

        PriorityQueue<Info> pq = new PriorityQueue<>((o1, o2) -> Long.compare(o1.dist, o2.dist));
        pq.add(new Info(start, 0));

        while (!pq.isEmpty()) {

            Info cur = pq.poll();

            if (cur.dist != minDist[cur.idx]) continue;
            for (int next = 0; next < n; next++) {
                if(graph[cur.idx][next] == 0) continue;
                if (minDist[next] > cur.dist + (long)graph[cur.idx][next]) {
                    minDist[next] = cur.dist + (long)graph[cur.idx][next];
                    pq.add(new Info(next, minDist[next]));
                }
            }
        }
    }

    static void bfs(int end) {

        boolean[] visit = new boolean[n];
        visit[end] = true;

//        int[] visitLog = new int[n];

//        visit[end] = true;
        Deque<Integer> que = new ArrayDeque<>();
        que.add(end);

        while (!que.isEmpty()) {

            int cur = que.poll();

            for (int next = 0; next < n; next++) {
                if (revGraph[cur][next] == 0) continue;
//                if (visit[next]) continue;
                if (minDist[next] == minDist[cur] - revGraph[cur][next]) {
                    graph[next][cur] = INF;

                    if (visit[next]) continue;
                    visit[next] = true;
                    que.add(next);
                }

            }
        }

        int curIdx = s;

//        while (curIdx != d) {
//            visitEdge[curIdx][visitLog[curIdx]] = true;
//            curIdx = visitLog[curIdx];
//        }

    }

//    static boolean dfs(int curIdx, int depth) {
//
//        if (curIdx == s) {
//            return true;
//        }
//        if (depth == n) {
//            return false;
//        }
//
//        boolean flag = false;
//
//        for (Edge next : revGraph[curIdx]) {
//            if (visitVertex[next.to]) continue;
//            if (minDist[next.to] == minDist[curIdx] - next.weight) {
//                visitEdge[next.to][curIdx] = true;
//                if (!dfs(next.to, depth + 1)) {
//                    visitEdge[next.to][curIdx] = false;
//                } else flag = true;
//            }
//        }
//
//        return flag;
//    }

//    static void secondDijkstra(int start) {
//
//        secondMinDist = new int[n];
//        for (int i = 0; i < n; i++) secondMinDist[i] = INF;
//        secondMinDist[start] = 0;
//
//        PriorityQueue<Info> pq = new PriorityQueue<>((o1, o2) -> o1.dist - o2.dist);
//        pq.add(new Info(start, 0));
//
//        while (!pq.isEmpty()) {
//
//            Info cur = pq.poll();
//
//            for (Edge next : graph[cur.idx]) {
//
//                if (cur.dist != secondMinDist[cur.idx]) continue;
//                if (visitEdge[cur.idx][next.to]) continue;
//
//                if (secondMinDist[next.to] > cur.dist + next.weight) {
//                    secondMinDist[next.to] = cur.dist + next.weight;
//                    pq.add(new Info(next.to, cur.dist + next.weight));
//                }
//            }
//        }
//    }

    static void pro() {

        dijkstra(s);

        bfs(d);

        dijkstra(s);
        if (minDist[d] >= INF) minDist[d] = -1;
        sb.append(minDist[d]);
        sb.append('\n');
    }

    public static void main(String[] args) throws Exception{

        while (true) {
            if (!input()) break;
            pro();
        }
        System.out.println(sb);;

    }
}
