import java.math.BigInteger;
import java.util.*;
import java.io.*;


public class Main
{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuffer sb = new StringBuffer();

//    static final int[] dy = {0, 1, 0, -1, 1, -1, 1, -1};
    static final int[] dy = {-1, 0, 1, 1};
//    static final int[] dx = {1, 0, -1, 0, 1, 1, -1, -1};
    static final int[] dx = {1, 1, 1, 0};

    static final int SIZE = 19;

    static int[][] board;

    public static void input() throws IOException{

        board = new int[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
    public static void pro() {

        int[] resPos = new int[2];
        int winColor = 0;

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                int color = board[i][j];
                if (color == 0) continue;
                if (isWin(color, i, j)) {
                    resPos[0] = i + 1;
                    resPos[1] = j + 1;
                    winColor = color;
                }
                if (winColor != 0) break;
            }
            if (winColor != 0) break;
        }
        sb.append(winColor);
        if (winColor != 0) sb.append('\n').append(resPos[0]).append(' ').append(resPos[1]);
        System.out.println(sb);
    }

    public static boolean isWin(int color, int y, int x) {
        for (int i = 0; i < dx.length; i++) {
            int vy = y + dy[i] * 4;
            int vx = x + dx[i] * 4;
            if (!vaildPos(vy, vx)) continue;
            if (vaildDir(color, i, y, x)) return true;
        }
        return false;
    }

    public static boolean vaildPos(int y, int x) {
        if (y < 0|| x < 0 || y >= SIZE || x >= SIZE) return false;
        return true;
    }

    public static boolean vaildDir(int color, int dir, int y, int x) {

        int ny = y;
        int nx = x;
        int sameCnt = 1;
        for (int i = 0; i < 4; i++) {
            ny += dy[dir];
            nx += dx[dir];
            if (board[ny][nx] == color) sameCnt++;
            else break;
        }

        if (sameCnt != 5) return false;

        ny += dy[dir];
        nx += dx[dir];
        if (vaildPos(ny, nx)) {
            if (board[ny][nx] == color) sameCnt++;
        }

        ny = y - dy[dir];
        nx = x - dx[dir];
        if (vaildPos(ny, nx)) {
            if (board[ny][nx] == color) sameCnt++;
        }
        if (sameCnt == 5) return true;
        return false;
    }



    public static void main(String args[]) throws IOException
    {
        input();
        pro();
    }
}