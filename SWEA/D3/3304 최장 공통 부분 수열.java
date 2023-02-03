import java.util.*;

public class Solution {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        StringBuffer sb = new StringBuffer();

        int dp[][] = new int[1001][1001];
        for (int i=0; i<1000; i++){
            dp[i][0] = 0;
            dp[0][i] = 0;
        }
        for(int test_case = 1; test_case <= T; test_case++) {

            char[] charArrA = sc.next().toCharArray();
            char[] charArrB = sc.next().toCharArray();

            for (int i=1; i<=charArrA.length; i++) {
                for (int j=1; j<=charArrB.length; j++) {
                    if (charArrA[i-1] == charArrB[j-1]) dp[i][j] = dp[i-1][j-1] + 1;
                    else dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
             sb.append(String.format("#%d %d", test_case, dp[charArrA.length][charArrB.length])).append('\n');
        }
        System.out.println(sb);
    }
}