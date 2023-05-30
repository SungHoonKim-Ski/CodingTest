import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Stack;
import java.util.StringTokenizer;

class Main {


    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int A, B;
    static int max = 45000 * 45000;


    static void input() throws IOException {
        A = scan.nextInt();
        B = scan.nextInt();

    }

    static void pro() {

        int max = Math.max(A, B);
        int c = 1;
        for (int i = max; i > 0; i--) {
            if (A % i == 0 && B % i == 0) {
                c = i;
                break;
            }
        }
        sb.append(A * B / c).append('\n');
    }

    public static void main(String[] args) throws Exception {

        int T = scan.nextInt();
        while (T-- > 0) {
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