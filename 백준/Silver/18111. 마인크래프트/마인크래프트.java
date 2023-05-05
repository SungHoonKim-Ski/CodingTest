import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int N, M, B;
    static int[][] graph;
    static int min = 500, max = 0;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        B = scan.nextInt();
        graph = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                graph[i][j] = scan.nextInt();
                min = Math.min(min, graph[i][j]);
                max = Math.max(max, graph[i][j]);
            }
        }
    }

    static void pro() {

        int ansSeconds = Integer.MAX_VALUE;
        int ansHeight = -1;

        for (int i = min; i <= max; i++) {

            int seconds = 0;
            int inventory = B;

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    int dif = graph[j][k] - i;
                    if(dif > 0) {
                        seconds += dif * 2;
                        inventory += dif;
                    }else if(dif < 0){
                        seconds += Math.abs(dif);
                        inventory += dif;
                    }
                }
            }

            if (inventory < 0) continue;
            if (seconds <= ansSeconds) {
                ansSeconds = seconds;
                ansHeight = i;
            }
        }
        sb.append(ansSeconds).append(' ').append(ansHeight);
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