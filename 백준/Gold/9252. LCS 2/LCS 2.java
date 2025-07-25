import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static char[] str1, str2;
    static int n, m;

    static void input() throws Exception {
        str1 = br.readLine().toCharArray();
        str2 = br.readLine().toCharArray();
    }

    public static void pro() {
        n = str1.length;
        m = str2.length;

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (str1[i - 1] == str2[j - 1]) dp[i][j] = dp[i - 1][j - 1] + 1;
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        if (dp[n][m] == 0) {
            System.out.println(0);
            return;
        }

        System.out.println(dp[n][m]);
        while (true) {
            if (n == 0 || m == 0) break;
            if (dp[n][m] == dp[n - 1][m]) {
                n--;
                continue;
            }
            if (dp[n][m] == dp[n][m - 1]) {
                m--;
                continue;
            }
            sb.append(str2[m - 1]);
            n--;
            m--;
        }
        System.out.println(sb.reverse());
    }

    public static void main(String[] args) throws Exception {
        input();
        pro();
    }
}