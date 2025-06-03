import java.io.*;
import java.util.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n;
    static char[] str;
    static int[] dp;
    static int[][] isPalindrome;

    static void input() throws Exception {
        str = (" " + br.readLine()).toCharArray();
        n = str.length - 1;
    }

    public static void pro() {
        isPalindrome = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(isPalindrome[i], -1);
            isPalindrome[i][i] = 1;
        }

        for (int i = 1; i < n; i++) {
            int j = i + 1;
            isPalindrome[i][j] = (str[i] == str[j]) ? 1 : 0;
        }

        calPalindrome(1, n);

        dp = new int[n + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        System.out.println(recur(n));
    }

    static void calPalindrome(int i, int j) {
        if (i > j) return;
        if (isPalindrome[i][j] != -1) return;

        if (str[i] == str[j]) {
            if (j - i <= 1) {
                isPalindrome[i][j] = 1;
            } else {
                calPalindrome(i + 1, j - 1);
                isPalindrome[i][j] = isPalindrome[i + 1][j - 1];
            }
        } else {
            isPalindrome[i][j] = 0;
        }

        calPalindrome(i + 1, j);
        calPalindrome(i, j - 1);
    }

    static int recur(int end) {
        if (dp[end] != -1) return dp[end];

        int min = n;

        for (int start = 1; start <= end; start++) {
            if (isPalindrome[start][end] == 1) {
                min = Math.min(min, recur(start - 1) + 1);
            }
        }

        return dp[end] = min;
    }

    public static void main(String[] args) throws Exception{
        input();
        pro();
    }
}