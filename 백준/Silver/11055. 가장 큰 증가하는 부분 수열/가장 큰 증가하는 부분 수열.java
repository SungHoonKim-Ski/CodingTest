import java.io.*;
import java.util.*;

public class Main {

    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int n;
    static int[] dp;
    static int[] arr;

    static void input() throws IOException {
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[n];
    }

    static void pro() {
        for (int i = n - 1; i >= 0; i--) {
            dfs(i);
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }

    static int dfs(int idx) {
        if (idx < 0) return 0;
        if (dp[idx] != 0) return dp[idx];

        int cur = arr[idx];
        int max = cur;

        for (int i = idx - 1; i >= 0; i--) {
            int compare = cur;
            if (arr[i] < cur) {
                compare += dfs(i);
            }
            max = Math.max(max, compare);
        }

        return dp[idx] = max;
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}