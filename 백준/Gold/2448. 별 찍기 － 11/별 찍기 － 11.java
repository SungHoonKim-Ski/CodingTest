import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer sb = new StringBuffer();
    static StringTokenizer st;

    static char[][] board;

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());

        board = new char[n][2 * n];
        calStars(0, n - 1, n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2 * n; j++) {
                if (board[i][j] != '*') sb.append(' ');
                else sb.append('*');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    private static void calStars(int y, int x, int n) {
        if (n == 3) {
            board[y][x] = '*';
            board[y + 1][x - 1] = '*';
            board[y + 1][x + 1] = '*';
            board[y + 2][x - 2] = '*';
            board[y + 2][x - 1] = '*';
            board[y + 2][x] = '*';
            board[y + 2][x + 1] = '*';
            board[y + 2][x + 2] = '*';
            return;
        }

        calStars(y, x, n / 2);
        calStars(y + n / 2, x - n / 2, n / 2);
        calStars(y + n / 2, x + n / 2, n / 2);
    }
}