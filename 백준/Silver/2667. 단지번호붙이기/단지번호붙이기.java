import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, cnt = 0, cur = 0;
    static boolean[][] visit;
    static char[][] arr;

    static int[] dy = new int[]{0, 1, 0, -1};
    static int[] dx = new int[]{1, 0, -1, 0};

    static List<Integer> houseCnt;

    static void input() {

        N = scan.nextInt();
        visit = new boolean[N][N];
        arr = new char[N][N];

        for (int i = 0; i < N; i++)
            arr[i] = scan.nextLine().toCharArray();

        houseCnt = new ArrayList<>();
    }

    // x 를 갈 수 있다는 걸 알고 방문한 상태
    static void dfs(int y, int x) {
        if (arr[y][x] == '0' || visit[y][x]) return;
        if (cur == 0) cur++;

        visit[y][x] = true;
        for (int i = 0; i < 4; i++) {
            int nextY = y + dy[i];
            int nextX = x + dx[i];
            if (nextX == -1 || nextX == N || nextY == -1 || nextY == N) continue;
            if (arr[nextY][nextX] == '1' && !visit[nextY][nextX]) {
                cur++;
                dfs(nextY, nextX);
            }
        }
    }

    // start 에서 시작해서 갈 수 있는 정점들을 모두 탐색하기
//    static void bfs(int y, int x) {
//        Queue<Integer> que = new LinkedList<>();
//        /* TODO */
//        visit[start] = true;
//        que.add(start);
//
//        while (!que.isEmpty()) {
//            int x = que.poll();
//            sb.append(x).append(' ');
//            for (int y: adj[x]) {
//                if (!visit[y]) {
//                    que.add(y);
//                    visit[y] = true;
//                }
//            }
//        }
//    }

    static void pro() {

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                dfs(i, j);
                if (cur != 0) {
                    houseCnt.add(cur);
                    cur = 0;
                }
            }
        }

        Collections.sort(houseCnt);
        sb.append(houseCnt.size()).append('\n');
        for (int i: houseCnt) {
            sb.append(i).append('\n');
        }
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