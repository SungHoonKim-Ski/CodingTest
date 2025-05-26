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
        Arrays.fill(dp, Integer.MAX_VALUE);
    }

    static void pro() {
        dp[n] = 0;
        dfs(n);
        System.out.println(dp[1]);
    }

    static void dfs(int cur) {
        if (cur <= 0) return;

        if (cur % 3 == 0) {
            if (dp[cur / 3] > dp[cur] + 1) {
                dp[cur / 3] = Math.min(dp[cur / 3], dp[cur] + 1);
                dfs(cur / 3);
            }
        }

        if (cur % 2 == 0) {
            if (dp[cur / 2] > dp[cur] + 1) {
                dp[cur / 2] = Math.min(dp[cur / 2], dp[cur] + 1);
                dfs(cur / 2);   
            }
        }
        
        if (dp[cur - 1] > dp[cur] + 1) {
            dp[cur - 1] = Math.min(dp[cur - 1], dp[cur] + 1);
            dfs(cur - 1);
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}