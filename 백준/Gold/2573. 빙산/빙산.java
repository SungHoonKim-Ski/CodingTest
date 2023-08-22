import java.math.BigInteger;
import java.util.*;
import java.io.*;


public class Main
{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuffer sb = new StringBuffer();

    static final int[] dy = {0, 1, 0, -1};
    static final int[] dx = {1, 0, -1, 0};

    static int n, m;

    static int[][] board;

    static int time = 0;

    public static void input() throws IOException{

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
    public static void pro() {

        while (meltIce()) {
            time++;
            int cntIce = cntIce();
            if (cntIce > 1) break;
            if (cntIce == 0) {
                time = 0;
                break;
            }
        }

        System.out.println(time);
    }

    public static boolean meltIce() {

        Queue<int[]> queue = new LinkedList<>();

        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {
                if (board[y][x] == 0) {
                    queue.add(new int[] {y, x});
                }
            }
        }
        if (queue.size() == n * m) return false; // 더이상 못 녹이는 상황
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int ny = cur[0] + dy[i];
                int nx = cur[1] + dx[i];
                if (!vaild(ny, nx)) continue;
                if (board[ny][nx] == 0) continue;
                board[ny][nx]--;
            }
        }
        return true;
    }

    public static int cntIce() {

        int cnt = 0;
        // bfs
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visit = new boolean[n][m];
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {
                if (board[y][x] == 0) continue;
                if (visit[y][x]) continue;

                queue.add(new int[] {y, x});
                visit[y][x] = true;
                cnt++;
                while (!queue.isEmpty()) {
                    int[] cur = queue.poll();
                    for (int i = 0; i < 4; i++) {
                        int ny = cur[0] + dy[i];
                        int nx = cur[1] + dx[i];
                        if (!vaild(ny, nx)) continue;
                        if (board[ny][nx] == 0) continue;
                        if (visit[ny][nx]) continue;
                        visit[ny][nx] = true;
                        queue.add(new int[] {ny, nx});
                    }
                }
            }
        }
        return cnt;
    }

    public static boolean vaild(int y, int x) {
        if (y == -1 || x == -1 || y == n || x == m) return false;
        return true;
    }



    public static void main(String args[]) throws IOException
    {
        input();
        pro();
    }
}