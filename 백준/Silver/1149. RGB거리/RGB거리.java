import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer sb = new StringBuffer();
    static StringTokenizer st;

    static int[][] cost, dp;
    static int n;

    static void input() throws IOException {

        n = Integer.parseInt(br.readLine());
        cost = new int[n][3];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new int[n][3];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
    }

    static void pro() throws IOException {

        dp[0][0] = cost[0][0];
        dp[0][1] = cost[0][1];
        dp[0][2] = cost[0][2];

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    if (j == k) continue;
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][k]);
                }
                dp[i][j] += cost[i][j];
            }
        }

        System.out.println(Math.min(Math.min(dp[n - 1][0], dp[n - 1][1]), dp[n - 1][2]));
    }


    public static void main(String[] args) throws IOException {
        input();
        pro();
    }

}