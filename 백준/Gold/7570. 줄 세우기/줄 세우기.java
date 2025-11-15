import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int n;
    static int[] arr, dp;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        arr = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) arr[i] = Integer.parseInt(st.nextToken());

        dp = new int[n + 1];
        int max = -1;
        for (int i = 1; i <= n; i++) {
            dp[arr[i]] = dp[arr[i] - 1] + 1;
            max = Math.max(max, dp[arr[i]]);
        }

        System.out.println(n - max);
    }
}