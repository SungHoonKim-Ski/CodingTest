import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int n;
    static int[] arr;
    static int[][][] dp;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        dp = new int[n][2][2];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            for (int j = 0; j < 2; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        System.out.println(recur(0, 0, 0));
    }

    static int recur(int cur, int turn, int use) {
        if (cur + use == n) return 0;

        if (dp[cur][turn][use] != -1) return dp[cur][turn][use];

        if (turn == 0) {
            int res = recur(cur + 1, 1, use) + arr[cur];
            if (use == 0) {
                res = Math.max(res, recur(cur, 1, 1) + arr[n - 1]);
            }
            return dp[cur][turn][use] = res;
        } else {
            int res = recur(cur + 1, 0, use);

            if (use == 0) {
                res = Math.max(res, recur(cur, 0, 1));
            }
            return dp[cur][turn][use] = res;
        }
    }
}