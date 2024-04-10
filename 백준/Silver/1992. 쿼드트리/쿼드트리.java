import java.io.*;
import java.util.*;

public class Main {

    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int n;
    static char[][] board;

    static void input() throws IOException{
        n = Integer.parseInt(br.readLine());
        board = new char[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {

            char[] arr = br.readLine().toCharArray();
            for (int j = 1; j <= n; j++) {
                board[i][j] = arr[j - 1];
            }
        }
    }

    static void pro() {
        dfs(1, 1, n, n);
        System.out.println(sb);
    }

    static void dfs(int startX, int startY, int endX, int endY) {

        boolean isSame = true;

        char curDot = board[startY][startX];

        for (int i = startY; i <= endY; i++) {
            for (int j = startX; j <= endX; j++) {
                if (curDot != board[i][j]) {
                    isSame = false;
                    break;
                }
            }
            if (!isSame) break;
        }

        if (isSame) sb.append(curDot);
        else {
            int midX = (startX + endX) / 2;
            int midY = (startY + endY) / 2;
            sb.append('(');

            dfs(startX, startY, midX, midY);

            dfs(midX + 1, startY, endX, midY);

            dfs(startX, midY + 1, midX, endY);

            dfs(midX + 1, midY + 1, endX, endY);
            sb.append(')');
        }
    }

    public static void main(String[] args) throws IOException{
        input();
        pro();
    }
}