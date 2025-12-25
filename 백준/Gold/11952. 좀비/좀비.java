import java.io.*;
import java.util.*;

public class Main {

    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int n, m, k, s, p, q;

    static boolean[] visit, zombie;
    static long[] dist;
    static int[] cost;
    static ArrayList<Integer>[] graph;
    static HashSet<Integer> zombieSet;

    static class Edge {
        int idx;
        long dist;
        Edge(int idx, long dist) {
            this.idx = idx; this.dist = dist;
        }
    }

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        p = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        zombieSet = new HashSet<>();
        zombie = new boolean[n + 1];
        for (int i = 0; i < k; i++) {
            int z = Integer.parseInt(br.readLine());
            zombieSet.add(z);
            zombie[z] = true;
        }

        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x].add(y);
            graph[y].add(x);
        }
    }

    static void checkNotSafe() {
        cost = new int[n + 1];
        Arrays.fill(cost, p);
        visit = new boolean[n + 1];

        Queue<int[]> que = new ArrayDeque<>();
        for (int z : zombieSet) {
            que.add(new int[] {z, s});
            visit[z] = true;
            cost[z] = q;
        }

        while (!que.isEmpty()) {
            int[] cur = que.poll();
            if (cur[1] == 0) break;

            for (int next : graph[cur[0]]) {
                if (visit[next]) continue;
                visit[next] = true;
                que.add(new int[] {next, cur[1] - 1});
                cost[next] = q;
            }
        }

        cost[1] = cost[n] = 0;
    }

    static void dijkstra(int start) {
        dist = new long[n + 1];
        Arrays.fill(dist, 1L << 60);

        dist[start] = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> Long.compare(o1.dist, o2.dist));
        pq.add(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();

            int curIdx = cur.idx;
            long curDist = cur.dist;
            if (dist[curIdx] != curDist) continue;

            for (int next : graph[curIdx]) {
                if (zombie[next]) continue;

                long nextDist = curDist + cost[next];

                if (dist[next] <= nextDist) continue;
                dist[next] = nextDist;
                pq.add(new Edge(next, nextDist));
            }
        }
    }

    static void pro() {
        checkNotSafe();
        dijkstra(1);

        System.out.println(dist[n]);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}