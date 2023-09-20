import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer sb = new StringBuffer();
    static StringTokenizer st;

    static int n;
    static int[] dp, T, P;

    static void input() throws IOException{

        n = Integer.parseInt(br.readLine());

        P =  new int[n];
        T =  new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[n + 1];
    }

    static void pro() {

        if (T[0] <= n) dp[T[0]] = P[0];

        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i], dp[i - 1]);
            if (i + T[i] <= n) {
                dp[i + T[i]] = Math.max(dp[i + T[i]], dp[i] + P[i]);
            }
        }
        dp[n] = Math.max(dp[n - 1], dp[n]);
        System.out.println(dp[n]);
    }

    public static void main(String[] args) throws IOException{
        input();
        pro();

    }

}
