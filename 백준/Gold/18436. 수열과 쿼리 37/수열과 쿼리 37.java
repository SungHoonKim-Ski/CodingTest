import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static final int LENGTH = 1 << 20;
    static final int SIZE = 1 << 21;

    static int n;
    static int[] arr, tree;

    static void input() throws Exception {
        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }

    public static void pro() throws IOException {
        makeTree();

        int m = Integer.parseInt(br.readLine());
        while (m -- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == 1) {
                update(b - 1, c);
            } else {
                int odd = get(1, 0, LENGTH - 1, b - 1, c - 1);
                if (a == 2) {
                    sb.append(c - b + 1 - odd);
                } else {
                    sb.append(odd);
                }
                sb.append('\n');
            }
        }
        System.out.println(sb);
    }

    static void update(int idx, int change) {
        idx += LENGTH;
        tree[idx] = change % 2 == 0 ? 0 : 1;

        idx /= 2;
        while (idx != 0) {
            tree[idx] = tree[idx * 2] + tree[idx * 2 + 1];
            idx /= 2;
        }
    }

    static int get(int idx, int s, int e, int ts, int te) {
        if (s > te || e < ts) return 0;
        if (ts <= s && e <= te) return tree[idx];

        int mid = (s + e) / 2;

        return get(idx * 2, s, mid, ts, te) + get(idx * 2 + 1, mid + 1, e, ts, te);
    }

    static void makeTree() {
        tree = new int[SIZE];

        for (int i = 0; i < n; i++) {
            tree[LENGTH + i] = arr[i] % 2 == 0 ? 0 : 1;
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