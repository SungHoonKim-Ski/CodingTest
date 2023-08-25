import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer sb = new StringBuffer();
    static StringTokenizer st;

    static int r, c, time, cheeseCnt;
    static boolean[][] visit;
    static boolean[][] board;

    static LinkedList<Pos> que;
    static final int[] dy = {0, 1, 0, -1};
    static final int[] dx = {1, 0, -1, 0};
    
    public static void input() throws IOException{

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        board = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                board[i][j] = st.nextToken().charAt(0) == '1';
                if (board[i][j]) cheeseCnt++;
            }
        }

        que = new LinkedList<>();
    }

    public static void pro() {

        while (true) {
            time++;
            int meltCheeseCnt = bfs();
            if (cheeseCnt - meltCheeseCnt == 0) break;
            cheeseCnt -= meltCheeseCnt;
        }
        sb.append(time).append('\n').append(cheeseCnt);
        System.out.println(sb);
    }


    
    public static int bfs() {


        visit = new boolean[r][c];
        Pos pos = new Pos(0, 0);
        // 녹이기 시작하는 점은 무조건 0,0
        visit[pos.y][pos.x] = true;
        que.add(pos);

        int meltCheeseCnt = 0;

        while (!que.isEmpty()) {
            Pos cur = que.poll();
            for (int i = 0; i < 4; i++) {
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];
                if (!isVaild(ny, nx)) continue;
                if (visit[ny][nx]) continue;
                visit[ny][nx] = true;
                if (board[ny][nx]) {
                    board[ny][nx] = false; // 치즈 제거
                    meltCheeseCnt++;
                } else que.add(new Pos(ny, nx));
            }
        }

        return meltCheeseCnt;
    }

    static boolean isVaild(int y, int x) {
        if (r == y || x == c || y == -1 || x == -1) return false;
        return true;
    }
    
    static class Pos{
        int y, x;

        Pos(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws IOException{
            input();
            pro();
    }

}
