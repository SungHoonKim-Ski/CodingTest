import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n, m, q;
    static ArrayList<Integer>[] graph;

    static void input() throws IOException{
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
        }
    }

    static void pro() throws IOException{
        int[][] costs = new int[n + 1][];
        for (int i = 1; i <= n; i++) {
            costs[i] = bfs(i);
        }

        while (q-- > 0) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            int min = Integer.MAX_VALUE;
            for (int i = 1; i <= n; i++) {
                int c1 = costs[i][u];
                int c2 = costs[i][v];

                if (c1 == Integer.MAX_VALUE || c2 == Integer.MAX_VALUE) continue;
                min = Math.min(min, Math.max(c1, c2));
            }

            if (min == Integer.MAX_VALUE) min = -1;
            sb.append(min);

            sb.append('\n');
        }
        System.out.println(sb);
    }

    static int[] bfs(int start) {
        int[] cost = new int[n + 1];
        Arrays.fill(cost, Integer.MAX_VALUE);

        cost[start] = 0;
        Queue<int[]> que = new ArrayDeque<>();
        que.add(new int[] {start, 0});

        while (!que.isEmpty()) {
            int[] cur = que.poll();

            for (int next : graph[cur[0]]) {
                if (cost[next] != Integer.MAX_VALUE) continue;
                cost[next] = cur[1] + 1;
                que.add(new int[] {next, cost[next]});
            }
        }

        return cost;
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}