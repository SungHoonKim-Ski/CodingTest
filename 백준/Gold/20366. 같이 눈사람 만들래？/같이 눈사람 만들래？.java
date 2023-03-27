import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, v1, v2, v3, v4;
    static int best_sum = Integer.MAX_VALUE;
    static int[] A;

    static void input() {
        N = scan.nextInt();
        A = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = scan.nextInt();
        }
    }
    static void func(int idx1, int idx2) {
        int L = 1, R = N;
        int cur = A[idx1] + A[idx2];
        while (L < R) {
            if (L == idx1 || L == idx2) {
                L++;
                continue;
            }
            if (R == idx1 || R == idx2) {
                R--;
                continue;
            }

            int sum = A[L] + A[R] - cur;
            if (Math.abs(sum) < best_sum){
                best_sum = Math.abs(sum);
            }
            if (A[L] + A[R] > cur) R--;
            else L++;
        }
    }
    static void pro() {

        Arrays.sort(A, 1, N + 1);
        for (int i = 1; i < N; i++) {
            for (int j = i + 1; j <= N; j++) {
                func(i, j);
            }
        }

        System.out.println(best_sum);
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