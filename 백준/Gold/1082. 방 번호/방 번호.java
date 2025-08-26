import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, m, max;
    static int[] cost;
    static String[] dp;

    static void input() throws Exception {
        n = Integer.parseInt(br.readLine());

        cost = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }

        m = Integer.parseInt(br.readLine());
    }

    public static void pro() {
        dp = new String[m + 1];
        recur(0);
        
        if (dp[0].isEmpty()) System.out.println("0");
        else System.out.println(dp[0]);     
    }

    static String recur(int money) {
        if (money > m) return null;
        if (dp[money] != null) return dp[money];

        dp[money] = "";
        String tmp;

        for (int i = 0; i < n; i++) {
            tmp = recur(money + cost[i]);
            if (tmp == null) continue;
            if (i == 0 && tmp.isEmpty()) continue;

            if (compare(dp[money], tmp + i) < 0) {
                dp[money] = tmp + i;
            }
        }

        return dp[money];
    }

    static int compare(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return s1.length() - s2.length();
        }

        return s1.compareTo(s2);
    }

    public static void main(String[] args) throws Exception {
        input();
        pro();
    }
}