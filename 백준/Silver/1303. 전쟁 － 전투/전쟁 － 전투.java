import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static final int[] dx = {0, 1, 0, -1};
    static final int[] dy = {1, 0, -1, 0};

    static int n, m;
    static char[][] map;
    static boolean[][] visit;
    static int[] colorCount;

    static void input() throws IOException{
        st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        for (int i = 0; i < n; i++) {
            char[] str = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                map[i][j] = str[j];
            }
        }
    }

    static void pro() {
        visit = new boolean[n][m];
        colorCount = new int[2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visit[i][j]) bfs(i, j);
            }
        }

        sb.append(colorCount[0]).append(' ').append(colorCount[1]);
        System.out.println(sb);
    }

    static void bfs(int x, int y) {
        char color = map[x][y];

        Queue<int[]> que = new ArrayDeque<>();
        que.add(new int[] {x, y});
        visit[x][y] = true;
        int count = 1;

        while (!que.isEmpty()) {
            int[] cur = que.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (visit[nx][ny]) continue;
                if (map[nx][ny] != color) continue;
                count++;
                visit[nx][ny] = true;
                que.add(new int[] {nx, ny});
            }
        }

        int colorIdx = 0;
        if (color == 'B') colorIdx++;

        colorCount[colorIdx] += (count * count);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}