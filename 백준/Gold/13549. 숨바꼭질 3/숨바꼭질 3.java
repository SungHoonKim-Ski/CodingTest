import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, k;
    static int MAX = 100_000;

    static int[] dx = {1, -1};
    static int[] cost;


    static void input() throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
    }

    public static void pro() {

        cost = new int[MAX + 1];
        Arrays.fill(cost, Integer.MAX_VALUE);
        PriorityQueue<int[]> que = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

        que.add(new int[] {n, 0});
        cost[n] = 0;

        while (!que.isEmpty()) {
            int[] cur = que.poll();
            if (cur[0] == k) {
                System.out.println(cur[1]);
                return;
            }

            for (int i = 0; i < 2; i++) {
                int next = cur[0] + dx[i];
                if (next == -1 || next > MAX) continue;
                if (cost[next] != Integer.MAX_VALUE) continue;

                cost[next] = cur[1] + 1;
                que.add(new int[] {next, cost[next]});
            }
            int next = cur[0] * 2;
            if (next > MAX) continue;
            if (cost[next] <= cur[1]) continue;

            cost[next] = cur[1];
            que.add(new int[] {next, cost[next]});
        }
    }

    public static void main(String[] args) throws Exception {
        input();
        pro();
    }
}