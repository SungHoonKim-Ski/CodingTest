import java.io.*;
import java.util.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, k;
    static int[] arr;
    static int[] dp;

    static void input() throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        dp = new int[k + 1];
    }

    public static void pro() {
        dp[0] = 1;
        
        for (int i = 0; i < n; i++) {
            for (int v = arr[i]; v <= k; v++) {
                dp[v] += dp[v - arr[i]];
            }
        }
        
        System.out.println(dp[k]);
    }

    public static void main(String[] args) throws Exception{
        input();
        pro();
    }
}


