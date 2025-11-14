import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n, k;
    static boolean[] visit;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        visit = new boolean[n + 1];
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreElements()) {
            int v = Integer.parseInt(st.nextToken());
            visit[v] = true;
        }

        dp = new int[n + 1];
        Arrays.fill(dp, -1);

        System.out.println(recur(0));
    }

    static int recur(int cur) {
        if (cur == n) return 0;

        if (dp[cur] != -1) return dp[cur];

        int res = 0;
        for (int i = 1; i <= k; i++) {
            int next = cur + i;
            if (next > n) break;
            if (visit[next]) continue;
            if (recur(next) == 0) {
                res = 1;
            }
        }

        return dp[cur] = res;
    }
}