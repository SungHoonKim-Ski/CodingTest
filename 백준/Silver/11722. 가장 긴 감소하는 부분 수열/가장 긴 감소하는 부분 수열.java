import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, max;
    static int[] sequence;
    static int[] dp;

    static void input() throws Exception {
        n = Integer.parseInt(br.readLine());
        sequence = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }
    }

    public static void pro() {
        dp = new int[n + 1];
        Arrays.fill(dp, -1);

        recur(n);

        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(dp[i], max);
        }

        System.out.println(max);
    }

    static int recur(int cur) {
        if (dp[cur] != -1) return dp[cur];
        dp[cur] = 1;

        int curSeq = sequence[cur];
        for (int i = 1; i < cur; i++) {
            if (sequence[i] <= curSeq) recur(i);
            else dp[cur] = Math.max(dp[cur], recur(i) + 1);
        }

        return dp[cur];
    }

    public static void main(String[] args) throws Exception{
        input();
        pro();
    }
}