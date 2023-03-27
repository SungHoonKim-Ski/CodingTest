import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int R, C, cntO = 0, cntV = 0, curO = 0, curV = 0;
    static char[][] graph;
    static boolean[][] visit;

    static int[] dy = new int[]{0, 1, 0, -1};
    static int[] dx = new int[]{1, 0, -1, 0};

    static void input() {

        R = scan.nextInt();
        C = scan.nextInt();
        graph = new char[R][C];
        visit = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            graph[i] = scan.nextLine().toCharArray();
        }
    }

    static void dfs(int y, int x) {

        visit[y][x] = true;
        char c = graph[y][x];
        if (c == 'o') {
            curO++;
        } else if (c == 'v') {
            curV++;
        }

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny == -1 || nx == -1 || ny == R || nx == C) continue;
            if (visit[ny][nx]) continue;
            if (graph[ny][nx] == '#') continue;
            dfs(ny, nx);
        }
    }

    static void bfs(int y, int x) {

//        Queue<int[]> que = new LinkedList<>();
//        graph[y][x] = false;
//        que.add(new int[] {y, x});
//
//        while (!que.isEmpty()) {
//
//            int[] point = que.poll();
//            for (int i = 0; i < 8; i++) {
//                int ny = point[0] + dy[i];
//                int nx = point[1] + dx[i];
//                if (ny == 0 || nx == 0 || ny == H + 1 || nx == W + 1) continue;
//                if (graph[ny][nx]) {
//                    que.add(new int[] {ny, nx});
//                    graph[ny][nx] = false;
//                }
//            }
//        }
    }

    static void pro() {

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if ((graph[i][j] == 'o' || graph[i][j] == 'v') && !visit[i][j]) {
                    curO = 0;
                    curV = 0;
                    dfs(i, j);
                    if (curO > curV) {
                        cntO += curO;
                    }else {
                        cntV += curV;
                    }
                }
            }
        }
        sb.append(cntO).append(' ').append(cntV);
        System.out.println(sb);
    }

    public static void main(String[] args) {

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