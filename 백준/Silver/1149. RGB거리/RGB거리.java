import java.io.*;
import java.util.*;

public class Main {

    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int n;
    static int[][] dp;
    static int[][] houses;

    static void input() throws IOException {
        n = Integer.parseInt(br.readLine());
        houses = new int[n][3];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < 3; c++) {
                houses[i][c] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static void pro() {
        dp = new int[n][3];
        for (int i = 0; i < n; i++) Arrays.fill(dp[i], -1);
        
        int min = recur(0, 1);
        min = Math.min(min, recur(0, 2));
        min = Math.min(min, recur(0, 0));

        System.out.println(min);
    }

    static int recur(int depth, int cur) {
        if (depth == n) return 0;
        if (dp[depth][cur] != -1) return dp[depth][cur];
        
        dp[depth][cur] = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            if (i == cur) continue;
            dp[depth][cur] = Math.min(dp[depth][cur], recur(depth + 1, i) + houses[depth][cur]);
        }
        return dp[depth][cur];
    } 

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}