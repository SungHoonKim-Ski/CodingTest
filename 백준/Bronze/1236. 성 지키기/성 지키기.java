import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {


    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static char[][] inputChar;
    static int N, M;

    static void input() throws IOException {
        N = scan.nextInt();
        M = scan.nextInt();
        inputChar = new char[N][];
        for (int i = 0; i < N; i++) inputChar[i] = scan.nextLine().toCharArray();
    }

    static void pro() {

        boolean[] rowVisit = new boolean[N];
        boolean[] colVisit = new boolean[M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (inputChar[i][j] == 'X') {
                    rowVisit[i] = true;
                    colVisit[j] = true;
                }
            }
        }

        int rowCnt = N, colCnt = M;
        for (int i = 0; i < N; i++) if (rowVisit[i]) rowCnt--;
        for (int i = 0; i < M; i++) if (colVisit[i]) colCnt--;

        System.out.println(Math.max(rowCnt, colCnt));


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