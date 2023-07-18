import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, K;

    static int[] InputIntArr;

    static void input()
    {
//        StringTokenizer st = new StringTokenizer(scan.nextLine());
//        N = scan.nextInt();
        N = scan.nextInt();
        K = scan.nextInt();

        InputIntArr = new int[N];
        for (int i = 0; i < N; i++) InputIntArr[i] = scan.nextInt();
    }

    static void pro() {

        int max = Integer.MIN_VALUE;

        for (int i = 0; i <= N - K; i++) {
            int sum = 0;
            for (int j = i, cnt = 0; cnt < K; j++, cnt++) {
                sum += InputIntArr[j];
            }
            max = Math.max(sum, max);
        }
        System.out.println(max);
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