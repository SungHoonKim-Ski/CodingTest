import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main {

    static long[] maxSegTree;
    static long[] minSegTree;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        minSegTree = new long[2 * n];
        maxSegTree = new long[2 * n];

        for (int i = 0; i < n; i++) {
            long input = Long.parseLong(br.readLine());
            minSegTree[i + n] = input;
            maxSegTree[i + n] = input;
        }

        for (int i = n-1; i != 0; i--) {
            minSegTree[i] = Math.min(minSegTree[i << 1], minSegTree[i << 1 | 1]);
            maxSegTree[i] = Math.max(maxSegTree[i << 1], maxSegTree[i << 1 | 1]);
        }

        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int l = Integer.parseInt(st.nextToken()) - 1;
            int r = Integer.parseInt(st.nextToken());

            long max = -1;
            long min = Long.MAX_VALUE;

            for (l += n, r += n; l != r; l >>= 1, r >>= 1) {
                if ((l & 1) == 1) {
                    max = Math.max(max, maxSegTree[l]);
                    min = Math.min(min, minSegTree[l++]);
                }
                if ((r & 1) == 1) {
                    max = Math.max(max, maxSegTree[--r]);
                    min = Math.min(min, minSegTree[r]);
                }
            }
            bw.append(String.valueOf(min)).append(' ').append(String.valueOf(max)).append('\n');
        }
        bw.flush();
        bw.close();
        br.close();
    }
}