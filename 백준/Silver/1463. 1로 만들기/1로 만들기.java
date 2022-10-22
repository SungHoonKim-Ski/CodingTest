import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    //    private static Scanner sc = new Scanner(System.in);
    private static BufferedReader br;
    private static StringBuffer sb;
    static int[] dp;

    public static void main(String args[]) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuffer();

        int input = Integer.parseInt(br.readLine());
        dp = new int[input+1];
        dp[0] = dp[1] = 0;

        for(int i=2; i<= input; i++){
            dp[i] = dp[i-1];
            if(i%3 == 0){
                dp[i] = Math.min(dp[i/3], dp[i]);
            }
            if(i%2 == 0){
                dp[i] = Math.min(dp[i/2], dp[i]);
            }
            dp[i]++;
        }
        System.out.println(dp[input]);
    }

}