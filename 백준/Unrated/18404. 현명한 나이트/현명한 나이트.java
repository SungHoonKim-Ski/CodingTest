import java.io.*;
import java.util.*;


public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int M, N;
    static int[][] dist;
    static int curX, curY;
    static int[][] goal;

    static int[] dy = {1, 1, 2, 2, -1, -1, -2, -2};
    static int[] dx = {2, -2, 1, -1, 2, -2, 1, -1};

    static void input() {

        N = scan.nextInt();
        M = scan.nextInt();
        curX = scan.nextInt();
        curY = scan.nextInt();

        dist = new int[N + 1][N + 1];
        goal = new int[M][2];

        for (int i = 0; i < M; i++) {
            goal[i][0] = scan.nextInt();
            goal[i][1] = scan.nextInt();
        }
    }

    static void bfs() {

        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{curY, curX});
        dist[curY][curX] = 1;

        while (!que.isEmpty()) {

            int[] cur = que.poll();
            for (int i = 0; i < 8; i++) {
                int ny = cur[0] + dy[i];
                int nx = cur[1] + dx[i];
                if (ny <= 0 || nx <= 0 || ny > N || nx > N) continue;
                if (dist[ny][nx] != 0) continue;
                que.add(new int[] {ny, nx});
                dist[ny][nx] = dist[cur[0]][cur[1]] + 1;
            }
        }
    }



    static void pro() {

        bfs();
        for (int i = 0; i < M; i++)
            sb.append(dist[goal[i][1]][goal[i][0]] - 1).append(' ');
        System.out.println(sb);
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
