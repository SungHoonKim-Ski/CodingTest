import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n;
    static int[] w, e;
    static long min = Long.MAX_VALUE;
    static long[] dp;

    static void input() throws IOException{
        n = Integer.parseInt(br.readLine());

        w = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            w[i] = Integer.parseInt(st.nextToken());
        }

        e = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            e[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void pro() {
        dp = new long[n];
        Arrays.fill(dp, -1);

        System.out.println(recur(0));
    }

    static long recur(int idx) {
        if (idx == n) return 0;
        if (dp[idx] != -1) return dp[idx];

        long me = e[idx];
        long mw = w[idx];
        long sum = Long.MAX_VALUE;

        for (int i = idx; i < n; i++) {
            me = Math.max(me, e[i]);
            mw = Math.max(mw, w[i]);

            sum = Math.min(sum, recur(i + 1) + me * mw);
        }

        return dp[idx] = sum;
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}