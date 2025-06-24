import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n;
    static int[] dp;
    static int[] prev;
    static void input() throws Exception {
        n = Integer.parseInt(br.readLine());
    }

    public static void pro() {
        dp = new int[n + 1];
        prev = new int[n + 1];
        Arrays.fill(dp, -1);;
        Arrays.fill(prev, -1);;

        dp[1] = prev[1] = 0;

        recur(n);
        sb.append(dp[n]).append('\n');
        while (n != 0) {
            sb.append(n).append(' ');
            n = prev[n];
        }

        System.out.println(sb);
    }

    static int recur(int cur) {
        if (dp[cur] != -1) return dp[cur];
        dp[cur] = Integer.MAX_VALUE;

        if (cur % 3 == 0) {
            dp[cur] = recur(cur / 3) + 1;
            prev[cur] = cur / 3;
        }

        if (cur % 2 == 0) {
            int res = recur(cur / 2) + 1;
            if (res < dp[cur]) {
                dp[cur] = res;
                prev[cur] = cur / 2;
            }
        }

        int res = recur(cur - 1) + 1;
        if (res < dp[cur]) {
            dp[cur] = res;
            prev[cur] = cur - 1;
        }

        return dp[cur];
    }

    public static void main(String[] args) throws Exception{
        input();
        pro();
    }
}