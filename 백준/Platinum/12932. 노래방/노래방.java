import java.io.*;
import java.util.*;

public class Main {

    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int n;
    static long[] arr;
    static long[][] dp;
    static long min;

    static void input() throws IOException {
        n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        arr = new long[n + 1];
        for (int i = 1; i <= n; i++) arr[i] = Integer.parseInt(st.nextToken());
        min = 1L << 31;
    }

    static void pro() {
        dp = new long[n + 1][n + 1];
        for (int i = 0; i <= n; i++) Arrays.fill(dp[i], -1);

        System.out.println(recur(0, 0));
    }

    static long recur(int a, int b) {
        int cur = Math.max(a, b) + 1;

        if (cur == n + 1) {
            return 0;
        }

        if (dp[a][b] != -1) return dp[a][b];

        long x = 0;
        if (a != 0) x += Math.abs(arr[a] - arr[cur]);
        x += recur(cur, b);

        long y = 0;
        if (b != 0) y += Math.abs(arr[b] - arr[cur]);
        y += recur(a, cur);

        return dp[a][b] = Math.min(x, y);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}