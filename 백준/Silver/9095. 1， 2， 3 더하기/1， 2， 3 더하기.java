import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    public static void main(String[] args) throws IOException {

        StringBuffer sb = new StringBuffer();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());
        int[] dp = new int[12];
        dp[0] = dp[1] = 1;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i=0; i<count; i++) {
            int n = Integer.parseInt(br.readLine());
            for (int j=4; j<=n; j++) {
                if (dp[j] == 0) {
                    dp[j] = dp[j-1] + dp[j-2] + dp[j-3];    
                }
            }
            sb.append(dp[n]).append('\n');
        }
        System.out.println(sb);
    }
}
