import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int W, H;
    static boolean[][] graph;

    static int[] dy = new int[]{0, 1, 0, -1, 1, 1, -1, -1};
    static int[] dx = new int[]{1, 0, -1, 0, 1, -1, 1, -1};

    static void input() {

        graph = new boolean[H + 1][W + 1];

        for (int i = 1; i <= H; i++) {
            for (int j = 1; j <= W; j++) {
                if (scan.nextInt() == 1) graph[i][j] = true;
            }
        }
    }

    static void dfs(int y, int x) {

        graph[y][x] = false;
        for (int i = 0; i < 8; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny == 0 || nx == 0 || ny == H + 1 || nx == W + 1) continue;
            if (graph[ny][nx]) dfs(ny, nx);
        }
    }

    static void bfs(int y, int x) {

        Queue<int[]> que = new LinkedList<>();
        graph[y][x] = false;
        que.add(new int[] {y, x});

        while (!que.isEmpty()) {

            int[] point = que.poll();
            for (int i = 0; i < 8; i++) {
                int ny = point[0] + dy[i];
                int nx = point[1] + dx[i];
                if (ny == 0 || nx == 0 || ny == H + 1 || nx == W + 1) continue;
                if (graph[ny][nx]) {
                    que.add(new int[] {ny, nx});
                    graph[ny][nx] = false;
                }
            }
        }
    }

    static void pro() {

        int cnt = 0;
        for (int i = 1; i <= H; i++) {
            for (int j = 1; j <= W; j++) {
                if (graph[i][j]) {
                    cnt++;
                    dfs(i, j);
                }
            }
        }
        System.out.println(cnt);
    }

    public static void main(String[] args) {

        while (true) {
            W = scan.nextInt();
            H = scan.nextInt();
            if (W == 0 && H == 0) break;
            input();
            pro();
        }
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