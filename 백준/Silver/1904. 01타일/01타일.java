import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer sb = new StringBuffer();
    static StringTokenizer st;

    static int[] dp;
    static int n;
    static void input() throws IOException{
        n = Integer.parseInt(br.readLine());
    }

    static void pro() {

        if (n == 1) {
            System.out.println(1);
        } else {
            dp = new int[n + 1];
            dp[1] = 1;
            dp[2] = 2;
            for (int i = 3; i <= n; i++) dp[i] = (dp[i - 1] + dp[i - 2]) % 15746;
            System.out.println(dp[n]);
        }
    }
    public static void main(String[] args) throws IOException{
        input();
        pro();

    }

}
