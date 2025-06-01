import java.io.*;
import java.util.*;

public class Main {

    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int n;
    static int[][] dp;

    static void input() throws IOException {
        n = Integer.parseInt(br.readLine());

        dp = new int[n + 2][3];
        for (int i = 1; i <= n + 1; i++) Arrays.fill(dp[i], -1);
    }

    static void pro() {
        dp[1][0] = 1;
        dp[1][1] = 1;
        dp[1][2] = 1;

        System.out.println(recur(n + 1, 0));
    }

    static int recur(int cur, int lion) {
        if (dp[cur][lion] != -1) return dp[cur][lion];
        dp[cur][lion] = recur(cur - 1, 0);

        if (lion == 0) {
            dp[cur][lion] += recur(cur - 1, lion + 1) + recur(cur - 1, lion + 2);
        } else if (lion == 1) {
            dp[cur][lion] += recur(cur - 1, lion + 1);
        } else {
            dp[cur][lion] += recur(cur - 1, lion - 1);
        }
        dp[cur][lion] %= 9901;
        
        return dp[cur][lion];
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}