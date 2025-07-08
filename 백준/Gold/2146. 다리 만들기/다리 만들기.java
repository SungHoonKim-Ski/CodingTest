import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, index = 1;
    static int[][] map;
    static boolean[][] visit;

    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};

    static void input() throws Exception {
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    public static void pro() {
        visit = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visit[i][j]) continue;
                if (map[i][j] == 0) continue;

                visit[i][j] = true;
                union(i, j);
                index++;
            }
        }

        int minDist = Integer.MAX_VALUE;

        visit = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visit[i][j]) continue;
                if (map[i][j] == 0) continue;
                visit[i][j] = true;
                minDist = Math.min(minDist, bridge(i, j));
            }
        }

        System.out.println(minDist);
    }

    static int bridge(int y, int x) {
        Queue<int[]> que = new ArrayDeque<>();
        que.add(new int[] {y, x, 0});

        int minDist = Integer.MAX_VALUE;
        int curIdx = map[y][x];
        boolean[][] bridgeVisit = new boolean[n][n];
        bridgeVisit[y][x] = true;

        while (!que.isEmpty()) {
            int[] cur = que.poll();
            if (map[cur[0]][cur[1]] != 0 && map[cur[0]][cur[1]] != curIdx) {
                minDist = Math.min(minDist, cur[2] - 1);
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int ny = cur[0] + dy[i];
                int nx = cur[1] + dx[i];

                if (ny < 0 || nx < 0 || ny >= n || nx >= n) continue;
                if (bridgeVisit[ny][nx]) continue;

                int nMove = cur[2];
                if (curIdx != map[ny][nx]) nMove++;
                
                bridgeVisit[ny][nx] = true;
                que.add(new int[] {ny, nx, nMove});
            }
        }

        return minDist;
    }

    static void union(int y, int x) {
        Queue<int[]> que = new ArrayDeque<>();
        que.add(new int[] {y, x});

        while (!que.isEmpty()) {
            int[] cur = que.poll();
            map[cur[0]][cur[1]] = index;

            for (int i = 0; i < 4; i++) {
                int ny = cur[0] + dy[i];
                int nx = cur[1] + dx[i];

                if (ny < 0 || nx < 0 || ny >= n || nx >= n) continue;
                if (visit[ny][nx]) continue;
                if (map[ny][nx] == 0) continue;
                visit[ny][nx] = true;
                que.add(new int[] {ny, nx});
            }
        }
    }

    public static void main(String[] args) throws Exception{
        input();
        pro();
    }
}