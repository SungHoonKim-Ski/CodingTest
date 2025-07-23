import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int[][] map;
    static int n = 9, zeroCnt;
    static boolean find = false;
    static int MAX = 1 << (n + 1);
    static int MASK = (MAX - 1) ^ 1;

    static int[] rowVisit;
    static int[] colVisit;
    static int[] boxVisit;

    static List<int[]> zeroList;

    static void input() throws Exception {
        map = new int[n][n];
        rowVisit = new int[MAX];
        colVisit = new int[MAX];
        boxVisit = new int[MAX];

        zeroList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] != 0) {
                    rowVisit[i] |= 1 << map[i][j];
                    colVisit[j] |= 1 << map[i][j];
                    boxVisit[(i / 3) * 3 + j / 3] |= 1 << map[i][j];
                } else {
                    zeroList.add(new int[] {i, j});
                }
            }
        }
        zeroCnt = zeroList.size();
    }

    public static void pro() {
        recur(0);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) sb.append(map[i][j]).append(' ');
            sb.append('\n');
        }
        System.out.println(sb);
    }

    static void recur(int depth) {
        if (find) return;
        if (depth == zeroCnt) {
            find = true;
            return;
        }

        int[] cur = zeroList.get(depth);
        int r = cur[0];
        int c = cur[1];

        if (map[r][c] != 0) {
            recur(depth + 1);
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

            recur(depth + 1);
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