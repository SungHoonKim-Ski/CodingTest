import java.util.*;
import java.io.*;
import java.math.*;


public class Main
{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer sb = new StringBuffer();
    static StringTokenizer st;

    static ArrayList<int[]> InputArr;
    static int N, SIZE = 6;

    static int[] dy = {0, 1, 0, -1, 1, -1, 1, -1};
    static int[] dx = {1, 0, -1, 0, 1, 1, -1, -1};
    static int[][] Board;

    public static void init() {
        Board = new int[SIZE][SIZE];
        Board[2][2] = 2; // W
        Board[3][3] = 2; // W
        Board[2][3] = 1; // B
        Board[3][2] = 1; // B
    }
    public static void input() throws IOException{

        N = Integer.parseInt(br.readLine());
        InputArr = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            InputArr.add(new int[] {Integer.parseInt(st.nextToken()) - 1
                    , Integer.parseInt(st.nextToken()) - 1}); // 실제 인덱스 적용을 위한 -1
        }

    }

    static boolean canChange(int y, int x, int dy, int dx, int color) {

        int ny = y;
        int nx = x;

        while(true) {
            ny += dy;
            nx += dx;
            if (!valid(ny, nx)) return false;
            if (Board[ny][nx] == (3 - color)) continue;
            if (Board[ny][nx] == 0) return false;
            if (Board[ny][nx] == color) return true;
        }
    }

    static void change(int y, int x, int dy, int dx, int color) {

        int ny = y;
        int nx = x;
        while(true) {
            ny += dy;
            nx += dx;
            if (!valid(ny, nx)) return;
            if (Board[ny][nx] == (3 - color)) {
                Board[ny][nx] = color;
            } else return;
        }
    }

    public static boolean valid(int y, int x) {

        if (y == -1 || x == -1 || y == SIZE || x == SIZE) return false;
        return true;
    }

    public static void print() {

        int[] colorCnt = new int[3];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                int color = Board[i][j];
                colorCnt[color]++;
                if (color == 0){
                    sb.append('.');
                    continue;
                }
                if (color == 1){ // B
                    sb.append('B');
                } else { // == 2
                    sb.append('W'); // W
                }
            }
            sb.append('\n');
        }
        sb.append(colorCnt[2] > colorCnt[1] ? "White" : "Black");
        System.out.println(sb);
    }
    public static void pro() {

        for (int i = 0; i < N; i++) {
            int curColor = i % 2 + 1;
            int[] loc = InputArr.get(i);
            Board[loc[0]][loc[1]] = curColor;
            for (int j = 0; j < 8; j++) {
                if (canChange(loc[0], loc[1], dy[j], dx[j], curColor))
                    change(loc[0], loc[1], dy[j], dx[j], curColor);
            }
        }
    }
    public static void main(String args[]) throws IOException
    {
        init();
        input();
        pro();
        print();
    }
}