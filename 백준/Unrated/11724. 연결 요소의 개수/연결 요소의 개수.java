import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static boolean[][] graph;
    static boolean[] visit;

    static int[] dy = new int[]{0, 1, 0, -1};
    static int[] dx = new int[]{1, 0, -1, 0};

    static void input() {

        N = scan.nextInt();
        graph = new boolean[N + 1][N + 1];
        visit = new boolean[N + 1];

        M = scan.nextInt();
        for (int i = 1; i <= M; i++) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            graph[y][x] = true;
            graph[x][y] = true;
        }
    }

    static void dfs(int start) {

        visit[start] = true;
        for (int i = 1; i <= N; i++) {
            if (graph[start][i] && !visit[i]) {
                dfs(i);
            }
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
//        Queue<int[]> que = new LinkedList<>();
//        arr[y][x] = false;
//        que.add(new int[]{y, x});
//
//        while (!que.isEmpty()) {
//            int[] point = que.poll();
//            for (int i = 0; i < 4; i++) {
//                int nextY = point[0] + dy[i];
//                int nextX = point[1] + dx[i];
//                if (nextX == -1 || nextX == arrX || nextY == -1 || nextY == arrY) continue;
//                if (arr[nextY][nextX]) {
//                    que.add(new int[]{nextY, nextX});
//                    arr[nextY][nextX] = false;
//                }
//            }
//        }
//    }

    static void pro() {

        int cnt = 0;
        for (int i = 1; i <= N;  i++) {
            if (!visit[i]) {
                dfs(i);
                cnt++;
            }
        }
        System.out.println(cnt);
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