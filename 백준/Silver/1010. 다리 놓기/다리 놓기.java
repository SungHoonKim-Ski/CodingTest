import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int[][] dp;
    static int N, R;

    static void init() {
        dp = new int[31][31];

    }

    static int combination(int n, int r) {

        if (dp[n][r] != 0) return dp[n][r];
        if (n == r || r == 0) {
            dp[n][r] = 1;
            return 1;
        }

        dp[n][r] = combination(n-1, r-1) + combination(n-1, r);
        return dp[n][r];
    }

    static void input() {
        R = scan.nextInt();
        N = scan.nextInt();
    }

    static void pro() {
        System.out.println(combination(N, R));
    }

    public static void main(String[] args) {

        int tc = scan.nextInt();
        init();
        while (tc-- > 0) {
            input();
            pro();
        }
        System.out.println(sb);
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