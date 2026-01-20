import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static class Edge {
        int to;
        long dist;
        Edge(int to, long dist) {
            this.to = to; this.dist = dist;
        }
    }
    
    static long[] costs;
    static int n, m, k;
    static ArrayList<Edge>[] revGraph;
    static TreeSet<Integer> goalSet;

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        revGraph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) revGraph[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u, v, c;
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            revGraph[v].add(new Edge(u, c));
        }

        goalSet = new TreeSet<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            goalSet.add(Integer.parseInt(st.nextToken()));
        }
    }

    static void pro() {
        costs = new long[n + 1];
        Arrays.fill(costs, 1L << 60);

        for (int goal : goalSet) {
            dijkstra(goal);
        }

        long[] max = new long[2];
        for (int i = 1; i <= n; i++) {
            if (goalSet.contains(i)) continue;
            if (max[1] < costs[i]) {
                max[0] = i;
                max[1] = costs[i];
            }
        }

        System.out.printf("%d %d", max[0], max[1]);
    }

    static void dijkstra(int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> Long.compare(o1.dist, o2.dist));
        costs[start] = 0;
        pq.add(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            if (costs[cur.to] != cur.dist) continue;

            for (Edge next : revGraph[cur.to]) {
                long nCost = cur.dist + next.dist;
                if (costs[next.to] <= nCost) continue;

                costs[next.to] = nCost;
                pq.add(new Edge(next.to, nCost));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
