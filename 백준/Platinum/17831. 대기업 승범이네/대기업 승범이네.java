import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int[] cost;
    static int[][] dp;
    static int n;
    static List<Integer>[] tree;

    static void input() throws Exception {
        n = Integer.parseInt(br.readLine());

        tree = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) tree[i] = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 2; i <= n; i++) {
            int parent = Integer.parseInt(st.nextToken());
            tree[parent].add(i);
        }

        cost = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }
    }

    public static void pro() {
        dp = new int[n + 1][2];
        for (int i = 1; i <= n; i++) Arrays.fill(dp[i], -1);
        System.out.println(recur(1, 1));
    }

    static int recur(int cur, int use) {
        if (tree[cur].size() == 0) return 0;
        if (dp[cur][use] != -1) return dp[cur][use];
        dp[cur][use] = 0;

        HashMap<Integer, Integer> usedMap = new HashMap<>();
        HashMap<Integer, Integer> notUsedMap = new HashMap<>();

        for (int child : tree[cur]) {
            int usedRes = recur(child, 1);
            usedMap.put(child, usedRes);
            dp[cur][use] += usedRes;

            int notUsedRes = recur(child, 0);
            notUsedMap.put(child, notUsedRes);
        }

        if (use == 1) {
            int max = dp[cur][use];
            for (int child : tree[cur]) {
                int comp = dp[cur][use] - usedMap.get(child) + notUsedMap.get(child) + cost[cur] * cost[child];
                max = Math.max(comp, max);
            }
            return dp[cur][use] = max;
        } else {
            return dp[cur][use];
        }
    }

    public static void main(String[] args) throws Exception{
        input();
        pro();
    }
}