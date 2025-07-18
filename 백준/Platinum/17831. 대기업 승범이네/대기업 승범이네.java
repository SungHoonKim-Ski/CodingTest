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

        List<Integer> usedList = new ArrayList<>();

        for (int child : tree[cur]) {
            int usedRes = recur(child, 1);
            usedList.add(usedRes);
            dp[cur][use] += usedRes;
        }

        if (use == 1) {
            int usedCost = dp[cur][use];
            int max = usedCost;
            
            for (int i = 0; i < tree[cur].size(); i++) {
                int child = tree[cur].get(i);
                int comp = usedCost - usedList.get(i) + recur(child, 0) + cost[cur] * cost[child];
                max = Math.max(comp, max);
            }
            
            dp[cur][use] = max;
        }

        return dp[cur][use];
    }

    public static void main(String[] args) throws Exception{
        input();
        pro();
    }
}