import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Stack;
import java.util.StringTokenizer;

class Main {


    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static char[][] inputCharArr;

    static void input() throws IOException {

        inputCharArr = new char[5][15];
        for (int i = 0; i < 5; i++) {
            char[] inputChar = scan.nextLine().toCharArray();
            for (int j = 0; j < inputChar.length; j++) {
                inputCharArr[i][j] = inputChar[j];
            }
        }
    }

    static void pro() {

        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 5; j++) {
                if (inputCharArr[j][i] != '\u0000')
                    sb.append(inputCharArr[j][i]);
            }
        }
        System.out.println(sb);
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