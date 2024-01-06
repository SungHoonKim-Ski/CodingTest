import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer sb = new StringBuffer();
    static StringTokenizer st;

    static int[] dp;
    static final int MAX_VALUE = 1 << 20 - 1;
    static int n;

    static void input() throws IOException {
        n = Integer.parseInt(br.readLine());
        dp = new int[n + 1];
        Arrays.fill(dp, MAX_VALUE);

    }

    static void pro() throws IOException {

        ArrayList<Integer> a = new ArrayList<>();

        for (int i = 1; i * i <= n; i++) {
            a.add(i * i);
        }
        dp[0] = 0;
        for (int i : a) {
            for (int j = i; j <= n; j++) {
                dp[j] = Math.min(dp[j], dp[j - i] + 1);
            }
        }
        System.out.println(dp[n]);
    }


    public static void main(String[] args) throws IOException {

        input();
        pro();
    }

}