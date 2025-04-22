import java.io.*;
import java.util.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int r, c, k, count;
    static boolean[][] visit;

    static void input() throws Exception {
        st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        visit = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            char[] arr = br.readLine().toCharArray();
            for (int j = 0; j < c; j++) {
                visit[i][j] = arr[j] == 'T';
            }
        }
    }

    public static void pro() {
        visit[r - 1][0] = true;
        dfs(r - 1, 0, 1);
        System.out.println(count);
    }

    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    static void dfs(int curR, int curC, int move) {
        if (curR == 0 && curC == (c - 1)) {
            if (move == k) count++;
            return;
        }

        if (move == k) return;

        for (int i = 0; i < 4; i++) {
            int nr = curR + dr[i];
            int nc = curC + dc[i];

            if (nr == -1 || nc == -1 || nr == r || nc == c) continue;
            if (visit[nr][nc]) continue;
            visit[nr][nc] = true;
            dfs(nr, nc, move + 1);
            visit[nr][nc] = false;
        }

    }

    public static void main(String[] args) throws Exception{
        input();
        pro();
    }
}


