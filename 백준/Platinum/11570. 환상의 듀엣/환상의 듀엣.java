import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int n;
    static int[] arr;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        arr = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) arr[i] = Integer.parseInt(st.nextToken());

        dp = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) Arrays.fill(dp[i], -1);

        System.out.println(recur(0, 0));
    }

    static int recur(int a, int b) {
        int cur = Math.max(a, b) + 1;

        if (cur == n + 1) return 0;
        if (dp[a][b] != -1) return dp[a][b];

        int x = recur(cur, b);
        if (a != 0) x += Math.abs(arr[cur] - arr[a]);

        int y = recur(a, cur);
        if (b != 0) y += Math.abs(arr[cur] - arr[b]);

        return dp[a][b] = Math.min(x, y);
    }
}