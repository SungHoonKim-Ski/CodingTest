import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[] A;

    static void input() {
        N = scan.nextInt();
        A = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = scan.nextInt();
        }
    }

    static int bin_search(int[] A, int L, int R, int X) {

        int res = R + 1;
        while (L <= R) {
            int mid = (L + R) / 2;
            if (A[mid] <= X)
                L = mid + 1;
            else{
                R = mid - 1;
                res = R;
            }
        }
        return res;
    }

    static int lower_bound(int[] A, int L, int R, int X) {

        int res = R + 1;  
        while (L <= R) {
            int mid = (L + R) / 2;
            if (A[mid] >= X) {
                res = mid;
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return res;
    }
    static void pro() {

        Arrays.sort(A, 1, N + 1);

        int sum = Integer.MAX_VALUE;
        int v1 = 0, v2 = 0;

        for (int i = 1; i < N; i++) {
            int res = lower_bound(A, i + 1, N, -A[i]);

            if (i < res - 1 && Math.abs(A[i] + A[res - 1]) < sum) {
                sum = Math.abs(A[i] + A[res - 1]);
                v1 = A[i];
                v2 = A[res - 1];
            }

            if (res <= N && Math.abs(A[i] + A[res]) < sum) {
                sum = Math.abs(A[i] + A[res]);
                v1 = A[i];
                v2 = A[res];
            }
        }
        sb.append(v1).append(' ').append(v2);
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