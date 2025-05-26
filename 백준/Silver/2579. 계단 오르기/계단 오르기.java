import java.io.*;
import java.util.*;

public class Main {

    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int n;
    static int[] dp, score;

    static void input() throws IOException {
        n = Integer.parseInt(br.readLine());
        score = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            score[i] = Integer.parseInt(br.readLine());
        }

        dp = new int[n + 1];
    }

    static void pro() {
        dp[1] = score[1];
        if (n != 1) dp[2] = score[2] + score[1];

        dfs(n);
        System.out.println(dp[n]);
    }

    static int dfs(int cur) {
        if (cur <= 0) return 0;

        if (dp[cur] != 0) return dp[cur];

        dp[cur] = score[cur] + Math.max(dfs(cur - 3) + score[cur - 1], dfs(cur - 2));

        return dp[cur];
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}