import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int r, c;
    static char[][] Graph;
    static boolean[][] visit;
    static int[] dy = new int[] {0, 1, 0, -1};
    static int[] dx = new int[] {1, 0, -1, 0};
    static ArrayList<int[]> fireArr;
    static int[] start;

    static void input(){

        r = scan.nextInt();
        c =  scan.nextInt();
        fireArr = new ArrayList<>();

        visit = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            char[] inputArr = scan.nextLine().toCharArray();;
            for (int j = 0; j < c; j++) {
                if (inputArr[j] == '.') continue;
                visit[i][j] = true;
                if (inputArr[j] == 'F') {
                    fireArr.add(new int[] {i, j, -1});
                } else if (inputArr[j] == 'J') {
                    start = new int[] {i, j, 0};
                }
//                else if (inputArr[j] == '#') {
//                    visit[i][j] = true;
//                }
            }
        }
    }

    static void pro() {

        int res = bfs();
        if (res == -1) System.out.println("IMPOSSIBLE");
        else System.out.println(res);
    }

    static int bfs() {

        if (start[0] == 0 || start[1] == 0 || start[0] == (r - 1) || start[1] == (c - 1))
            return 1;
        Queue<int[]> que = new LinkedList<>();

        que.addAll(fireArr);
        que.add(start);

        while (!que.isEmpty()) {

            int[] cur = que.poll();
            // cur[0] = y
            // cur[1] = x
            // cur[2] = J : moveCnt, fire : -1

            for (int i = 0; i < 4; i++) {
                int ny = cur[0] + dy[i];
                int nx = cur[1] + dx[i];

                if (ny == -1 || nx == -1 || ny == r || nx == c) continue;
                if (visit[ny][nx]) continue;
                visit[ny][nx] = true;

                if (cur[2] != -1) {
                    if (ny == 0 || nx == 0 || ny == (r - 1) || nx == (c - 1)) {
                        return cur[2] + 2; // move + 1, escape + 1
                    }
                    que.add(new int[] {ny, nx, cur[2] + 1});
                } else {

                    que.add(new int[] {ny, nx, -1});
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }


    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}