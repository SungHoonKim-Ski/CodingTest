import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int m, n;
    static boolean[][] Graph;
    static boolean[][] Visit;
    static int[][] ResArr;
    static int[] dy = new int[] {0, 1, 0, -1};
    static int[] dx = new int[] {1, 0, -1, 0};
    static int[] start;

    static void input(){

        m = scan.nextInt();
        n =  scan.nextInt();

        Visit = new boolean[m][n];
        Graph = new boolean[m][n];
        ResArr = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int input = scan.nextInt();
                if (input != 0) {
                    Graph[i][j] = true;
                    if (input == 2) {
                        start = new int[] {i, j, 0};
                    }
                }
            }
        }
    }

    static void pro() {
        
        bfs();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (ResArr[i][j] != 0) sb.append(ResArr[i][j]).append(' ');
                else {
                    if (i == start[0] && j == start[1]) {
                        sb.append(0).append(' ');
                        continue;
                    }
                    if (!Graph[i][j]) sb.append(0).append(' ');
                    else sb.append(-1).append(' ');
                }
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    static void bfs() {

        Queue<int[]> que = new LinkedList<>();
        que.add(start);
        Visit[start[0]][start[1]] = true;
        
        while (!que.isEmpty()) {
            int[] cur = que.poll();
            ResArr[cur[0]][cur[1]] = cur[2];

            for (int i = 0; i < 4; i++) {
                int ny = cur[0] + dy[i];
                int nx = cur[1] + dx[i];
                if (ny == -1 || nx == -1 || ny == m || nx == n) continue;
                if (!Graph[ny][nx]) continue;
                if (Visit[ny][nx]) continue;
                Visit[ny][nx] = true;
                que.add(new int[] {ny, nx, cur[2] + 1});
            }
        }
    }

    public static void main(String[] args) throws IOException {
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