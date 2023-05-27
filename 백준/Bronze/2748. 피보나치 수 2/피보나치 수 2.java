import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {


    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static long[] fibArr;
    static int size = 91, N;

    static void input() throws IOException {
        N = scan.nextInt();
    }

    static void init() {
        fibArr = new long[size];
        fibArr[1] = fibArr[2] = 1;
        for (int i = 3; i < size; i++) {
            fibArr[i] = fibArr[i - 1] + fibArr[i - 2];
        }
    }

    static void pro(){
        System.out.println(fibArr[N]);
    }

    public static void main(String[] args) throws Exception {

        init();
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