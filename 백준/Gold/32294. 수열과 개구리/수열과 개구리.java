import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static class Info {
        int loc;
        long dist;

        Info(int loc, long dist) {
            this.loc = loc; this.dist = dist;
        }
    }

    static int n;
    static int[] a;
    static long[] b;
    static long[] cost;

    static ArrayList<Integer>[] revGraph;
    static PriorityQueue<Info> pq;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        revGraph = new ArrayList[n + 1];
        pq = new PriorityQueue<>((o1, o2) -> Long.compare(o1.dist, o2.dist));

        a = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            revGraph[i] = new ArrayList<>();
            a[i] = Integer.parseInt(st.nextToken());
        }

        b = new long[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        cost = new long[n + 1];
        Arrays.fill(cost, Long.MAX_VALUE);

        for (int i = 1; i <= n; i++) {
            if (i + a[i] > n || i - a[i] < 1) {
                cost[i] = b[i];
                pq.add(new Info(i, b[i]));
            } else {
                revGraph[i + a[i]].add(i);
                revGraph[i - a[i]].add(i);
            }
        }

        while (!pq.isEmpty()) {
            Info cur = pq.poll();
            if (cur.dist != cost[cur.loc]) continue;

            for (int next : revGraph[cur.loc]) {
                long nextCost = b[next] + cur.dist;

                if (cost[next] <= nextCost) continue;

                cost[next] = nextCost;
                pq.add(new Info(next, nextCost));
            }
        }

        for (int i = 1; i <= n; i++) sb.append(cost[i]).append(' ');
        System.out.println(sb);
    }
}