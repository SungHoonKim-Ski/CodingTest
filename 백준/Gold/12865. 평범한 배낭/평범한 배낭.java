import java.io.*;
import java.util.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, k;
    static int[][] dp;
    static int[][] input;

    static void input() throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        input = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            input[i][0] = Integer.parseInt(st.nextToken()); // weight
            input[i][1] = Integer.parseInt(st.nextToken()); // value
        }
    }

    public static void pro() {
        int[][] dp = new int[n][k + 1];
        for (int i = 1; i <= k; i++) {
            if (i < input[0][0]) continue;
            dp[0][i] = input[0][1];
        }
        
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= k; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j < input[i][0]) continue;

                dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - input[i][0]] + input[i][1]);
            }
        }
        
        System.out.println(dp[n - 1][k]);
    }
    
    public static void main(String[] args) throws Exception{
        input();
        pro();
    }
}


