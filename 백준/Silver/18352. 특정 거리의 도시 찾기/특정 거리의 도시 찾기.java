import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, m, k, x;
    static List<Integer>[] graph;
    static int[] cost;

    static final int MAX = 300_001;

    static void input() throws Exception {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            graph[s].add(e);
        }
    }


    public static void pro() {
        cost = new int[n + 1];
        Arrays.fill(cost, MAX);

        dijkstra(x);

        for (int i = 1; i <= n; i++) {
            if (cost[i] == k) {
                sb.append(i).append('\n');
            }
        }
        if (sb.length() == 0) sb.append(-1);

        System.out.println(sb);
    }

    static void dijkstra(int start) {
        cost[start] = 0;
        PriorityQueue<int[]> que = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        que.add(new int[] {start, 0});

        while (!que.isEmpty()) {
            int[] cur = que.poll();
            if (cost[cur[0]] != cur[1]) continue;
            if (cur[1] > k) return;

            for (int next : graph[cur[0]]) {
                if (cost[next] != MAX) continue;
                cost[next] = cur[1] + 1;
                que.add(new int[] {next, cost[next]});
            }
        }
    }

    public static void main(String[] args) throws Exception {
        input();
        pro();
    }
}