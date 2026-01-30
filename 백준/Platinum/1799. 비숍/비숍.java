import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int max = 0;
    static int n;
    static boolean[] left, right;
    static ArrayList<Integer>[] black, white;

    static void input() throws IOException {
        n = Integer.parseInt(br.readLine());
        black = new ArrayList[n + 1];
        white = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            black[i] = new ArrayList<>();
            white[i] = new ArrayList<>();
        }

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                int c = Integer.parseInt(st.nextToken());
                if (c == 0) continue;

                if (((i + j) % 2) == 0) black[i].add(j);
                else white[i].add(j);
            }
        }
    }

    static boolean check(int y, int x) {
        if (left[y + x] || right[y - x + n]) return false;
        return true;
    }

    static void whiteDfs(int y, int xIdx, int cnt) {
        if (y > n) {
            max = Math.max(max, cnt);
            return;
        }

        for (int i = xIdx; i < white[y].size(); i++) {
            int j = white[y].get(i);

            if (check(y, j)) {
                left[y + j] = true;
                right[y - j + n] = true;

                whiteDfs(y, i + 1, cnt + 1);

                left[y + j] = false;
                right[y - j + n] = false;
            }
        }

        whiteDfs(y + 1, 0, cnt);
    }

    static void blackDfs(int y, int xIdx, int cnt) {
        if (y > n) {
            max = Math.max(max, cnt);
            return;
        }

        for (int i = xIdx; i < black[y].size(); i++) {
            int j = black[y].get(i);

            if (check(y, j)) {
                left[y + j] = true;
                right[y - j + n] = true;

                blackDfs(y, i + 1, cnt + 1);

                left[y + j] = false;
                right[y - j + n] = false;
            }
        }

        blackDfs(y + 1, 0, cnt);
    }

    static void pro() {
        left = new boolean[n * 3];
        right = new boolean[n * 3];
        whiteDfs(1, 0, 0);
        int w = max;
        
        max = 0;
        left = new boolean[n * 3];
        right = new boolean[n * 3];
        blackDfs(1, 0, 0);
        int b = max;

        System.out.println(w + b);
    }


    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
