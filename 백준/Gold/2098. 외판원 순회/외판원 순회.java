import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int[][] graph;
    static int[][] dp;
    static int n, min;
    static int SIZE, MASK, MAX = 1_000_000 * 17;

    static void input() throws Exception {
        n = Integer.parseInt(br.readLine());
        graph = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if (graph[i][j] == 0) graph[i][j] = MAX;
            }
        }
    }

    public static void pro() {
        SIZE = 1 << n;
        MASK = SIZE - 1;

        min = MAX;
        dp = new int[SIZE][n];

        for (int i = 0; i < SIZE; i++) {
            Arrays.fill(dp[i], -1);
        }

        System.out.println(recur(1,  0));
    }

    static int recur(int visit, int cur) {
        if (visit == MASK) {
            if (graph[cur][0] == MAX) return MAX;
            return graph[cur][0];
        }

        if (dp[visit][cur] != -1) return dp[visit][cur];

        dp[visit][cur] = MAX;
        for (int i = 0; i < n; i++) {
            if (graph[cur][i] == MAX) continue;
            if ((visit & (1 << i)) != 0) continue;

            dp[visit][cur] = Math.min(dp[visit][cur], recur(visit | (1 << i), i) + graph[cur][i]);
        }

        return dp[visit][cur];
    }

    public static void main(String[] args) throws Exception{
        input();
        pro();
    }
}