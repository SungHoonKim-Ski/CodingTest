import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int x, y;
    static int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
    static boolean[][][] visit;
    static int[][] map;

    static void input() throws Exception {
        st = new StringTokenizer(br.readLine());
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        map = new int[x + 1][y + 1];
        for (int i = 1; i <= x; i++) {
            char[] in = br.readLine().toCharArray();
            for (int j = 1; j <= y; j++) {
                map[i][j] = in[j - 1] - '0';
            }
        }
    }

    public static void pro() {
        final int MAX = 1_000_000;

        visit = new boolean[x * y + 1][x + 1][y + 1];

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[3] == o2[3] ? o1[2] - o2[2] : o1[3] - o2[3]);
        pq.add(new int[] {1, 1, 0, 0});
        visit[0][1][1] = true;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (cur[0] == x && cur[1] == y) {
                System.out.println(cur[3]);
                break;
            }
            int nMove = cur[2] + 1;

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                int nBreak = cur[3];
                if (nx <= 0 || ny <= 0 || nx > x || ny > y) continue;
                if (map[nx][ny] == 1) nBreak++;
                if (visit[nBreak][nx][ny]) continue;
                visit[nBreak][nx][ny] = true;
                pq.add(new int[] {nx, ny, nMove, nBreak});
            }
        }


    }

    public static void main(String[] args) throws Exception {
        input();
        pro();
    }
}