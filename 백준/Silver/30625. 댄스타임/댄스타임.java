import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n, m;
    static int[][] arr;
    static long[][] dp;

    static long MOD = 1_000_000_007;

    static void input() throws IOException{
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        }
    }

    static void pro() {
        dp = new long[n][2];
        for (int i = 0; i < n; i++) Arrays.fill(dp[i], -1);

        System.out.println(recur(0, 0));
    }

    static long recur(int depth, int wrong) {
        if (wrong > 1) return 0;
        if (depth == n) return 1;

        if (dp[depth][wrong] != -1) return dp[depth][wrong];

        long sum = 0;

        if (arr[depth][1] == 0) {
            sum += (m - 1) * recur(depth + 1, wrong + 1);
            sum += recur(depth + 1, wrong);
            
            sum %= MOD;
        } else {
            sum += (m - 1) * recur(depth + 1, wrong);
            sum += recur(depth + 1, wrong + 1);
            
            sum %= MOD;
        }

        return dp[depth][wrong] = sum;
    }



    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}