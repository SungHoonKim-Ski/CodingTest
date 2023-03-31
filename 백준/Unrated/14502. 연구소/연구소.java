import java.io.*;
import java.util.*;


public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static int cnt = 0;
    static int[][] graph;

    static int[] dy = new int[] {0, 1, 0, -1};
    static int[] dx = new int[] {1, 0, -1, 0};

    static List<int[]> zeroList;

    static void input() {

        N = scan.nextInt();
        M = scan.nextInt();
        graph = new int[N][M];
        zeroList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                graph[i][j] = scan.nextInt();
                if (graph[i][j] == 0) zeroList.add(new int[] {i, j});
            }
        }
    }

    static void bfs() {

        boolean[][] visit = new boolean[N][M];
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (graph[i][j] != 0){
                    visit[i][j] = true;
                    if (graph[i][j] == 2) queue.add(new int[] {i, j});
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int ny = cur[0] + dy[i];
                int nx = cur[1] + dx[i];
                if (ny < 0 || nx < 0 || ny == N || nx == M) continue;
                if (visit[ny][nx]) continue;
                visit[ny][nx] = true;
                queue.add(new int[]{ny, nx});
            }
        }

        int blankCnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) if (graph[i][j] == 0 && !visit[i][j]) blankCnt++;
        }

        cnt = Math.max(blankCnt, cnt);
    }

    static void pro() {
        for (int i = 0; i < zeroList.size(); i++) {
            int[] a = zeroList.get(i);
            graph[a[0]][a[1]] = 1;
            for (int j = i + 1; j < zeroList.size(); j++) {
                int[] b = zeroList.get(j);
                graph[b[0]][b[1]] = 1;
                for (int k = j + 1; k < zeroList.size(); k++) {
                    int[] c = zeroList.get(k);
                    graph[c[0]][c[1]] = 1;
                    bfs();
                    graph[c[0]][c[1]] = 0;
                }
                graph[b[0]][b[1]] = 0;
            }
            graph[a[0]][a[1]] = 0;
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
