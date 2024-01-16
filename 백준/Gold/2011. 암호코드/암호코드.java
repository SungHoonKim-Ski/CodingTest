import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int[] dp;
    static char[] str;
    static int n, MOD = 1000000;;

    static void input() {

        str = scan.nextLine().toCharArray();
        n = str.length;
        dp = new int[n + 1];
    }

    static void pro() {

        if (str[0] != '0') dp[0]++;

        for (int i = 1; i < n; i++) {

            if (str[i] != '0') dp[i] = dp[i - 1];

            if (check(str[i - 1], str[i])) {
                if (i >= 2) dp[i] += dp[i - 2];
                else dp[i] += 1;
                dp[i] %= MOD;
            }
        }
        System.out.println(dp[n - 1]);
    }

    static boolean check(char a, char b) {
        if (a == '0') return false;
        if (a == '1') return true;
        if (a >= '3') return false;
        return b <= '6';
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