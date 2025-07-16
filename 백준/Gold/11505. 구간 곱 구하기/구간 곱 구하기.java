import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static final int LENGTH = 1 << 20;
    static final int SIZE = 1 << 21;
    static final long MOD = 1_000_000_007;

    static int n, m, k;
    static int[] arr;
    static long[] tree;

    static void input() throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
    }

    public static void pro() throws IOException {
        makeTree();

        int query = m + k;
        while (query -- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == 1) {
                update(b - 1, c);
            } else {
                sb.append(get(1, 0, LENGTH - 1, b - 1, c - 1)).append('\n');
            }
        }
        System.out.println(sb);
    }

    static void update(int idx ,int change) {
        idx += LENGTH;
        tree[idx] = change;

        idx /= 2;
        while (idx != 0) {
            tree[idx] = tree[idx * 2] * tree[idx * 2 + 1];
            tree[idx] %= MOD;
            idx /= 2;
        }
    }

    static long get(int idx, int s, int e, int ts, int te) {
        if (s > te || e < ts) return 1;
        if (ts <= s && e <= te) return tree[idx];

        int mid = (s + e) / 2;
        long l = get(idx * 2, s, mid, ts, te);
        long r = get(idx * 2 + 1, mid + 1, e, ts, te);

        return (l * r) % MOD;
    }

    static void makeTree() {
        tree = new long[SIZE];

        for (int i = 0; i < n; i++) {
            tree[LENGTH + i] = arr[i];
        }

        for (int i = LENGTH - 1; i > 0; i--) {
            tree[i] = tree[i * 2] * tree[i * 2 + 1];
            tree[i] %= MOD;
        }

    }

    public static void main(String[] args) throws Exception{
        input();
        pro();
    }
}