import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.lang.Math;

class Main {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int D, W, H;

    static void input() throws IOException {

        D = scan.nextInt();
        H = scan.nextInt();
        W = scan.nextInt();
    }

    static void pro(){

        float resW, resH;
        float N = D;
        N /= Math.sqrt(H*H+W*W);
        resW = W * N;
        resH = H * N;
        System.out.println((int)resH + " " + (int)resW);
    }

    public static void main(String[] args) throws Exception {

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