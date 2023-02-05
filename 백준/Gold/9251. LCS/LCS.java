import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int dp[][] = new int[1001][1001];
        for (int i=0; i<1000; i++){
            dp[i][0] = 0;
            dp[0][i] = 0;
        }
        char[] charArrA = br.readLine().toCharArray();
        char[] charArrB = br.readLine().toCharArray();

        for (int i=1; i<=charArrA.length; i++) {
            for (int j=1; j<=charArrB.length; j++) {
                if (charArrA[i-1] == charArrB[j-1]) dp[i][j] = dp[i-1][j-1] + 1;
                else dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
            }
        }
        System.out.println(dp[charArrA.length][charArrB.length]);
    }
}