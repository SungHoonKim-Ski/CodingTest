import java.io.*;
import java.util.*;

public class Main {

    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static boolean[][] board;
    static int n, m;

    static void init() {
        board = new boolean[101][101];
    }
    static void input() throws IOException{
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
    }

    static void pro() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                board[i + m][j + n] = true;
            }
        }
    }

    public static void main(String[] args) throws IOException{
        init();
        int tc = Integer.parseInt(br.readLine());
        while (tc -- > 0) {
            input();
            pro();
        }
        int count = 0;

        for (int i = 1; i <= 100; i++) {
            for (int j = 1; j <= 100; j++) {
                if (board[i][j]) count++;
            }
        }
        System.out.println(count);

    }
}