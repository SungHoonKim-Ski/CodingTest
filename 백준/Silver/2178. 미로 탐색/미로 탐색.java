import java.io.*;
import java.util.*;


public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M, res = 10000;
    static boolean[][] graph;

    static int[][] dist;

    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};


    static void input() {

        N = scan.nextInt();
        M = scan.nextInt();
        graph = new boolean[N][M];
        dist = new int[N][M];

        for (int i = 0; i < N; i++) {
            char[] input = scan.next().toCharArray();
            for (int j = 0; j < M; j++) {
                graph[i][j] = input[j] == '1';
            }
        }
    }

    static void bfs(int y, int x) {

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) dist[i][j] = -1;
        }

        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{y, x});
        dist[y][x] = 1;

        while (!que.isEmpty()) {

            int[] cur = que.poll();
            for (int i = 0; i < 4; i++) {
                int ny = cur[0] + dy[i];
                int nx = cur[1] + dx[i];
                if (ny < 0 || nx < 0 || ny == N || nx == M) continue;
                if (!graph[ny][nx]) continue;
                if (dist[ny][nx] != -1) continue;
                que.add(new int[] {ny, nx});
                dist[ny][nx] = dist[cur[0]][cur[1]] + 1;
            }
        }
    }

    static void pro() {

        bfs(0, 0);
        System.out.println(dist[N - 1][M - 1]);
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
