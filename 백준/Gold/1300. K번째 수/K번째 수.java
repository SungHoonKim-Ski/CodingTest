import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static long n, k;
    static final int MAX_N = 100_000, MAX_K = 1_000_000_000;

    static void input() throws IOException {
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
    }

    static void pro() {
        long left = 1, right = MAX_K, res = 1;

        while (left <= right) {
            long mid = (left + right) / 2;
            if (check(mid)) {
                right = mid - 1;
                res = mid;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(res);
    }

    static boolean check(long mid) {
        long cnt = 0;
        for (long i = 1; i <= n; i++) {
            cnt += Math.min(n, mid / i);
        }
        return cnt >= k;
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}