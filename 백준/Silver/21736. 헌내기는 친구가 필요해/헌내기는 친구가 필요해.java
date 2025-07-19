import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static final int LEN = 1 << 20;
    static final int SIZE = 1 << 21;

    static int n, m;
    static int[] start, end;
    static char[][] map;

    static void input() throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        for (int i = 0; i < n; i++) {
            char[] str = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                map[i][j] = str[j];
                if (map[i][j] == 'I') {
                    start = new int[] {i, j};
                }
            }
        }
    }

    public static void pro() {
        Queue<int[]> que = new ArrayDeque<>();
        boolean[][] visit = new boolean[n][m];

        int[] dy = {0, 1, 0, -1};
        int[] dx = {1, 0, -1, 0};

        que.add(start);
        visit[start[0]][start[1]] = true;

        int count = 0;
        while (!que.isEmpty()) {
            int[] cur = que.poll();
            if (map[cur[0]][cur[1]] == 'P') count++;

            for (int i = 0; i < 4; i++) {
                int ny = dy[i] + cur[0];
                int nx = dx[i] + cur[1];

                if (ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
                if (map[ny][nx] == 'X') continue;
                if (visit[ny][nx]) continue;

                visit[ny][nx] = true;
                que.add(new int[] {ny, nx});
            }
        }

        if (count == 0) System.out.println("TT");
        else System.out.println(count);
    }

    public static void main(String[] args) throws Exception{
        input();
        pro();
    }
}