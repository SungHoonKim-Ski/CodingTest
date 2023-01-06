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
        int n = Integer.parseInt(st.nextToken());
        long m = Long.parseLong(st.nextToken());

        long[] arrN = new long[n];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            arrN[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arrN);

        long min = 0;
        long max = arrN[n-1];
        long res = 0;

        while (min <= max) {

            long mid = (min + max) / 2;
            long count = 0;
            for (int i=0; i<n; i++) {
                long tmp = arrN[i] - mid;
                if (tmp > 0) {
                    count += tmp;
                }
            }

            if (count >= m) {
                min = mid + 1;
                res = mid;
            }else {
                max = mid - 1;
            }
        }
        System.out.println(res);
    }
}