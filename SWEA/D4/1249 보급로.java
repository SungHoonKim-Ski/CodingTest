import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    private static BufferedReader br;
    private static int[][] road;
    private static int[][] dp;
    private static int N;
    private static int minCost;

    private static int[] dy = {0, 1, 0, -1};
    private static int[] dx = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {

        br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int TC = Integer.parseInt(str);
        Queue<int[]> queue = new LinkedList<>();
        for (int tc = 1; tc <= TC; tc++) {
            N = Integer.parseInt(br.readLine());
            road = new int[N][N];
            dp = new int[N][N];
            minCost = Integer.MAX_VALUE;
            for (int i = 0; i < N; i++) {
                char[] input = br.readLine().toCharArray();
                for (int j = 0; j < N; j++) {
                    road[i][j] = input[j] - '0';
                    dp[i][j] = Integer.MAX_VALUE;
                }
            }
            dp[0][0] = 0;
            queue.add(new int[]{0, 0});
            while (!queue.isEmpty()) {
                int[] cur = queue.poll();
                int curY = cur[0];
                int curX = cur[1];
                if (curX == (N-1) && curY == (N-1)) {
                    minCost = Math.min(dp[curY][curX], minCost);
                    continue;
                }
                if (minCost < dp[curY][curX]) continue;

                for (int i = 0; i < 4; i++) {
                    int nextY = curY + dy[i];
                    int nextX = curX + dx[i];
                    if (nextY < 0 || nextX < 0 || nextY == N || nextX == N) continue;
                    if (dp[nextY][nextX] > dp[curY][curX] + road[nextY][nextX]) {
                        dp[nextY][nextX] = dp[curY][curX] + road[nextY][nextX];
                        queue.add(new int[]{nextY, nextX});
                    }
                }
            }
            System.out.printf("#%d %d%n", tc, dp[N-1][N-1]);
        }
    }
}