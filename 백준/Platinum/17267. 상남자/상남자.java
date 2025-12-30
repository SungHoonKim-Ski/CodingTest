import java.io.*;
import java.util.*;

public class Main {

    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int[][] map;
    static int n, m, l, r, MAX = 1 << 30;
    static int[] start;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[][] visit;

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            char[] str = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                map[i][j] = str[j] - '0';
                if (map[i][j] == 2) {
                    start = new int[] {i, j};
                }
            }
        }
    }

    static void pro() {
        visit = new int[n][m];
        for (int i = 0; i < n; i++) Arrays.fill(visit[i], MAX);

        visit[start[0]][start[1]] = 0;

        Deque<int[]> que = new ArrayDeque<>();
        que.add(new int[] {start[0], start[1], 0});

        while (!que.isEmpty()) {
            int[] cur = que.poll();
            int x = cur[0];
            int y = cur[1];
            int leftMove = cur[2];
            int rightMove = leftMove + (y - start[1]);

            if (leftMove > l || rightMove > r) continue;

            for (int i = 0; i < 3; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                int nLeftMove = leftMove;
                int nRightMove = nLeftMove + (ny - start[1]);

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (map[nx][ny] == 1) continue;
                if (visit[nx][ny] <= nLeftMove) continue;
                if (nLeftMove > l || nRightMove > r) continue;

                visit[nx][ny] = nLeftMove;
                que.addFirst(new int[] {nx, ny, nLeftMove});
            }

            int nx = x + dx[3];
            int ny = y + dy[3];
            int nLeftMove = leftMove + 1;
            int nRightMove = nLeftMove + (ny - start[1]);

            if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
            if (map[nx][ny] == 1) continue;
            if (visit[nx][ny] <= nLeftMove) continue;
            if (nLeftMove > l || nRightMove > r) continue;

            visit[nx][ny] = nLeftMove;
            que.addLast(new int[] {nx, ny, nLeftMove});
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visit[i][j] != MAX) cnt++;
            }
        }
        
        System.out.println(cnt);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}