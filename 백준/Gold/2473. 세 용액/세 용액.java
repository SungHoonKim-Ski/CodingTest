import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, v1, v2, v3;
    static long best_sum = Long.MAX_VALUE;
    static int[] A;

    static void input() {
        N = scan.nextInt();
        A = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = scan.nextInt();
        }
    }
    static void func(int cur_idx) {
        int L = cur_idx + 1, R = N;
        int cur = A[cur_idx];
        while (L < R) {
            long sum = (long)A[L] + A[R] + cur;
            if (Math.abs(sum) < best_sum){
                best_sum = Math.abs(sum);
                v1 = cur;
                v2 = A[L];
                v3 = A[R];
            }
            if (A[L] + A[R] > -cur) R--;
            else L++;
        }
    }
    static void pro() {

        Arrays.sort(A, 1, N + 1);
        for (int i = 1; i <= N - 2; i++) {
            func(i);
        }

        sb.append(v1).append(' ').append(v2).append(' ').append(v3);

        System.out.println(sb);
    }

    public static void main(String[] args) {
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