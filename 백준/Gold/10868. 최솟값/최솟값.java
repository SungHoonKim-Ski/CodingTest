import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static final int LEN = 1 << 20;
    static final int SIZE = 1 << 21;

    static int n, m;
    static int[] tree, arr;

    static void input() throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
    }

    public static void pro() throws IOException {
        makeTree();

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            sb.append(get(1, 0, LEN - 1, a, b)).append('\n');
        }

        System.out.println(sb);
    }

    static int get(int idx, int s, int e, int ts, int te) {
        if (s > te || e < ts) return Integer.MAX_VALUE;
        if (ts <= s && e <= te) return tree[idx];

        int mid = (s + e) / 2;
        return Math.min(
                get(idx * 2, s, mid, ts, te)
                , get(idx * 2 + 1, mid + 1, e, ts, te)
        );


    }


    static void makeTree() {
        tree = new int[SIZE];
        Arrays.fill(tree, Integer.MAX_VALUE);

        for (int i = 0; i < n; i++) {
            tree[i + LEN] = arr[i];
        }

        for (int i = LEN - 1; i > 0; i--) {
            tree[i] = Math.min(tree[i * 2], tree[i * 2 + 1]);
        }
    }

    public static void main(String[] args) throws Exception{
        input();
        pro();
    }
}