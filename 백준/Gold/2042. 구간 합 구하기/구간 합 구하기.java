import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static final int LENGTH = 1 << 20;
    static final int SIZE = 1 << 21;

    static int n, m, k;
    static long[] arr, tree;

    static void input() throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }
    }

    public static void pro() throws IOException {
        makeTree();
        int query = m + k;

        while (query-- > 0) {
            st = new StringTokenizer(br.readLine());

            int cmd = Integer.parseInt(st.nextToken());
            if (cmd == 1) {
                int a = Integer.parseInt(st.nextToken());
                long b = Long.parseLong(st.nextToken());
                update(a - 1, b);
            } else {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                sb.append(
                    get(1, 0, LENGTH - 1, a - 1, b - 1)
                ).append('\n');
            }
        }
        System.out.println(sb);
    }

    static void update(int idx, long num) {
        tree[LENGTH + idx] = num;

        int change = (LENGTH + idx) / 2;
        while (change != 0) {
            tree[change] = tree[change * 2] + tree[change * 2 + 1];
            change /= 2;
        }
    }

    static long get(int idx, int s, int e, int ts, int te) {
        if (s > te || e < ts) return 0;
        if (ts <= s && e <= te) return tree[idx];

        int mid = (s + e) / 2;
        long l = get(idx * 2, s, mid, ts, te);
        long r = get(idx * 2 + 1, mid + 1, e, ts, te);

        return l + r;
    }

    static void makeTree() {
        tree = new long[SIZE];

        for (int i = 0; i < n; i++) {
            tree[LENGTH + i] = arr[i];
        }

        for (int i = LENGTH - 1; i > 0; i--) {
            tree[i] = tree[i * 2] + tree[i * 2 + 1];
        }
    }

    public static void main(String[] args) throws Exception{
        input();
        pro();
    }
}