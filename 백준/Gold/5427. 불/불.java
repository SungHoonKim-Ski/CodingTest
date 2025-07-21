import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int r, c;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static char[][] map;

    static ArrayList<int[]> fire, sang;
    static int escape;
    static int[][] visit;

    static void input() throws Exception {
        st = new StringTokenizer(br.readLine());

        c = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        map = new char[r][c];
        visit = new int[r][c];

        fire = new ArrayList<>();
        sang = new ArrayList<>();
        for (int i = 0; i < r; i++) {
            char[] str = br.readLine().toCharArray();
            for (int j = 0; j < c; j++) {
                map[i][j] = str[j];
                if (map[i][j] == '@') {
                    map[i][j] = '.';
                    sang.add(new int[] {i, j});
                    visit[i][j] = 1;
                    continue;
                }
                if (map[i][j] == '*') {
                    fire.add(new int[] {i, j});
                    continue;
                }
            }
        }
    }

    public static void pro() {
        escape = -1;
        while (true) {
            moveFire();
            if (!moveSang() || (escape != -1)) {
                break;
            }
        }
        if (escape == -1) sb.append("IMPOSSIBLE");
        else sb.append(escape);

        sb.append('\n');
    }

    static boolean moveSang() {
        ArrayList<int[]> curSangs = new ArrayList<>(sang);
        sang.clear();

        for (int[] curSang : curSangs) {
            for (int i = 0; i < 4; i++) {
                int nr = curSang[0] + dr[i];
                int nc = curSang[1] + dc[i];

                if (!checkRange(nr, nc)) {
                    escape = visit[curSang[0]][curSang[1]];
                    return true;
                }

                if (map[nr][nc] == '#' || map[nr][nc] == '*') continue;
                if (visit[nr][nc] != 0) continue;
                visit[nr][nc] = visit[curSang[0]][curSang[1]] + 1;
                sang.add(new int[] {nr, nc});
            }
        }
        if (sang.size() == 0) return false;
        else return true;
    }

    static void moveFire() {
        ArrayList<int[]> curFires = new ArrayList<>(fire);
        fire.clear();

        for (int[] curFire : curFires) {
            for (int i = 0; i < 4; i++) {
                int nr = curFire[0] + dr[i];
                int nc = curFire[1] + dc[i];

                if (!checkRange(nr, nc)) continue;
                if (map[nr][nc] == '#' || map[nr][nc] == '*') continue;
                map[nr][nc] = '*';
                fire.add(new int[] {nr, nc});
            }
        }

    }

    static boolean checkRange(int nr, int nc) {
        if (nr >= r || nc >= c || nr < 0 || nc < 0) return false;
        return true;
    }

    public static void main(String[] args) throws Exception{
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            input();
            pro();
        }
        System.out.println(sb);
    }
}