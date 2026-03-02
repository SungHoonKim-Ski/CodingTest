import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int n, m;
    static long[][] dp;
    static long MOD = 1_000_000_007;

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
    }

    static void pro() {
        dp = new long[m][26];
        for (int i = 0; i < m; i++) Arrays.fill(dp[i], -1);

        System.out.println(recur(0, 0));
    }

    static long recur(int depth, int cur) {
        if (depth == m) return 1;
        if (dp[depth][cur] != -1) return dp[depth][cur];

        long sum = 0;
        if (depth == 0) {
            for (int i = 0; i < 26; i++) {
                sum += recur(depth + 1, i);
                sum %= MOD;
            }
        } else {
            for (int i = 0; i < 26; i++) {
                if (Math.abs(cur - i) < n) continue;

                sum += recur(depth + 1, i);
                sum %= MOD;
            }
        }

        return dp[depth][cur] = sum;
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}