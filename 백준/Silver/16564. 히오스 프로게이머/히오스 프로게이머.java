import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static BufferedReader br;
    static StringBuffer sb;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuffer();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long K = Integer.parseInt(st.nextToken());
        long[] X = new long[N];

        for (int i=0; i<N; i++) {
            long level = Integer.parseInt(br.readLine());
            X[i] = level;
        }

        Arrays.sort(X);
        long min = X[0];
        long max = min + K;
        long res = 0;

        while (min <= max) {
            long mid = (min + max) / 2;
            long sum = 0;

            for (int i=0; i<N; i++) {
                if (mid >= X[i]) {
                    sum += mid - X[i];
                }
            }
            if (sum <= K) {
                res = Math.max(res, mid);
                min = mid + 1;
            }else {
                max = mid - 1;
            }
        }
        System.out.println(res);
    }
}