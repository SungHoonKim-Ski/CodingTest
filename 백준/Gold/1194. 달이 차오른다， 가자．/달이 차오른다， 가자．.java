import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n, m;
    static char[][] map;
    static int[] start;

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static void input() throws IOException{
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        for (int i = 0; i < n; i++) {
            char[] str = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                map[i][j] = str[j];
                if (map[i][j] == '0') {
                    start = new int[] {i, j};
                    continue;
                }
            }
        }
    }

    static void pro() {
        boolean[][][][][][][][] visit = new boolean[n][m][2][2][2][2][2][2];

        Deque<int[]> que = new ArrayDeque<>();
        que.add(new int[] {start[0], start[1], 0, 0, 0, 0, 0, 0, 0});
        visit[start[0]][start[1]][0][0][0][0][0][0] = true;

        while (!que.isEmpty()) {
            int[] cur = que.poll();

            if (map[cur[0]][cur[1]] == '1') {
                System.out.println(cur[2]);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                int nMove = cur[2] + 1;

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (map[nx][ny] == '#') continue;
                if (visit[nx][ny][cur[3 + 0]][cur[3 + 1]][cur[3 + 2]][cur[3 + 3]][cur[3 + 4]][cur[3 + 5]]) continue;
                if ('A' <= map[nx][ny] && map[nx][ny] <= 'F') {
                    if (cur[3 + map[nx][ny] - 'A'] == 0) continue;
                }
                int[] next = new int[] {cur[3 + 0],cur[3 + 1],cur[3 + 2],cur[3 + 3],cur[3 + 4],cur[3 + 5]};
                if ('a' <= map[nx][ny] && map[nx][ny] <= 'f') {
                    next[map[nx][ny] - 'a'] = 1;
                }

                visit[nx][ny][next[0]][next[1]][next[2]][next[3]][next[4]][next[5]] = true;
                que.add(new int[] {nx, ny, nMove, next[0], next[1], next[2], next[3], next[4], next[5]});
            }
        }
        System.out.println(-1);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}