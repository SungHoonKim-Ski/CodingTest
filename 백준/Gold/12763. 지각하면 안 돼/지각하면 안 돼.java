import java.io.*;
import java.util.*;


public class Main {

    static class Info {
        int to, time, cost;
        Info(int to, int time, int cost) {
            this.to = to; this.time = time; this.cost = cost;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, t, m, l;
    static ArrayList<Info>[] graph;

    static void input() throws Exception {
        n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        t = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        l = Integer.parseInt(br.readLine());
        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();
        for (int i = 0; i < l; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[start].add(new Info(end, time, cost));
            graph[end].add(new Info(start, time, cost));
        }
    }

    public static void pro() {
        int[][] dist = new int[n + 1][10_001];

        for (int i = 1; i <= n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }


        PriorityQueue<Info> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        dist[1][0]= 0;
        pq.add(new Info(1, 0, 0));

        while (!pq.isEmpty()) {
            Info cur = pq.poll();
            if (dist[cur.to][cur.time] != cur.cost) continue;

            for (Info next: graph[cur.to]) {
                int nCost = cur.cost + next.cost;
                int nTime = cur.time + next.time;
                if (nCost > m) continue;
                if (nTime > t) continue;
                if (dist[next.to][nTime] <= nCost) continue;
                dist[next.to][nTime] = nCost;
                pq.add(new Info(next.to, nTime, nCost));
            }
        }

        int result = Integer.MAX_VALUE;
        for (int i = 1; i <= 10_000; i++) {
            if (dist[n][i] != Integer.MAX_VALUE) result = Math.min(dist[n][i], result);
        }
        if (result == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(result);
    }


    public static void main(String[] args) throws Exception{
        input();
        pro();
    }
}
