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
        N = scan.nextInt();
    }

    static void pro() {

        if (N == 1 || N == 2) System.out.println(1);
        else {
            BigInteger[] arr = new BigInteger[N];
            arr[0] = BigInteger.ONE;
            arr[1] = BigInteger.ONE;

            for (int i = 2; i < N; i++) arr[i] = arr[i - 1].add(arr[i - 2]);

            System.out.println(arr[N - 1]);
        }

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