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
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] arrK = new int[k];
        for (int i=0; i<k; i++) {
            arrK[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arrK);

        long min = 0;
        long max = arrK[k-1];
        long res = 0;

        while (min <= max) {
            long mid = (min + max) / 2;
            if (mid < 2) {
                res = 1;
                break;
            }
            int count = 0;
            for (int i=0; i<k; i++) {
                count += arrK[i] / mid;
            }

            if (count >= n) {
                min = mid + 1;
                res = mid;
            }else {
                max = mid - 1;
            }
        }
        System.out.println(res);
    }
}