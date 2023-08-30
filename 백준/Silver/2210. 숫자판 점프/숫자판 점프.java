import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer sb = new StringBuffer();
    static StringTokenizer st;

    static int[][] inputArr;
    static boolean[][] visit;
    static Pos[] elements;

    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};

    static int n = 5;

    static HashSet<Integer> resSet;

    public static void input() throws IOException{

        elements = new Pos[6];

        inputArr = new int[n][n];

        for (int i = 0 ; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                inputArr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        resSet = new HashSet<>();
    }

    public static void pro() {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                elements[0] = new Pos(i, j);
                backtracking(1);
            }
        }
//        System.out.println(sb);
        System.out.println(resSet.size());
    }

    public static void backtracking(int depth) {

        if (depth == 6) {
            sb.setLength(0);
            for (Pos pos : elements) {
                sb.append(inputArr[pos.y][pos.x]);
            }
            resSet.add(Integer.parseInt(sb.toString()));
            return;
        }

        for (int i = 0; i < 4; i++) {

            int ny = elements[depth - 1].y + dy[i];
            int nx = elements[depth - 1].x + dx[i];
            if (isNotPossible(ny, nx)) continue;
            elements[depth] = new Pos(ny, nx);
            backtracking(depth + 1);
        }
    }

    static boolean isNotPossible(int y, int x) {
        if (y == n || x == n || y == -1 || x == -1) return true;
        return false;
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
