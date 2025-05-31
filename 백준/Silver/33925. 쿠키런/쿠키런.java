import java.io.*;
import java.util.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, j, s, h, k, maxHp = -1;
    static char[][] map;

    static void input() throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 배열수
        j = Integer.parseInt(st.nextToken()); // 점프
        s = Integer.parseInt(st.nextToken()); // 슬라이드
        h = Integer.parseInt(st.nextToken()); // 체력
        k = Integer.parseInt(st.nextToken()); // 피격시 데미지 감소

        map = new char[3][n];
        for (int i = 0; i < 3; i++) {
            char[] str = br.readLine().toCharArray();
            map[i] = str;
        }
    }

    public static void pro() {

        int[] hurdles = new int[3];

        for (int i = 0; i < n; i++) {
            char[] curMap = new char[] {map[0][i], map[1][i], map[2][i]};
            int[] count = new int[3];
            for (int m = 0; m < 3; m++) {
                if (curMap[m] == '.') count[0]++;
                else if (curMap[m] == '^') count[1]++;
                else count[2]++;
            }

            if (count[0] == 3) continue;

            if (count[1] == 2) {
                hurdles[1]++;
                continue;
            }
            if (count[1] == 1) {
                hurdles[0]++;
                continue;
            }
            hurdles[2]++;
        }

        s -= hurdles[2];
        if (s < 0) {
            h -= - s * k;
        }

        j -= hurdles[0];
        if (j < 0) {
            h -= - j * k;
            j = 0;
        }
        j -= hurdles[1] * 2;
        if (j < 0) {
            h -= (-j + 1) / 2 * k;
        }

        if (h > 0) System.out.println(h);
        else System.out.println(-1);
    }

    public static void main(String[] args) throws Exception{
        input();
        pro();
    }
}
