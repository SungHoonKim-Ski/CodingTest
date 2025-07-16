import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static final int LENGTH = 1 << 20;
    static final int SIZE = 1 << 21;

    static int n, idx = 1;
    static HashMap<Integer, Integer> idxMap;

    static int[] tree;

    static void input() throws Exception {
        n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        idxMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            idxMap.put(Integer.parseInt(st.nextToken()), idx++);
        }
    }

    public static void pro() throws IOException {
        tree = new int[SIZE];

        long sum = 0;
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            int idx = idxMap.get(Integer.parseInt(st.nextToken()));

            sum += get(1, 0, LENGTH - 1, idx + 1, n);
            update(idx);
        }

        System.out.println(sum);
    }

    static void update(int idx) {
        idx += LENGTH;
        tree[idx] = 1;

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

    public static void main(String[] args) throws Exception{
        input();
        pro();
    }
}