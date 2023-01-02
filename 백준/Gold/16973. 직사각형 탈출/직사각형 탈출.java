import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static BufferedReader br;
    static StringBuffer sb;
    static int[][] Plane;
    static boolean[][] Visited;
    static int result = -1;
    static int H, W, Fr, Fc, N, M, Sr, Sc;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuffer();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Plane = new int[N][M];
        Visited = new boolean[N][M];

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++) {
                Plane[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        Sr = Integer.parseInt(st.nextToken())-1;
        Sc = Integer.parseInt(st.nextToken())-1;
        Fr = Integer.parseInt(st.nextToken())-1;
        Fc = Integer.parseInt(st.nextToken())-1;

        BFS();
        System.out.println(result);
    }

    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    public static void BFS() {

        Visited[Sr][Sc] = true;
        Queue<Point> queue = new LinkedList<>();

        queue.add(new Point(Sr, Sc, 0));
        while (!queue.isEmpty()) {

            Point point = queue.poll();
            for (int i=0; i<4; i++) {
                int prevR = point.r + dr[i];
                int prevC = point.c + dc[i];

                if (prevR == Fr && prevC == Fc) {
                    result = point.move + 1;
                    return;
                }
                if (prevR < 0 || prevC < 0 || (prevR + H) > N || (prevC + W) > M || Visited[prevR][prevC]) {
                    continue;
                }
                if (Plane[prevR][prevC] == 0) {
                    if (check(prevR, prevC)) {
                        queue.add(new Point(prevR, prevC, point.move+1));
                        Visited[prevR][prevC] = true;
                    }
                }

            }
        }
    }

    public static boolean check(int r, int c) {

        for (int i=0; i<H; i++) {
            for (int j=0; j<W; j++) {
                if (Plane[r + i][c + j] == 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public static class Point {
        int r;
        int c;
        int move;
        Point(int r, int c, int move) {
            this.r = r;
            this.c = c;
            this.move = move;
        }
    }
}