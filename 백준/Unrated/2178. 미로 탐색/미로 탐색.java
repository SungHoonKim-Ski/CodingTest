import java.io.*;
import java.util.*;


public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M, res = 10000;
    static boolean[][] graph;
    static boolean[][] visit;

    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};


    static void input() {

        N = scan.nextInt();
        M = scan.nextInt();
        visit = new boolean[N][M];
        graph = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            char[] input = scan.next().toCharArray();
            for (int j = 0; j < M; j++) {
                graph[i][j] = input[j] == '1';
            }
        }
    }

    static void bfs() {

        Queue<int[]> que = new LinkedList<>();
        visit[0][0] = true;
        que.add(new int[]{0, 0, 1}); // y, x, cnt

        while (!que.isEmpty()) {

            int[] cur = que.poll();
            if (cur[0] == (N - 1) && cur[1] == (M - 1)) {
                res = Math.min(res, cur[2]);
                continue;
            }
            for (int i = 0; i < 4; i++) {
                int ny = cur[0] + dy[i];
                int nx = cur[1] + dx[i];
                if (ny < 0 || nx < 0 || ny == N || nx == M) continue;
                if (!graph[ny][nx]) continue;
                if (visit[ny][nx]) continue;
                que.add(new int[] {ny, nx, cur[2] + 1});
                visit[ny][nx] = true;
            }
        }
    }

//    static void dfs(int v) {
//        visit[v] = true;
//        for (int i: list[v]) {
//            if (!visit[i]) {
//                res++;
//                dfs(i);
//            }
//        }
//    }

    static void pro() {

        bfs();
        System.out.println(res);
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
