import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer sb = new StringBuffer();
    static StringTokenizer st;

    static int n;

    static long[] dp;
    static void input() throws IOException{
        n = Integer.parseInt(br.readLine());
        dp = new long[n + 1];
    }

    static void pro() {

        if (n < 3) {
            if (n == 1) sb.append(1).append('\n');
            else if (n == 2) sb.append(2).append('\n');
        } else {
            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 4;

            for (int i = 4; i <= n; i++) {
                dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % 1000000009;
            }
            sb.append(dp[n]).append('\n');
        }
    }

    public static void main(String[] args) throws IOException{
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            input();
            pro();
        }
        System.out.println(sb);
    }

}
