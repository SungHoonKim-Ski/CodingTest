import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, max;
    static int[] sequence;
    static int[] dp;

    static void input() throws Exception {
        n = Integer.parseInt(br.readLine());
        sequence = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }
    }

    public static void pro() {
        dp = new int[n + 1];
        int max = 0;

        for (int i = n; i >= 1; i--) {
            dp[i] = 1;
            for (int j = i; j <= n; j++) {
                if (sequence[i] >= sequence[j]) continue;
                dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }

    public static void main(String[] args) throws Exception{
        input();
        pro();
    }
}