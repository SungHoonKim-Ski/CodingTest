import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    public static long[][] dp;
    public static void main(String[] args) throws IOException {

        StringBuffer sb = new StringBuffer();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        dp = new long[101][10];
        for (int i=0; i<10; i++) {
            dp[1][i] = 1;
        }

        long res = 0;
        for (int i=1; i < 10; i++) {
            res += DP(n, i);
        }
        res %= 1000000000;
        System.out.println(res);
    }

    public static long DP(int y, int x) {

        if (dp[y][x] == 0){
            if (x == 0) {
                dp[y][x] = DP(y-1, 1);
            }else if (x == 9) {
                dp[y][x] = DP(y-1, 8);
            }else {
                dp[y][x] = DP(y-1, x-1) + DP(y-1, x+1);
            }
        }
        return dp[y][x] % 1000000000;
    }
}
