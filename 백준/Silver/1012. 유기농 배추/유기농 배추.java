import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int test_case, arrY, arrX, N;
    static boolean[][] arr;

    static int[] dy = new int[]{0, 1, 0, -1};
    static int[] dx = new int[]{1, 0, -1, 0};

    static void input() {

        arrX = scan.nextInt();
        arrY = scan.nextInt();

        N = scan.nextInt();
        arr = new boolean[arrY][arrX];

        for (int i = 0; i < N; i++) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            arr[y][x] = true;
        }
    }

    // x 를 갈 수 있다는 걸 알고 방문한 상태
    static void dfs(int y, int x) {

        arr[y][x] = false;
        for (int i = 0; i < 4; i++) {
            int nextY = y + dy[i];
            int nextX = x + dx[i];
            if (nextX == -1 || nextX == arrX || nextY == -1 || nextY == arrY) continue;
            if (arr[nextY][nextX]) dfs(nextY, nextX);
        }
    }
//    static void pro() {
//
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < N; j++) {
//                cur = 0;
//                dfs(i, j);
//                if (cur != 0) houseCnt.add(cur);
//            }
//        }
//
//        Collections.sort(houseCnt);
//        sb.append(cnt).append('\n');
//        for (int i: houseCnt) {
//            sb.append(i).append('\n');
//        }
//        System.out.println(sb);
//    }

//    static void bfs(int y, int x) {
//
//        if (visit[y][x] || arr[y][x] == '0') return;
//        Queue<int[]> que = new LinkedList<>();
//        /* TODO */
//        visit[y][x] = true;
//        que.add(new int[]{y, x});
//        int cnt = 1;
//
//        while (!que.isEmpty()) {
//            int[] point = que.poll();
//            for (int i = 0; i < 4; i++) {
//                int nextY = point[0] + dy[i];
//                int nextX = point[1] + dx[i];
//                if (nextX == -1 || nextX == N || nextY == -1 || nextY == N) continue;
//                if (arr[nextY][nextX] == '1' && !visit[nextY][nextX]) {
//                    cnt++;
//                    que.add(new int[]{nextY, nextX});
//                    visit[nextY][nextX] = true;
//                }
//            }
//        }
//
//        houseCnt.add(cnt);
//    }

    static void pro() {

        int cnt = 0;
        for (int i = 0; i < arrY; i++) {
            for (int j = 0; j < arrX; j++) {
                if (arr[i][j]) {
                    cnt++;
                    dfs(i, j);
                }
            }
        }
        System.out.println(cnt);
    }

    public static void main(String[] args) {

        test_case = scan.nextInt();
        for (int tc = 0; tc < test_case; tc++) {
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