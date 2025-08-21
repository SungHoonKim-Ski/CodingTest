import java.util.*;


class Solution {
    List<Integer>[] graph;
    int[][] dp;
    
    public int solution(int n, int[][] lighthouse) {
        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<Integer>();
        
        for (int[] edge: lighthouse) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        
        dp = new int[n + 1][2];
        for (int i = 1; i <= n; i++) Arrays.fill(dp[i], -1);
        
        return (int)Math.min(recur(1, 0, -1), recur(1, 1, -1));
    }
    
    public int recur(int cur, int flag, int prev) {
        if (dp[cur][flag] != -1) return dp[cur][flag];
        
        int sum = flag;
        for (int next : graph[cur]) {
            if (next == prev) continue;
            int min = recur(next, 1, cur);
            if (flag == 1) {
                min = Math.min(min, recur(next, 0, cur));
            }
            sum += min;
        }
        return dp[cur][flag] = sum;
    }
}