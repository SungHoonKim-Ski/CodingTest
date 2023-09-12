import java.io.*;
import java.util.*;

public class Main {
    
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    
    static int n, whiteCnt, blueCnt;
    static boolean[][] board;

    static void input() throws IOException{
        
        n = Integer.parseInt(br.readLine());
        board = new boolean[n][n];
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = st.nextToken().charAt(0) == '1';
            }
        }
    }

    static void pro() { // 1-true : blue, 0-false : white,
        divide(0, 0, n, n);
        System.out.println(whiteCnt);
        System.out.println(blueCnt);
    }

    static void divide(int startY, int startX, int endY, int endX) {

        boolean color = board[startY][startX];
        for (int i = startY; i < endY; i++) {
            for (int j = startX; j < endX; j++) {
                if (board[i][j] != color) {
                    divide(startY, startX, (startY+ endY) / 2, (startX + endX) / 2);
                    divide(startY, (startX + endX) / 2, (startY+ endY)/2, endX);
                    divide((startY + endY) / 2, startX, endY, (startX + endX) / 2);
                    divide((startY + endY) / 2, (startX + endX) / 2, endY, endX);
                    return;
                }
            }
        }
        if (color) blueCnt++;
        else whiteCnt++;
    }


    public static void main(String[] args) throws IOException{
        input();
        pro();
    }
}