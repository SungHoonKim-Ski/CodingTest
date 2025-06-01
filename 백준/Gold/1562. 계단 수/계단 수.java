import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuffer sb = new StringBuffer();

    static int n;
    static int[][][] dp;
    static final int MOD = 1_000_000_000;
    static int ZERO_TO_NINE = (1 << 10);

    static void input() throws IOException {
        n = Integer.parseInt(br.readLine());
        dp = new int[n + 1][10][ZERO_TO_NINE];
        for (int[][] arr2d : dp) {
            for (int[] arr1d : arr2d) {
                Arrays.fill(arr1d, -1);
            }
        }
    }

    static int dfs(int length, int lastDigit, int visited) {
        if (length == n) {
            return visited == (ZERO_TO_NINE - 1) ? 1 : 0;
        }
        if (dp[length][lastDigit][visited] != -1) {
            return dp[length][lastDigit][visited];
        }

        int result = 0;
        if (lastDigit > 0) {
            result += dfs(length + 1, lastDigit - 1, visited | (1 << (lastDigit - 1)));
            result %= MOD;
        }
        if (lastDigit < 9) {
            result += dfs(length + 1, lastDigit + 1, visited | (1 << (lastDigit + 1)));
            result %= MOD;
        }
        dp[length][lastDigit][visited] = result;
        return result;
    }

    static void pro() {
        int sum = 0;
        for (int i = 1; i < 10; i++) {
            sum += dfs(1, i, 1 << i);
            sum %= MOD;
        }
        System.out.println(sum);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
