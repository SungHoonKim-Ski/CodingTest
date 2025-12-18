import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int n, min = 1 << 30;
    static char[][] map;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        map = new char[n][n];
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        recur(0);
        System.out.println(min);
    }

    static void recur(int cur) {
        if (cur == n) {
            check();
            return;
        }

        recur(cur + 1);
        for (int i = 0; i < n; i++) {
            if (map[i][cur] == 'H') map[i][cur] = 'T';
            else map[i][cur] = 'H';
        }
        recur(cur + 1);
        for (int i = 0; i < n; i++) {
            if (map[i][cur] == 'H') map[i][cur] = 'T';
            else map[i][cur] = 'H';
        }
    }

    static void check() {
        int count = 0;
        for (int i = 0; i < n; i++) {
            int cur = 0;
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 'T') cur++;
            }
            count += Math.min(cur, n - cur);
        }

        min = Math.min(min, count);
    }
}