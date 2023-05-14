import java.io.*;
import java.util.*;
import java.lang.Math;

public class Main {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N = 14, X, Y;
    static int[][] dp;

    static void init() {
        dp = new int[N + 1][N + 1];
        dp[0][1] = 1;
        for (int i = 1; i <= N; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= 14; i++) {
            for (int j = 1; j <= 14; j++) {
                for (int k = 1; k <= j; k++) {
                    dp[i][j] += dp[i - 1][k];
                }
            }
        }
    }
    static void input() {
        X = scan.nextInt();
        Y = scan.nextInt();
    }

    static void pro() {
        System.out.println(dp[X][Y]);
    }

    public static void main(String[] args) {

        int T = scan.nextInt();
        init();
        for (int i = 0; i < T; i++) {
            input();
            pro();
        }
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