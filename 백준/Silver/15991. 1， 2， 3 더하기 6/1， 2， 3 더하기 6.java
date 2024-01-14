import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static long[] dp;
    static int n;
    static final int MOD_VAL = 1_000_000_009;

    static void init() {
        dp = new long[100_000 + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 4; i < dp.length; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % MOD_VAL;
        }
    }
    static void input() {
        n = scan.nextInt();
    }

    static void pro() {

        long count = 0;
        for (int mid = 0; mid <= 3; mid++) {
            if (n - mid < 0) break;
            if ((n - mid) % 2 == 0) {
                count += dp[(n - mid) / 2];
                count %= MOD_VAL;
            }
        }
        sb.append(count).append('\n');
    }

    public static void main(String[] args) {

        init();
        int tc = Integer.parseInt(scan.nextLine());
        while (tc -- > 0) {
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