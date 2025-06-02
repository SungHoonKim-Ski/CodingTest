import java.io.*;
import java.util.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n;
    static int[] nums;

    static int[][] dp;
    static boolean[][] isPalindrome;

    static void input() throws Exception {
        n = Integer.parseInt(br.readLine());
        nums = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) nums[i] = Integer.parseInt(st.nextToken());
    }

    public static void pro() throws IOException {
        isPalindrome = new boolean[n + 1][n + 1];
        dp = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(dp[i], -1);
            dp[i][i] = 1;
            isPalindrome[i][i] = true;
        }

        int m = Integer.parseInt(br.readLine());
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            recur(s, e);
            sb.append(dp[s][e]).append('\n');
        }
        System.out.println(sb);
    }

    static int recur(int i, int j) {
        if (j < i) return 1;
        if (dp[i][j] != -1) return dp[i][j];

        dp[i][j] = 0;

        if (recur(i + 1, j - 1) == 0) {
            return dp[i][j];
        }

        if (nums[i] == nums[j]) {
            isPalindrome[i][j] = true;
            return dp[i][j] = 1;
        }

        return dp[i][j];
    }

    public static void main(String[] args) throws Exception{
        input();
        pro();
    }
}