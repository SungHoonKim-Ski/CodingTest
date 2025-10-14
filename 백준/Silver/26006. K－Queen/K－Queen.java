import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n, k;
    static HashSet<Long> queenMap;
    static int[] king;
    final static int[] dx = {0, 0, 1, -1, 0, 1, -1, 1, -1};
    final static int[] dy = {0, 1, 1, 1, -1, -1, -1, 0, 0};
    static boolean[] attackable;

    static void input() throws IOException{
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        queenMap = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        king = new int[] {x, y};
        attackable = new boolean[9];

        while (k-- > 0) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            for (int i = 0; i < 9; i++) {
                if (attackable[i]) continue;

                int kx = king[0] + dx[i];
                int ky = king[1] + dy[i];
                if (kx == 0 || ky == 0 || kx > n || ky > n) {
                    attackable[i] = true;
                    continue;
                }


                if (attackable(kx, ky, x, y)) {
                    attackable[i] = true;
                }
            }
        }
    }

    static void pro() {
        if (attackable[0]) {
            if (staleMate()) {
                System.out.println("CHECKMATE");
            } else {
                System.out.println("CHECK");
            }
        } else {
            if (staleMate()) {
                System.out.println("STALEMATE");
            } else {
                System.out.println("NONE");
            }
        }
    }

    static boolean staleMate() {
        for (int i = 1; i < 9; i++) {
            if (!attackable[i]) return false;
        }
        return true;
    }

    static boolean attackable(int kx, int ky, int qx, int qy) {
        if (kx == qx || ky == qy) return true;
        if (Math.abs(kx - qx) == Math.abs(ky - qy)) return true;
        return false;
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}