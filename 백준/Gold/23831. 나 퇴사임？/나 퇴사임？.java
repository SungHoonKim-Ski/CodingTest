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

        System.out.println(recur(0, 0, 0, 0));
    }

    static int recur(int depth, int prev, int aCnt, int bCnt) {
        if (depth == n) {
            if (bCnt < b) return Integer.MIN_VALUE;

            return 0;
        }
        // 정 소 휴 요
        if (dp[depth][prev][aCnt][bCnt] != -1) return dp[depth][prev][aCnt][bCnt];

        int max = Integer.MIN_VALUE;
        max = Math.max(max, recur(depth + 1, 0, aCnt, bCnt + 1) + value[depth][0]);
        max = Math.max(max, recur(depth + 1, 1, aCnt, bCnt + 1) + value[depth][1]);
        if (prev != 2) {
            max = Math.max(max, recur(depth + 1, 2, aCnt, bCnt) + value[depth][2]);
        }
        if (aCnt < a) {
            max = Math.max(max, recur(depth + 1, 3, aCnt + 1, bCnt) + value[depth][3]);
        }

        return dp[depth][prev][aCnt][bCnt] = max;
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}