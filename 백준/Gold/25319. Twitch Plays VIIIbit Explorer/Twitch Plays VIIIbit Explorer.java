import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n, m;
    static char[][] map;
    static ArrayDeque<int[]>[] alpha;
    static String idStr;
    static char[] candIdArr;
    static int[] loc;

    static void input() throws IOException{
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        for (int i = 0; i < n; i++) {
            char[] str = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                map[i][j] = str[j];
            }
        }

        idStr = br.readLine();
    }

    static void pro() {
        int c = calCandId();
        loc = new int[] {0, 0};

        for (char findChar : candIdArr) {
            int i = findChar - 'a';
            int[] goal = alpha[i].poll();

            find(loc[0], loc[1], goal[0], goal[1]);

            loc = goal;
            sb.append('P');
        }

        find(loc[0], loc[1], n - 1, m - 1);

        System.out.printf("%d %d\n%s\n", c, sb.length(), sb);
    }

    static void find(int x, int y, int rx, int ry) {
        if (x < rx) {
            while (x != rx) {
                sb.append('D');
                x++;
            }
        } else if (rx < x) {
            while (x != rx) {
                sb.append('U');
                x--;
            }
        }

        if (y < ry) {
            while (y != ry) {
                sb.append('R');
                y++;
            }
        } else if (ry < y) {
            while (y != ry) {
                sb.append('L');
                y--;
            }
        }
    }

    static int calCandId() {
        alpha = new ArrayDeque[30];
        for (int i = 0; i < 30; i++) {
            alpha[i] = new ArrayDeque<>();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                alpha[map[i][j] - 'a'].add(new int[] {i, j});
            }
        }


        int minCount = Integer.MAX_VALUE;
        int[] count = new int[30];
        for (char s : idStr.toCharArray()) {
            count[s - 'a']++;
        }
        for (int i = 0; i < 30; i++) {
            if (count[i] == 0) continue;
            minCount = Math.min(minCount, alpha[i].size() / count[i]);
        }

        for (int i = 0; i < minCount; i++) {
            sb.append(idStr);
        }

        candIdArr = sb.toString().toCharArray();
        sb.setLength(0);

        return minCount;
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}