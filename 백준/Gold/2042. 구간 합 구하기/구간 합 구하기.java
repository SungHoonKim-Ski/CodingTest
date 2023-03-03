import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        long[] sumSegTree = new long[2 * n];

        for (int i = 0; i < n; i++) {
            long input = Long.parseLong(br.readLine());
            sumSegTree[i + n] = input;
        }

        for (int i = n-1; i != 0; i--) {
            sumSegTree[i] = sumSegTree[i << 1] + sumSegTree[i << 1 | 1];
        }

        for (int i = 0; i < m + k; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            if (st.nextToken().charAt(0) == '1') {
                int idx = Integer.parseInt(st.nextToken()) - 1;
                long num = Long.parseLong(st.nextToken());
                sumSegTree[idx += n] = num;

                while ((idx >>= 1) > 0) {
                    sumSegTree[idx] = sumSegTree[idx << 1] + sumSegTree[idx << 1 | 1];
                }
            }else {
                int l = Integer.parseInt(st.nextToken()) - 1;
                int r = Integer.parseInt(st.nextToken());

                long sum = 0;

                for (l += n, r += n; l != r; l >>= 1, r >>= 1) {
                    if ((l & 1) == 1) {
                        sum += sumSegTree[l++];
                    }
                    if ((r & 1) == 1) {
                        sum += sumSegTree[--r];
                    }
                }
                System.out.println(sum);
            }
        }
    }
}