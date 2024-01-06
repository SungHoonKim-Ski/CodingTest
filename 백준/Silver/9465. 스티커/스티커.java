import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer sb = new StringBuffer();
    static StringTokenizer st;

    static int[][] dp, aArr;
    static int n;

    static void input() throws IOException {

        n = Integer.parseInt(br.readLine());
        dp = new int[2][n];
        aArr = new int[2][n];

        for (int i = 0; i < 2; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                aArr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static void pro() throws IOException {

        dp[0][0] = aArr[0][0];
        dp[1][0] = aArr[1][0];
        
        if(n == 1){
            System.out.println(Math.max(dp[0][n - 1], dp[1][n - 1]));
            return;
        }
        dp[0][1] = aArr[0][1] + aArr[1][0];
        dp[1][1] = aArr[1][1] + aArr[0][0];

        for (int j = 2; j < n; j++) {
            for (int i = 0; i < 2; i++) {
                if (i == 0) {
                    dp[i][j] = Math.max(dp[i + 1][j - 1], dp[i + 1][j - 2]) + aArr[i][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j - 2]) + aArr[i][j];
                }
            }
        }
        System.out.println(Math.max(dp[0][n - 1], dp[1][n - 1]));
    }


    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            input();
            pro();
        }
    }

}