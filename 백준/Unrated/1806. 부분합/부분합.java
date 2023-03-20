import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, S;
    static int[] A;

    static void input() {
        N = scan.nextInt();
        S = scan.nextInt();
        A = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = scan.nextInt();
        }
    }

    static void pro() {

        if (A[1] == S) {
            System.out.println(1);
            return;
        }

        int R = 0, sum = 0, cnt = N + 1;
        for (int L = 1; L <= N; L++) {

            sum -= A[L - 1];
            // L - 1 을 구간에서 제외하기
            while (sum < S && ++R <= N) {
                sum += A[R];
            }
            // R 을 옮길 수 있을 때 까지 옮기기

            cnt = Math.min(R - L + 1, cnt);
            // [L ... R] 의 합, 즉 sum이 조건을 만족하면 정답 갱신하기
        }
        if (cnt == N + 1) cnt = 0;
        System.out.println(cnt);
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