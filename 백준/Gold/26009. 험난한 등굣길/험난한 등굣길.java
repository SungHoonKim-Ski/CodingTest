import java.io.*;
import java.util.*;

class Main {

    static class Busy {
        int r, c, d;
        Busy(int _r, int _c, int _d) {
            r = _r; c = _c; d = _d;
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static boolean[][] visit;
    static Busy[] busyArr;
    static int n, m, k;
    static void input() throws IOException{
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visit = new boolean[n + 1][m + 1];


        k = Integer.parseInt(br.readLine());
        busyArr = new Busy[k];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int r, d, c;
            r = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            busyArr[i] = new Busy(r, d, c);
        }

    }

    static boolean valid(int r, int c) {
        if (r < 1 || c < 1 || r > n || c > m) return false;
        return true;
    }

//    static void print() {
//
//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j <= m; j++) {
//                if (visit[i][j]) sb.append('1');
//                else sb.append('0');
//            }
//            sb.append('\n');
//        }
//        System.out.println(sb);
//        sb.setLength(0);
//    }

    static void pro() {

        int[] dy = {0, 1, 0, -1};
        int[] dx = {1, 0, -1, 0};
        for (int i = 0; i < k; i++) {
            Busy busy = busyArr[i];

            for (int d = 0; d <= busy.d; d++) {

                int x = busy.d - d;
                int y = d;

                int r, c;
                r = busy.r + x;
                c = busy.c + y;

                if (valid(r, c)) {
                    visit[r][c] = true;
                }

                r = busy.r + x;
                c = busy.c - y;

                if (valid(r, c)) {
                    visit[r][c] = true;
                }

                r = busy.r - x;
                c = busy.c + y;

                if (valid(r, c)) {
                    visit[r][c] = true;
                }

                r = busy.r - x;
                c = busy.c - y;

                if (valid(r, c)) {
                    visit[r][c] = true;
                }

//                print();

            }

        }



        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {1, 1, 0});

        int canVisit = -1;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (cur[0] == n && cur[1] == m) {
                canVisit = cur[2];
                break;
            }
            for (int i = 0; i < 4; i++) {
                int ny = cur[0] + dy[i];
                int nx = cur[1] + dx[i];
                if (ny == 0 || nx == 0) continue;
                if (ny == n + 1 || nx == m + 1) continue;
                if (visit[ny][nx]) continue;
                visit[ny][nx] = true;
                queue.add(new int[] {ny, nx, cur[2] + 1});
            }
        }

        if (canVisit != -1) sb.append("YES").append('\n').append(canVisit);
        else sb.append("NO");

        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception{
        input();
        pro();
    }
}