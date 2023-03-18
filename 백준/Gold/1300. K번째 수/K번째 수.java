import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, K;

    static void input() {
        N = scan.nextInt();
        K = scan.nextInt();
    }

    static boolean determination(long H) {

        long cnt = 0;
        for (int i = 1; i <= N; i++) {
            cnt += Math.min(N, H / i);
        }
        return cnt >= K;
    }

    static void pro() {
        long L = 1, R = Math.min((long) N * N, 1000000000), ans = 1;
        while (L <= R) {
            long mid = (L + R) / 2;
            if (determination(mid)) {
                ans = mid;
                R = mid - 1;
            }else {
                L = mid + 1;
            }
        }
        System.out.println(ans);
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