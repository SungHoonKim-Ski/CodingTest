import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int N, blueCnt = 0, whiteCnt = 0;
    static boolean[][] graph;

    static void input() {
        N = scan.nextInt();
        graph = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                graph[i][j] = scan.nextInt() == 1;
            }
        }
    }

    static void pro() { // 1-true : blue, 0-false : white,
        divide(0, 0, N, N);
        System.out.println(whiteCnt);
        System.out.println(blueCnt);
    }

    static void divide(int startY, int startX, int endY, int endX) {

        boolean color = graph[startY][startX];
        for (int i = startY; i < endY; i++) {
            for (int j = startX; j < endX; j++) {
                if (graph[i][j] != color) {
                    divide(startY, startX, (startY+ endY) / 2, (startX + endX) / 2);
                    divide(startY, (startX + endX) / 2, (startY+ endY)/2, endX);
                    divide((startY + endY) / 2, startX, endY, (startX + endX) / 2);
                    divide((startY + endY) / 2, (startX + endX) / 2, endY, endX);
                    return;
                }
            }
        }
        if (color) blueCnt++;
        else whiteCnt++;
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