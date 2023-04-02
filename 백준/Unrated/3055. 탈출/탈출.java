import java.io.*;
import java.util.*;


public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int R, C;
    static char[][] graph;
    static boolean[][] visit;

    static int[] dy = new int[] {0, 1, 0, -1};
    static int[] dx = new int[] {1, 0, -1, 0};
    static Queue<int[]> que;
    static int[] locS;

    static void input() {

        R = scan.nextInt();
        C = scan.nextInt();

        visit = new boolean[R][C];
        graph = new char[R][C];

        for (int i = 0; i < R; i++) {
            graph[i] = scan.next().toCharArray();
        }
    }

    static int bfs() {

        while (!que.isEmpty()) {
            int[] curLoc = que.poll();
            for (int i = 0; i < 4; i++) {
                int ny = curLoc[0] + dy[i];
                int nx = curLoc[1] + dx[i];
                if (ny < 0 || nx < 0 || ny >= R || nx >= C) continue;
                if (curLoc[2] == -1) { // water
                    if (graph[ny][nx] == '.' || graph[ny][nx] == 'S') {
                        graph[ny][nx] = '*';
                        que.add(new int[] {ny, nx, -1});
                    }
                }else {
                    if (visit[ny][nx]) continue;
                    if (graph[ny][nx] == '*') continue;
                    if (graph[ny][nx] == 'X') continue;
                    if (graph[ny][nx] == 'D') {
                        return curLoc[2] + 1;
                    }
                    visit[ny][nx] = true;
                    que.add(new int[] {ny, nx, curLoc[2] + 1});
                }
            }
        }
        return 101;
    }

    static void pro() {

        que = new LinkedList<>();

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (graph[i][j] == 'X') continue;
                if (graph[i][j] == '.') continue;
                if (graph[i][j] == '*') {
                    que.add(new int[] {i, j, -1}); // y, x, move
                    continue;
                }
                if (graph[i][j] == 'S') {
                    visit[i][j] = true;
                    locS = new int[] {i, j, 0}; // y, x, move
                }
            }
        }
        que.add(locS);

        int res = bfs();
        if (res == 101) sb.append("KAKTUS");
        else sb.append(res);

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
