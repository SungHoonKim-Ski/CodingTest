import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer sb = new StringBuffer();
    static StringTokenizer st;

    static int y, x, minDisTime;
    static boolean[][] visit;

    static char[][] board;

    static LinkedList<Pos> que;


    static final int[] dy = {0, 1, 0, -1};
    static final int[] dx = {1, 0, -1, 0};
    
    public static void input() throws IOException{

        st = new StringTokenizer(br.readLine());
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        board = new char[y][x];

        for (int i = 0; i < y; i++) {
            board[i] = br.readLine().toCharArray();
        }

        que = new LinkedList<>();
    }

    public static void pro() {
        
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (board[i][j] == 'W') continue;

                bfs(new Pos(i, j, 0));
            }
        }
        System.out.println(minDisTime);
    }
    
    public static void bfs(Pos pos) { // stack 사용

        visit = new boolean[y][x];
        visit[pos.y][pos.x] = true;
        que.add(pos);

        while (!que.isEmpty()) {
            Pos cur = que.poll();
            minDisTime = Math.max(cur.dist, minDisTime);
            for (int i = 0; i < 4; i++) {
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];
                if (!isVaild(ny, nx)) continue;
                if (visit[ny][nx]) continue;
                if (board[ny][nx] == 'W') continue;
                visit[ny][nx] = true;
                que.add(new Pos(ny, nx, cur.dist + 1));
            }
        }
    }

    static boolean isVaild(int ny, int nx) {
        if (y == ny || x == nx || ny == -1 || nx == -1) return false;
        return true;
    }
    
    static class Pos{
        int y, x, dist;

        Pos(int y, int x, int dist) {
            this.y = y;
            this.x = x;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws IOException{
            input();
            pro();
    }

}
