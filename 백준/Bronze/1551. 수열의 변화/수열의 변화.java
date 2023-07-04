import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, K;
    static int[] inputArr;
    static void input(){

        N = scan.nextInt();
        K = scan.nextInt();
        inputArr = new int[N];
        StringTokenizer st = new StringTokenizer(scan.nextLine(), ",");

        for (int i = 0; i < N; i++) {
            inputArr[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void pro() {

        while (K-- > 0) {
            int[] nextArr = new int[inputArr.length - 1];
            for (int i = 0; i < nextArr.length; i++) {
                nextArr[i] = inputArr[i + 1] - inputArr[i];
            }
            inputArr = nextArr;
        }

        for (int i = 0; i < inputArr.length; i++) {
            sb.append(inputArr[i]).append(',');
        }
        sb.setLength(sb.length() - 1);
        System.out.println(sb);

    }

    public static void main(String[] args) throws IOException {
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