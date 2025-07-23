import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int[][] map;
    static int n = 9;
    static boolean find = false;
    static int MAX = 1 << (n + 1);
    static int MASK = (MAX - 1) ^ 1;

    static int[] rowVisit;
    static int[] colVisit;
    static int[] boxVisit;

    static void input() throws Exception {
        map = new int[n][n];
        rowVisit = new int[MAX];
        colVisit = new int[MAX];
        boxVisit = new int[MAX];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] != 0) {
                    rowVisit[i] |= 1 << map[i][j];
                    colVisit[j] |= 1 << map[i][j];
                    boxVisit[(i / 3) * 3 + j / 3] |= 1 << map[i][j];
                }
            }
        }
    }

    public static void pro() {
        recur(0, 0);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) sb.append(map[i][j]).append(' ');
            sb.append('\n');
        }
        System.out.println(sb);
    }

    static boolean check() {
        for (int i = 0; i < n; i++) {
            if (rowVisit[i] != MASK) return false;
            if (colVisit[i] != MASK) return false;
            if (boxVisit[i] != MASK) return false;
        }
        return true;
    }

    static void recur(int r, int c) {
        if (find) return;
        if (r == n) {
            boolean result = check();
            if (result) find = true;
            return;
        }
        int nc = c + 1;
        int nr = r;
        if (nc == n) {
            nr++;
            nc = 0;
        }

        if (map[r][c] != 0) {
            recur(nr, nc);
            return;
        }

        for (int i = 1; i <= n; i++) {
            if ((rowVisit[r] & (1 << i)) != 0) continue;
            if ((colVisit[c] & (1 << i)) != 0) continue;
            if ((boxVisit[(r / 3) * 3 + c / 3] & (1 << i)) != 0) continue;
            map[r][c] = i;
            rowVisit[r] |= 1 << i;
            colVisit[c] |= 1 << i;
            boxVisit[(r / 3) * 3 + c / 3] |= 1 << i;

            recur(nr, nc);
            if (find) return;

            map[r][c] = 0;
            rowVisit[r] ^= 1 << i;
            colVisit[c] ^= 1 << i;
            boxVisit[(r / 3) * 3 + c / 3] ^= 1 << i;
        }
    }


    public static void main(String[] args) throws Exception{
        input();
        pro();
    }
}