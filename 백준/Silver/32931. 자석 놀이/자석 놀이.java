import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n;
    static long[][] arr, dp;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        arr = new long[2][n];
        for (int i = 0; i < 2; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Long.parseLong(st.nextToken());
            }
        }

        dp = new long[2][n];
        dp[0][0] = Math.max(arr[0][0], arr[0][0] + arr[1][0]);
        dp[1][0] = arr[0][0] + arr[1][0];

        for (int i = 1; i < n; i++) {
            long top = arr[0][i];
            long bottom = arr[1][i];

            long cand1 = dp[0][i - 1] + top;
            long cand2 = dp[0][i - 1] + top + bottom;
            long cand3 = dp[1][i - 1] + top + bottom;
            dp[0][i] = Math.max(Math.max(cand1, cand2), cand3);

            cand1 = dp[1][i - 1] + bottom;
            cand2 = dp[1][i - 1] + top + bottom;
            cand3 = dp[0][i - 1] + top + bottom;
            dp[1][i] = Math.max(Math.max(cand1, cand2), cand3);
        }

        System.out.println(dp[1][n - 1]);
    }
}