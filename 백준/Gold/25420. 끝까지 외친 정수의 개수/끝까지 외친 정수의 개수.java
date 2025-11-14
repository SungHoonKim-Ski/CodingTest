import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n, k, sum;
    static boolean[] visit = new boolean[100110];
    static int[][] dp = new int[100110][2];

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        while (st.hasMoreElements()) {
            int v = Integer.parseInt(st.nextToken());
            visit[v] = true;
        }

        recur(0);

        System.out.println(recur(0)[1]);
    }

    static int[] recur(int cur) {
        if (cur == n) return new int[] {2, 0};
        if (dp[cur][0] != 0) return dp[cur];

        int res = 1;
        for (int i = 1; i <= k; i++) {
            int next = cur + i;
            if (next > n || visit[next]) continue;

            if (recur(next)[0] == 2) res = 2;
        }

        if (res == 1) { // 짐
            dp[cur][0] = 2;
            dp[cur][1] = 0;
            for (int i = 1; i <= k; i++) {
                int next = cur + i;
                if (next > n || visit[next]) continue;
                
                dp[cur][1] = Math.max(dp[cur][1], dp[cur + i][1] + 1);
            }
        } else { // 이김
            dp[cur][0] = 1;
            dp[cur][1] = Integer.MAX_VALUE;
            for (int i = 1; i <= k; i++) {
                int next = cur + i;
                if (next > n || visit[next]) continue;

                if (recur(next)[0] == 2) {
                    dp[cur][1] = Math.min(dp[cur][1], dp[cur + i][1] + 1);
                }
            }
        }

        return dp[cur];
    }
}