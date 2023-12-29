import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer sb = new StringBuffer();
    static StringTokenizer st;

    static class Edge {
        int to, weight;
        Edge(int _to, int _weight) {
            to = _to; weight = _weight;
        }
    }

    static class Info implements Comparable<Info>{
        int idx, dist;
        Info(int _idx, int _dist) {
            idx = _idx; dist = _dist;
        }

        @Override
        public int compareTo(Info o1) {
            return dist - o1.dist;
        }
    }

    static ArrayList<Edge>[] graph;
    static int[][] dists;
    static int[] loc;
    static int n, m, k;
    static void input() throws IOException{
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        dists = new int[n + 1][];
        graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph[start].add(new Edge(end, weight));
        }

        k = Integer.parseInt(br.readLine());
        loc = new int[k];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            loc[i] = Integer.parseInt(st.nextToken());
        }
    }

    static int[] dijkstra(int start) {

        int[] dist = new int[n + 1];
        for (int i = 1; i <= n; i++) dist[i] = Integer.MAX_VALUE;
        dist[start] = 0;

        PriorityQueue<Info> pq = new PriorityQueue<>();
        pq.add(new Info(start, 0));

        while (!pq.isEmpty()) {
            Info cur = pq.poll();

            if (cur.dist != dist[cur.idx]) continue;

            for (Edge next : graph[cur.idx]) {
                if (dist[next.to] > next.weight + cur.dist) {
                    dist[next.to] = next.weight + cur.dist;
                    pq.add(new Info(next.to, dist[next.to]));
                }
            }

        }
        return dist;
    }


    static void pro(){

        for (int i = 1; i <= n; i++) {
            dists[i] = dijkstra(i);
        }

        int maxDist = Integer.MAX_VALUE;
        TreeSet<Integer> maxLoc = new TreeSet<>();

        for (int i = 1; i <= n; i++) { // 현재 도시 i
            int curMaxDist = Integer.MIN_VALUE;

            for (int j = 0; j < k; j++) {
                if (dists[i][loc[j]] == Integer.MAX_VALUE || dists[loc[j]][i] == Integer.MAX_VALUE) continue;

                int sum = dists[i][loc[j]] + dists[loc[j]][i];
                curMaxDist = Math.max(sum, curMaxDist);
            }

            if (curMaxDist == Integer.MIN_VALUE) continue;

            if (maxDist > curMaxDist) {
                maxDist = curMaxDist;
                maxLoc.clear();
                maxLoc.add(i);
            } else if (maxDist == curMaxDist) {
                maxLoc.add(i);
            }
        }

        for (int i : maxLoc) {
            sb.append(i).append(' ');
        }
        System.out.println(sb);

    }

    public static void main(String[] args) throws IOException{
        input();
        pro();

    }

}