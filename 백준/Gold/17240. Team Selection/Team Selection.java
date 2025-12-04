import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int n;
    static int[][] arr, dp;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        arr = new int[n][5];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new int[n][1 << 5];
        for (int i = 0; i < n; i++) Arrays.fill(dp[i], -1);

        System.out.println(recur(0, 0));
    }

    static int recur(int cur, int visit) {
        if (cur == n || visit == (1 << 5) - 1) {
            return 0;
        }

        if (dp[cur][visit] != -1) return dp[cur][visit];

        int max = recur(cur + 1, visit);

        for (int i = 0; i < 5; i++) {
            if ((visit & (1 << i)) != 0) continue;

            max = Math.max(max, recur(cur + 1, visit | (1 << i))+ arr[cur][i]);
        }

        return dp[cur][visit] = max;
    }
}