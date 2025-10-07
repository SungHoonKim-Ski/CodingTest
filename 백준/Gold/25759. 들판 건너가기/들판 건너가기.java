import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n, max;
    static int[] arr;
    static int[][] dp;

    static void input() throws IOException{
        n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void pro() {
        dp = new int[100_010][110];

        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        System.out.println(recur(0, 0));
    }

    static int recur(int depth, int prev) {
        if (dp[depth][prev] != -1) return dp[depth][prev];
        if (depth == n) return 0;

        int a = 0, b = 0;
        if (prev == 0) a = recur(depth + 1, arr[depth]);
        else a = recur(depth + 1, arr[depth]) + (prev - arr[depth]) * (prev - arr[depth]);

        b = recur(depth + 1, prev);

        return dp[depth][prev] = Math.max(a, b);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}