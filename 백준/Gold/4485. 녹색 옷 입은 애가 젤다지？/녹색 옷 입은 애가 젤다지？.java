import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br;
    private static int[][] road;
    private static int[][] dp;
    private static int minCost;

    private static int[] dy = {0, 1, 0, -1};
    private static int[] dx = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {

        br = new BufferedReader(new InputStreamReader(System.in));
        Queue<int[]> queue = new LinkedList<>();
        int N = Integer.parseInt(br.readLine());
        int count = 1;
        StringTokenizer st;
        while (N != 0) {
            road = new int[N][N];
            dp = new int[N][N];
            minCost = Integer.MAX_VALUE;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < N; j++) {
                    road[i][j] = st.nextToken().charAt(0) - '0';
                    dp[i][j] = Integer.MAX_VALUE;
                }
            }
            dp[0][0] = road[0][0];
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
            System.out.printf("Problem %d: %d\n", count++, dp[N-1][N-1]);
            N = Integer.parseInt(br.readLine());
        }
    }

}