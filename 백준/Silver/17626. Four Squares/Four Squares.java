import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer sb = new StringBuffer();
    static StringTokenizer st;

    static int n;

    static int[] dp;

    static void init() {

        dp = new int[50001];
        Arrays.fill(dp, 4);

        for (int i = 1; i * i <= 50000; i++) {
            dp[i * i] = 1;
        }
    }
    static void input() throws IOException{
        n = Integer.parseInt(br.readLine());
    }

    static void pro() {

        if (dp[n] == 1) {
            System.out.println(1);
            return;
        }

        for (int i = 2; i <= n; i++) {
            if (dp[i] == 1) continue;
            for (int j = 1; j * j < i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        System.out.println(dp[n]);
    }

    public static void main(String[] args) throws IOException{
        init();
        input();
        pro();

    }

}
