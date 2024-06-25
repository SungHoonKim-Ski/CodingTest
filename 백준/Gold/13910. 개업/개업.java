import java.io.*;
import java.util.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n, m;
    static int[] dp, sArr;
    static HashSet<Integer> wokSet;
    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        sArr = new int[m];
        wokSet = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            sArr[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[n + 1];
    }

    static void pro() {

        for (int i = 0; i < m; i++) {
            wokSet.add(sArr[i]);
            for (int j = i + 1; j < m; j++) {
                wokSet.add(sArr[i] + sArr[j]);
            }
        }

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int wok : wokSet) {
                if (i - wok >= 0 && dp[i - wok] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i - wok] + 1, dp[i]);
                }
            }
        }

        if (dp[n] == Integer.MAX_VALUE) dp[n] = -1;
        System.out.println(dp[n]);
    }

    public static void main(String[] args) throws IOException{
        input();
        pro();
    }
}
