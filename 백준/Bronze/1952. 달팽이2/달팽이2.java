import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M, VisitCnt, turnCnt = 0;

    static int[][] plane;
    static boolean[][] visit;
    static void input()
    {
        StringTokenizer st = new StringTokenizer(scan.nextLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        VisitCnt = N * M - 1;

        plane = new int[N][M];
        visit = new boolean[N][M];
    }

    static void pro() {

        int curY = 0;
        int curX = 0;
        visit[curY][curX] = true;

        int[] dy = {0, 1, 0, -1};
        int[] dx = {1, 0, -1, 0};

        while (VisitCnt != 0) {
            for (int i = 0; i < 4;) {
                int ny = curY + dy[i];
                int nx = curX + dx[i];

                if(nx >= 0 && ny >= 0 && nx < M && ny < N && !visit[ny][nx]) {
                    VisitCnt--;
                    if (VisitCnt == 0)  break;
                    visit[ny][nx] = true;
                    curY = ny;
                    curX = nx;
                }else {
                    turnCnt++;
                    i++;
                }
            }
        }
        System.out.println(turnCnt);
    }



    public static void main(String[] args){

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