import java.io.*;
import java.util.*;

public class Main {

    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int n;
    static int[] dp;

    static void input() throws IOException {
        n = Integer.parseInt(br.readLine());
        dp = new int[n + 1];
    }

    static void pro() {
        if (n == 1) {
            System.out.println(1);
            return;
        }
        if (n == 2) {
            System.out.println(2);
            return;
        }
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
            dp[i] %= 10_007;
        }

        System.out.println(dp[n]);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}