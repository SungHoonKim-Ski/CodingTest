import java.io.*;
import java.util.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n;
    static int[][] matrix;
    static int[][] prefixSum;
    static int[][] dp;


    static void input() throws Exception {
        n = Integer.parseInt(br.readLine());
        matrix = new int[n + 1][2];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            matrix[i] = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        }
    }

    public static void pro() {
        dp = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(dp[i], -1);
            dp[i][i] = 0;
        }

        System.out.println(recur(1, n));
    }

    static int recur(int i, int j) {
        if (dp[i][j] != -1) return dp[i][j];

        dp[i][j] = Integer.MAX_VALUE;

        for (int x = i; x < j; x++) {
            int cost = matrix[i][0] * matrix[x][1] * matrix[j][1];

            dp[i][j] = Math.min(dp[i][j], recur(i, x) + recur(x + 1, j) + cost);
        }

        return dp[i][j];
    }

    public static void main(String[] args) throws Exception{
        input();
        pro();
    }
}