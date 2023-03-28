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
//                bfs(i);
            }
        }
    }

    static void bfs(int start) {

        Queue<Integer> que = new LinkedList<>();
        visit[start] = true;
        que.add(start);

        while (!que.isEmpty()) {
            int s = que.poll();
            for (int i = 1; i <= N; i++) {
                if (graph[s][i] && !visit[i]) {
                    que.add(i);
                    visit[i] = true;
                }
            }
        }
    }

    static void pro() {

        int cnt = 0;
        for (int i = 1; i <= N;  i++) {
            if (!visit[i]) {
                bfs(i);
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