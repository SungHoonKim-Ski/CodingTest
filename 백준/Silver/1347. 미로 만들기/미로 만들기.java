import java.util.*;
import java.io.*;
import java.math.*;


public class Main
{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer sb = new StringBuffer();
    static StringTokenizer st;

    static int MAX_VALUE = 100;
    static boolean[][] Visit = new boolean[MAX_VALUE][MAX_VALUE];
    static char[] InputCharArr;

    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};

    static int Dir = 1, N;


    public static void input() throws IOException{
        N = Integer.parseInt(br.readLine());
        InputCharArr = br.readLine().toCharArray();
    }

    public static void pro() {

        searchMap();
        int[] squarePos = getSquare();
        printMap(squarePos);
    }

    public static void searchMap() {
        int curY = 50, curX = 50;
        Visit[curY][curX] = true;

        for (int i = 0; i < InputCharArr.length; i++) {
            switch (InputCharArr[i]) {
                case 'F':
                    curY += dy[Dir];
                    curX += dx[Dir];
                    Visit[curY][curX] = true;
                    break;
                case 'L':
                    Dir = (Dir + 3) % 4;
                    break;
                case 'R':
                    Dir = (Dir + 1) % 4;
                    break;
                default:
                    break;
            }
        }
    }

    public static int[] getSquare(){

        // x1 y1 -> 좌측 상단 x2 y2 -> 우측 하단 으로 이루어진 배열
        int[] square = new int[4];
        square[0] = square[1] = MAX_VALUE;// 우측 상단은 최소값으로 계산 필요 -> 0 제거

        for (int i = 0; i < MAX_VALUE; i++) {
            for (int j = 0; j < MAX_VALUE; j++) {
                if (!Visit[i][j]) continue;
                square[0] = Math.min(i, square[0]);
                square[1] = Math.min(j, square[1]);
                square[2] = Math.max(i, square[2]);
                square[3] = Math.max(j, square[3]);
            }
        }
        return square;
    }

    public static void printMap(int[] square) {

        for (int i = square[0]; i <= square[2]; i++) {
            for (int j = square[1]; j <= square[3]; j++) {
                if (Visit[i][j]) sb.append('.');
                else sb.append('#');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }


    public static void main(String args[]) throws IOException
    {
        input();
        pro();

    }
}