import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;

    static void input()
    {
//        StringTokenizer st = new StringTokenizer(scan.nextLine());
//        N = scan.nextInt();
        N = scan.nextInt();
    }

    static void pro() {

        while (N != 0) {
            sb.append(N % 2);
            N /= 2;
        }

        int res = 0;
        char[] c = sb.toString().toCharArray();
        for (int i = c.length - 1, j = 0; i >= 0; i--, j++) {
            res += (c[i] - '0') * Math.pow(2, j);
        }
        System.out.println(res);
    }



    public static void main(String[] args){

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