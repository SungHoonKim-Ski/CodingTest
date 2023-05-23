import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {


    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static char[] inputArr;
    static int N;

    static void input() throws IOException {

        inputArr = scan.nextLine().toCharArray();
        N = inputArr.length;
    }

    static void pro(){

        boolean res = false;
        if (N != 1)
            for (int i = 0; i < N; i++) {
                if (mulNum(0, i) == mulNum(i + 1, N - 1)) {
                    res = true;
                    break;
                }
            }
        System.out.println(res ? "YES" : "NO");
    }

    static int mulNum(int start, int end) {

        int x = 1;
        for (int i = start; i <= end; i++) {
            x *= inputArr[i] - '0';
        }
        return x;
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