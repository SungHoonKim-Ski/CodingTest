import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int[] start;
    static int n, m;
    static char[][] map;

    static int[] dx = {1, 0, -1};
    static int[] dy = {1, 1, 1};

    static boolean[][] visit;

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 'R') start = new int[] {i, j};
            }
        }
    }

    static void pro() {
        int[][] sum = new int[n][m];
        int max = -1;

        visit = new boolean[n][m];
        Queue<int[]> que = new ArrayDeque<>();
        que.add(start);
        visit[start[0]][start[1]] = true;

        while (!que.isEmpty()) {
            int[] cur = que.poll();
            if (map[cur[0]][cur[1]] == 'C') {
                sum[cur[0]][cur[1]]++;
            }
            if (map[cur[0]][cur[1]] == 'O') {
                max = Math.max(max, sum[cur[0]][cur[1]]);
            }

            for (int i = 0; i < 3; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx < 0 || nx >= n) continue;
                if (ny >= m) continue;

                if (map[nx][ny] == '#') continue;
                sum[nx][ny] = Math.max(sum[nx][ny], sum[cur[0]][cur[1]]);
                if (!visit[nx][ny]) {
                    visit[nx][ny] = true;
                    que.add(new int[] {nx, ny});
                }
            }
        }

        System.out.println(max);
    }



    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}