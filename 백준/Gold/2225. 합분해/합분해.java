import java.io.*;
import java.util.*;

public class Main {

    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int n, k;
    static int[][] dp;

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        dp = new int[k + 1][n + 1];
    }

    static void pro() {
        for (int i = 0; i <= n; i++) {
            dp[1][i] = 1;
        }
        
        System.out.println(dfs(k, n));
    }

    static int dfs(int curK, int curN) {
        if(dp[curK][curN] != 0) return dp[curK][curN];

        int sum = 0;
        for (int j = 0; j <= curN; j++) {
            sum += dfs(curK - 1, curN - j);
            sum %= 1_000_000_000;
        }

        return dp[curK][curN] = sum;
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}