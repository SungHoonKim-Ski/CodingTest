import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n;
    static int[] srr, brr;
    static long res = 1L << 60;

    static void input() throws IOException {
        n = Integer.parseInt(br.readLine());

        srr = new int[n];
        brr = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            srr[i] = Integer.parseInt(st.nextToken());
            brr[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void pro() {
        recur(0, 0, 1, 0);

        System.out.println(res);
    }

    static void recur(int depth, int use, long s, long b) {
        if (depth == n) {
            if (use == 0) return;
            res = Math.min(res, Math.abs(s - b));

            return;
        }

        recur(depth + 1, use, s, b);
        recur(depth + 1, use + 1, s * srr[depth], b + brr[depth]);
    }

    public static void main(String[] args) throws Exception {
        input();
        pro();
    }
}