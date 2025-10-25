import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n, a, b, max;

    static int[][] value;
    static int[][][][] dp;

    static void input() throws IOException{
        n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        value = new int[n][4];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                value[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static void pro() {
        dp = new int[n][4][a + 1][101];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < 4; j++)
                for (int k = 0; k <= a; k++) Arrays.fill(dp[i][j][k], -1);

        System.out.println(recur(0, 0, new int[4]));
    }

    static int recur(int depth, int prev, int[] cnt) {
        int aSum = cnt[3];
        int bSum = cnt[0] + cnt[1];

        if (depth == n) {
            if (bSum < b) return Integer.MIN_VALUE;

            return 0;
        }

        if (dp[depth][prev][aSum][bSum] != -1) return dp[depth][prev][aSum][bSum];
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < 4; i++) {
            if (prev == 2 && i == 2) continue;
            if (i == 3 && aSum == a) continue;
            cnt[i]++;
            max = Math.max(max, recur(depth + 1, i, cnt) + value[depth][i]);
            cnt[i]--;
        }

        return dp[depth][prev][aSum][bSum] = max;
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}