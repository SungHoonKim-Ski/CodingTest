import java.io.*;
import java.util.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer sb = new StringBuffer();
    static StringTokenizer st;

    static int n;
    static int[][] dp;

    static void input() throws IOException{
        n = Integer.parseInt(br.readLine());
        dp = new int[n + 1][10];
    }

    static void pro() {

        for (int i = 0; i <= 9; i++) {
            dp[1][i] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= 9; j++) {
                for (int k = j; k <= 9; k++) {
                    dp[i + 1][k] += dp[i][j];
                    dp[i + 1][k] %= 10_007;
                }
            }
        }

        int sum = 0;
        for (int i = 0; i <= 9; i++) {
            sum += dp[n][i];
            sum %= 10_007;
        }
        System.out.println(sum);
    }

    public static void main(String[] args) throws Exception{
        input();
        pro();
    }
}