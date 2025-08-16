import java.util.*;

class Solution {
    int aMin = Integer.MAX_VALUE, bMin = Integer.MAX_VALUE, n, m;
    int[][] info;
    int[][] dp;
    int size, MAX = 1_000_000_000;
    
    public int solution(int[][] info, int n, int m) {
        this.info = info;
        size = info.length;
        this.n = n;
        this.m = m;
        
        dp = new int[size + 1][m];
        for (int i = 0; i <= size; i++) Arrays.fill(dp[i], -1);
        
        int res = recur(0, 0);
        return res >= MAX ? -1 : res;
    }
    
    public int recur(int depth, int bSum) {        
        if (bSum >= m) return MAX;
        if (depth == size) return 0;

        if (dp[depth][bSum] != -1) return dp[depth][bSum];

        int a = info[depth][0] + recur(depth + 1, bSum);
        if (a >= n) a = MAX;
        int b = recur(depth + 1, bSum + info[depth][1]);

        return dp[depth][bSum] = Math.min(a, b);
    }
}