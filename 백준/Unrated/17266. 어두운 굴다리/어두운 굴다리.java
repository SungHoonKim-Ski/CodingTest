import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static int[] X;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        X = new int[M + 1];
        for (int i = 1; i <= M; i++) {
            X[i] = scan.nextInt();
        }
    }

    static boolean determination(int H) {

        int last = 0;
        for (int i = 1; i <= M; i++) {
            if (X[i] - H <= last) {
                last = X[i] + H;
            }else return false;
        }
        return last >= N;
    }

    static void pro() {
        int L = 0, R = N, ans = 0;
        while (L <= R) {
            int mid = (L + R) / 2;
            if (determination(mid)) {
                R = mid - 1;
                ans = mid;
            } else {
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