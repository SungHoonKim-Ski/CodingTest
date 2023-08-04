import java.io.*;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static StringTokenizer st;

    static int N, K, L, MoveCnt;
    static int[][] board;
    static int curY = 0, curX = 0;

    static int dir = 0;

    static int[] dy = new int[] {0, 1, 0, -1};
    static int[] dx = new int[] {1, 0, -1, 0};
    static Deque<int[]> SnakeDeque;
    static LinkedList<Integer> ChangeList;

    static void input() throws IOException
    {
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        board = new int[N][N];
        board[0][0] = -1;
        SnakeDeque = new ArrayDeque<>();
        SnakeDeque.add(new int[] {0,0});
        while (K-- > 0) {
            st = new StringTokenizer(br.readLine());
            int appleY = Integer.parseInt(st.nextToken()) - 1;
            int appleX = Integer.parseInt(st.nextToken()) - 1;
            board[appleY][appleX] = 1;
        }

        L = Integer.parseInt(br.readLine());
        ChangeList = new LinkedList<>();
        while (L-- > 0) {
            st = new StringTokenizer(br.readLine());
            int move = Integer.parseInt(st.nextToken());
            char c = st.nextToken().charAt(0);
            if (c == 'L') move = -move;
            ChangeList.add(move);
        }
        ChangeList.add(N);

    }

    static void pro() throws IOException
    {

        while (!ChangeList.isEmpty()) {
            if (!move(ChangeList.poll())) break;
        }
        System.out.println(MoveCnt);
    }

    static boolean move(int destination) {

        int absDest = Math.abs(destination);

        for (int i = MoveCnt; i != absDest; i++) {
            MoveCnt++;
            int ny = curY + dy[dir];
            int nx = curX + dx[dir];

            if (ny == -1 || nx == -1 || ny == -1 || nx == -1 || ny == N || nx == N || board[ny][nx] == -1) {
                return false;
            }

            if (board[ny][nx] != 1) {
                int[] lastSnake = SnakeDeque.pollLast();
                board[lastSnake[0]][lastSnake[1]] = 0;
            }
            board[ny][nx] = -1;
            SnakeDeque.addFirst(new int[] {ny, nx});
            curY = ny;
            curX = nx;

        }
        rotate(destination);
        return true;
    }

    static void rotate(int destination) { // - left, + right

        if (destination < 0) { // 왼쪽으로 회전
            dir--;
            if (dir == -1) dir = 3;
        } else { // 오른쪽으로 회전
            dir++;
            if (dir == 4) dir = 0;
        }
    }

    public static void main(String[] args) throws IOException{
        input();
        pro();
    }

}