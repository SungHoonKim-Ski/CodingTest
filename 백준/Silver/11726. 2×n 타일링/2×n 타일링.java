import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int[] dp;
    static int n;

    static void input() {
        n = Integer.parseInt(scan.nextLine());
        dp = new int[n + 1];

    }

    static void pro() {
        if (n == 1) {
            System.out.println(1);
            return;
        }
        dp[1] = 1;
        dp[2] = 2;
       for (int i = 3; i <= n; i++) {
           dp[i] = dp[i - 1] + dp[i - 2];
           dp[i] %= 10_007;
       }
        System.out.println(dp[n]);
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