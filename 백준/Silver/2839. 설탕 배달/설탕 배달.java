import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer sb = new StringBuffer();
    static StringTokenizer st;

    static int n;

    static int[] dp;
    static void input() throws IOException{
        n = Integer.parseInt(br.readLine());
        dp = new int[n + 1];
    }

    static void pro() {

        if (n < 5) {
            if (n == 3) System.out.println(1);
            else System.out.println(-1);
        } else {
            dp[3] = 1;
            dp[5] = 1;

            for (int i = 6; i <= n; i++) {
                if (dp[i - 3] != 0) {
                    if (dp[i] == 0) dp[i] = dp[i - 3] + 1;
                    else dp[i] = Math.min(dp[i], dp[i - 3] + 1);
                }
                if (dp[i - 5] != 0) {
                    if (dp[i] == 0) dp[i] = dp[i - 5] + 1;
                    else dp[i] = Math.min(dp[i], dp[i - 5] + 1);
                }
            }
            if (dp[n] == 0) System.out.println(-1);
            else System.out.println(dp[n]);
        }
    }

    public static void main(String[] args) throws IOException{
        input();
        pro();

    }

}
