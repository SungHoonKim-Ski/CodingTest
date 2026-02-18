import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int n, m;
    static int[][] map;

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static boolean[][] check;

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n + 2][m + 2];
        for (int i = 1; i <= n; i++) {
            char[] str = br.readLine().toCharArray();
            for (int j = 1; j <= m; j++) {
                map[i][j] = str[j - 1] - '0';
            }
        }
    }

    static void pro() {
        check = new boolean[n + 2][m + 2];

        int sum = 0;
        for (int i = 0; i <= 9; i++) {
            sum += bfs(i);
        }

        System.out.println(sum);
    }

    static int bfs(int h) {
        Queue<int[]> que = new ArrayDeque<>();
        boolean[][] visit = new boolean[n + 2][m + 2];

        que.add(new int[] {0, 0});
        visit[0][0] = true;
        int sum = 0;

        while (!que.isEmpty()) {
            int[] cur = que.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx < 0 || ny < 0 || nx > n + 1 || ny > m + 1) continue;
                if (map[nx][ny] > h) continue;
                if (visit[nx][ny]) continue;
                visit[nx][ny] = true;
                que.add(new int[] {nx, ny});

                if (map[nx][ny] == h) {
                    check[nx][ny] = true;
                } else {
                    if (!check[nx][ny]) {
                        check[nx][ny] = true;
                        sum += h - map[nx][ny];
                    }
                }
            }
        }

        return sum;
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}