import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n;
    static char[][] map;
    static int[][] dist;
    static int[] start, end;
    static final int[] dx = {0, 1, 0, -1};
    static final int[] dy = {1, 0, -1, 0};

    static void input() throws IOException{
        n = Integer.parseInt(br.readLine());
        map = new char[n][n];

        for (int i = 0; i < n; i++) {
            char[] str = br.readLine().toCharArray();
            for (int j = 0; j < n; j++) {
                map[i][j] = str[j];
                if (str[j] == 'R') {
                    start = new int[] {i, j};
                    map[i][j] = '.';
                } else if (str[j] == 'K') {
                    end = new int[] {i, j};
                    map[i][j] = 'W';
                }
            }
        }
    }

    static void pro() {

        dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        dist[start[0]][start[1]] = 0;

        PriorityQueue<int[]> que = new PriorityQueue<>((o1, o2) -> (o1[2] - o2[2]));
        que.add(new int[] {start[0], start[1], 0});

        while (!que.isEmpty()) {
            int[] cur = que.poll();
            int x = cur[0];
            int y = cur[1];
            int move = cur[2];
            int nMove = move + 1;

            if (x == end[0] && y == end[1]) break;
            if (dist[x][y] != move) continue;
            for (int i = 0; i < 4; i++) {
                for (int q = 1; q < n; q++) {
                    int nx = x + dx[i] * q;
                    int ny = y + dy[i] * q;

                    if (nx < 0 || ny < 0 || nx >= n || ny >= n) break;
                    if (map[nx][ny] == 'B') break;
                    if (dist[nx][ny] < nMove) break;
                    if (map[nx][ny] == 'W') {
                        if (dist[nx][ny] != nMove) {
                            que.add(new int[] {nx, ny, nMove});
                            dist[nx][ny] = nMove;
                        }
                        break;
                    }
                    if (dist[nx][ny] == nMove) continue;
                    if (map[nx][ny] == '.') {
                        que.add(new int[] {nx, ny, nMove});
                        dist[nx][ny] = nMove;
                        continue;
                    }
                }
            }
        }

        if (dist[end[0]][end[1]] == Integer.MAX_VALUE) dist[end[0]][end[1]] = -1;
        System.out.println(dist[end[0]][end[1]]);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}