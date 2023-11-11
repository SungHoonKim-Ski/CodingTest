import java.io.*;
import java.util.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static final int INF = Integer.MAX_VALUE;

    static class Info{
        // 시작점 기준으로 idx 정점까지의 비용을 저장하는 class
        // PrioirtyQueue에 사용

        int idx;
        long dist;

        Info(int _idx, long _dist) {
            idx = _idx; dist = _dist;
        }
    }

    static int[][] graph;
    static int n, m, v1, v2;
    static long[] minDist;

    static void input() throws Exception{

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        // 정점
        m = Integer.parseInt(st.nextToken());
        // 간선

        graph = new int[n + 1][n + 1];

        int u, v, w;
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            graph[u][v] = w;
            graph[v][u] = w;
        }

        st = new StringTokenizer(br.readLine());

        v1 = Integer.parseInt(st.nextToken());
        // 시작점
        v2 = Integer.parseInt(st.nextToken());
        // 도착점
    }

    static long dijkstra(int start, int end) {

        minDist = new long[n + 1];
        for (int i = 1; i <= n; i++) minDist[i] = INF;
        minDist[start] = 0;

        PriorityQueue<Info> pq = new PriorityQueue<>((o1, o2) -> Long.compare(o1.dist, o2.dist));
        pq.add(new Info(start, 0));

        while (!pq.isEmpty()) {

            Info cur = pq.poll();

            if (cur.dist != minDist[cur.idx]) continue;
            for (int next = 1; next <= n; next++) {
                if(graph[cur.idx][next] == 0) continue;
                if (minDist[next] > cur.dist + (long)graph[cur.idx][next]) {
                    minDist[next] = cur.dist + (long)graph[cur.idx][next];
                    pq.add(new Info(next, minDist[next]));
                }
            }
        }

        return minDist[end];
    }

    static void pro() {


        long sum1, sum2;
        sum2 = sum1 = 0;
        sum1 += dijkstra(1, v1);
        sum1 += dijkstra(v1, v2);
        sum1 += dijkstra(v2, n);

        sum2 += dijkstra(1, v2);
        sum2 += dijkstra(v2, v1);
        sum2 += dijkstra(v1, n);

        long distSum = Math.min(sum1, sum2);
        if (distSum >= INF) distSum = -1;
        System.out.println(distSum);
    }

    public static void main(String[] args) throws Exception{

        input();
        pro();

    }
}

