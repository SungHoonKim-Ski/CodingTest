import java.io.*;
import java.util.*;


public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int M, N, H, cnt = 0;
    static int[][][] graph;
    static boolean[][][] visit;

    static int[] dx = {1, 0, -1, 0, 0, 0};
    static int[] dy = {0, 1, 0, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};

    static Queue<int[]> queue;
    static void input() {

        M = scan.nextInt();
        N = scan.nextInt();
        H = scan.nextInt();

        graph = new int[H][N][M];
        visit = new boolean[H][N][M];
        queue = new LinkedList<>();
        
        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    int input = scan.nextInt();
                    if (input != 0) {
                        graph[h][n][m] = input;
                        visit[h][n][m] = true;
                        if (input == 1) {
                            queue.add(new int[] {h, n, m, 0});
                        }
                    }else {
                        cnt++;
                    }
                }
            }
        }
    }

    static int bfs() {

        int day = 0;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll(); // z, y, x, day
            for (int i = 0; i < 6; i++) {

                int nz = cur[0] + dz[i];
                int ny = cur[1] + dy[i];
                int nx = cur[2] + dx[i];
                if (nz == H || ny == N || nx == M || nz < 0 || ny < 0 || nx < 0) continue;
                if (visit[nz][ny][nx]) continue;
                visit[nz][ny][nx] = true;
                queue.add(new int[] {nz, ny, nx, cur[3] + 1});
                day = cur[3] + 1;
                cnt--;
            }
        }
        if (cnt > 0) return -1;
        else return day;
    }

    static void pro() {

        System.out.println(bfs());
    }

    public static void main(String[] args) {
        input();
        pro();
    }


    static class FastReader {
        // BufferedReader의 빠른 속도,
        // + Scanner의 타입별 입력값을 받는 기능을 혼합
        // (자바 내부에 구현된 Scanner는 속도가 느림)
        // 다른분의 코드를 참고한 코드
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
