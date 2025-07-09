import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, m;
    static int[][] map, dp;
    static boolean[][] visit;

    static void input() throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    public static void pro() {
        dp = new int[n][m];
        visit = new boolean[n][m];

        Queue<int[]> que = new ArrayDeque<>();
        dp[0][0] = map[0][0];
        visit[0][0] = true;
        que.add(new int[]{0, 0});

        int[] dy = {0, 1, 0, -1};
        int[] dx = {1, 0, -1, 0};
        while (!que.isEmpty()) {
            int[] cur = que.poll();

            for (int i = 0; i < 4; i++) {
                int ny = cur[0] + dy[i];
                int nx = cur[1] + dx[i];

                if (ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
                dp[ny][nx] = Math.max(dp[ny][nx], dp[cur[0]][cur[1]] + map[ny][nx]);

                if (!visit[ny][nx]) {
                    que.add(new int[] {ny, nx});
                    visit[ny][nx] = true;
                }
            }
        }

        System.out.println(dp[n - 1][m - 1]);
    }

    public static void main(String[] args) throws Exception{
        input();
        pro();
    }
}