import java.io.*;
import java.util.*;

public class Main {

    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int n;
    static int[] dp;
    
    static void init() {
        dp = new int[12];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 4; i <= 11; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
    }

    static void input() throws IOException {
        n = Integer.parseInt(br.readLine());
    }

    static void pro() {
        sb.append(dp[n]).append('\n');
    }

    public static void main(String[] args) throws IOException {
        init();
        int tc = Integer.parseInt(br.readLine());
        while (tc -- > 0) {
            input();
            pro();
        }
        System.out.println(sb);
    }
}