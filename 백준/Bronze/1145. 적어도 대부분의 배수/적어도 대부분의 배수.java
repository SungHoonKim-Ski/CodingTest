import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {


    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int[] inputArr;
    static int N = 5;

    static void input() throws IOException {
        inputArr = new int[N];
        for (int i = 0; i < N; i++) inputArr[i] = scan.nextInt();
    }

    static void pro(){

        int cnt;
        for (int i = 1; i < 1000000; i++) {
            cnt = 0;
            for (int j = 0; j < N; j++) {
                if (i < inputArr[j]) continue;
                if (i % inputArr[j] == 0) cnt++;
            }
            if (cnt > 2) {
                System.out.println(i);
                break;
            }
        }
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