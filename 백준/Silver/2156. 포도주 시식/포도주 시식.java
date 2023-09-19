import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer sb = new StringBuffer();
    static StringTokenizer st;

    static int n;

    static int[] dp, inputArr;
    static void input() throws IOException{
        n = Integer.parseInt(br.readLine());
        dp = new int[n + 1];
        inputArr = new int[n + 1];
        for (int i = 1; i <= n; i++) inputArr[i] = Integer.parseInt(br.readLine());
    }

    static void pro() {

        dp[0] = 0;
        if (n == 1) System.out.println(inputArr[1]);
        else {
            dp[1] = inputArr[1];
            dp[2] = dp[1] + inputArr[2];
            int max = Math.max(dp[1], dp[2]);

            for (int i = 3; i <= n; i++) {
                dp[i] = Math.max(dp[i], dp[i - 2] + inputArr[i]);
                dp[i] = Math.max(dp[i], dp[i - 3] + inputArr[i - 1] + inputArr[i]);
                dp[i] = Math.max(dp[i], dp[i - 1]);
                max = Math.max(dp[i], max);
            }
            System.out.println(max);
        }
    }

    public static void main(String[] args) throws IOException{
        input();
        pro();

    }

}
