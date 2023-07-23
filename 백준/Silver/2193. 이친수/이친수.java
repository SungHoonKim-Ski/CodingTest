import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, MAX_Size = 90;
    static long[] FibArr = new long[MAX_Size + 1];

    static void init() {
        FibArr[1] = FibArr[2] = 1;

        for (int i = 3; i <= MAX_Size; i++) {
            FibArr[i] = FibArr[i - 1] + FibArr[i - 2];
        }

    }
    static void input()
    {
        N = scan.nextInt();
    }

    static void pro() {
        System.out.println(FibArr[N]);
    }

    public static void main(String[] args){
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