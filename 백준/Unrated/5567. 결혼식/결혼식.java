import java.io.*;
import java.util.*;


public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int M, N, cnt = -1;
    static List<Integer>[] list;
    static boolean[] visit;

    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};

    static void input() {

        N = scan.nextInt();
        M = scan.nextInt();
        list = new List[N + 1];
        visit = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            list[i] = new LinkedList<>();
        }

        for (int i = 0; i < M; i++) {
            int s = scan.nextInt();
            int e = scan.nextInt();
            list[s].add(e);
            list[e].add(s);
        }
    }

//    static void bfs() {
//
//        Queue<int[]> que = new LinkedList<>();
//
//        visit[1] = true;
//        que.add(new int[]{curY, curX});
//        dist[curY][curX] = 1;
//
//        while (!que.isEmpty()) {
//
//            int[] cur = que.poll();
//            for (int i = 0; i < 8; i++) {
//                int ny = cur[0] + dy[i];
//                int nx = cur[1] + dx[i];
//                if (ny <= 0 || nx <= 0 || ny > N || nx > N) continue;
//                if (dist[ny][nx] != 0) continue;
//                que.add(new int[] {ny, nx});
//                dist[ny][nx] = dist[cur[0]][cur[1]] + 1;
//            }
//        }
//    }

    static void dfs(int start, int depth) {

        if (depth > 2) return;
        
        if (!visit[start]) {
            visit[start] = true;
            cnt++;
        }

        for (int end: list[start]) {
            dfs(end, depth + 1);
        }
    }

    static void pro() {

        dfs(1, 0);
        System.out.println(cnt);
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
