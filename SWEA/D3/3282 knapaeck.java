import java.util.*;

public class Solution {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = sc.nextInt();
            int K = sc.nextInt();

            int[][] dp = new int[N+1][K+1];
            int[] arrItemsWeight = new int[K+1];
            int[] arrValues = new int[K+1];
            for (int i=1; i<=N; i++) {
                arrItemsWeight[i] = sc.nextInt();
                arrValues[i] = sc.nextInt();
            }

            for (int i = 1; i <= N; i++) { // items
                for (int j = 1; j <= K; j++) { // weights
                    dp[i][j] = dp[i-1][j];
                    if (j - arrItemsWeight[i] >= 0) {
                        dp[i][j] = Math.max(dp[i][j], arrValues[i] + dp[i-1][j-arrItemsWeight[j]]);
                    } if(j - arrItemsWeight[i] >= 0) {
                        dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-arrItemsWeight[i]]+arrValues[i]);
                    }

                }
            }

            System.out.printf("#%d %d\n", test_case, dp[N][K]);
        }
    }
}