import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static final int LEN = 1 << 20;
    static final int SIZE = 1 << 21;

    static int n, m, k;
    static long[] tree, lazy, arr;

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

        int q = m + k;
        while (q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());

            if (cmd == 1) {
                int i = Integer.parseInt(st.nextToken()) - 1;
                int j = Integer.parseInt(st.nextToken()) - 1;
                long k = Long.parseLong(st.nextToken());
                update(1, 0, LEN - 1, i, j, k);
            } else {
                int a = Integer.parseInt(st.nextToken()) - 1;
                int b = Integer.parseInt(st.nextToken()) - 1;
                sb.append(get(1, 0, LEN - 1, a, b)).append('\n');
            }
        }

        System.out.println(sb);
    }

    static void updateLazy(int idx, int s, int e) {
        tree[idx] += (e - s + 1) * lazy[idx];
        if (s != e) {
            lazy[idx * 2] += lazy[idx];
            lazy[idx * 2 + 1] += lazy[idx];
        }
        lazy[idx] = 0;
    }

    static void update(int idx, int s, int e, int ts, int te, long add) {
        updateLazy(idx ,s ,e);

        if (s > te || e < ts) return;
        if (ts <= s && e <= te) {
            tree[idx] += (e - s + 1) * add;
            if (s != e) {
                lazy[idx * 2] += add;
                lazy[idx * 2 + 1] += add;
            }
            return;
        }

        int mid = (s + e) / 2;
        update(idx * 2, s, mid, ts, te, add);
        update(idx * 2 + 1, mid + 1, e, ts, te, add);

        tree[idx] = tree[idx * 2] + tree[idx * 2 + 1];
    }

    static long get(int idx, int s, int e, int ts, int te) {
        updateLazy(idx, s, e);

        if (s > te || e < ts) return 0;
        if (ts <= s && e <= te) return tree[idx];

        int mid = (s + e) / 2;
        return get(idx * 2, s, mid, ts, te)
                + get(idx * 2 + 1, mid + 1, e, ts, te);
    }


    static void makeTree() {
        tree = new long[SIZE];
        lazy = new long[SIZE];

        for (int i = 0; i < n; i++) {
            tree[i + LEN] = arr[i];
        }

        for (int i = LEN - 1; i > 0; i--) {
            tree[i] = tree[i * 2] + tree[i * 2 + 1];
        }
    }

    public static void main(String[] args) throws Exception{
        input();
        pro();
    }
}