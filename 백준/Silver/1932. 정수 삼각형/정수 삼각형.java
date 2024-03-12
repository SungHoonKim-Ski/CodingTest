import java.util.*;
import java.io.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n;
    static int[][] map;
    static boolean[][] visit;

    static void input() throws IOException{
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visit = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static void pro() throws IOException{

        int[] dy = {1, 1};
        int[] dx = {0, 1};

        int[][] dp = new int[n][n];
        dp[0][0] = map[0][0];

        Deque<int[]> que = new ArrayDeque<>();
        que.add(new int[] {0, 0});

        while (!que.isEmpty()) {

            int[] cur = que.poll();
            for (int i = 0; i < 2; i++) {
                int ny = cur[0] + dy[i];
                int nx = cur[1] + dx[i];
                if (nx == -1 || nx > n) continue;
                if (ny == n) break;
                if (!visit[ny][nx]) {
                    que.add(new int[] {ny, nx});
                    visit[ny][nx] = true;
                }
                dp[ny][nx] = Math.max(dp[cur[0]][cur[1]] + map[ny][nx], dp[ny][nx]);
            }
        }

        int max = -1;
        for (int i = 0; i < n; i++) {
            max = Math.max(dp[n - 1][i], max);
        }
        System.out.println(max);
    }

    public static void main(String[] args) throws IOException {

        input();
        pro();
    }
}