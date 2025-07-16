import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int[] maxTree, minTree;
    static int[] arr;
    static int n, m;
    static int LENGTH = 1 << 19;
    static int SIZE = 1 << 20;


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
            sb.append(getMin(1, 0, LENGTH - 1, a, b)).append(' ');
            sb.append(getMax(1, 0, LENGTH - 1, a, b)).append('\n');
        }
        System.out.println(sb);
    }

    static int getMax(int idx, int s, int e, int ts, int te) {
        if (ts > e || te < s) return 0;
        if (ts <= s && e <= te) return maxTree[idx];

        int mid = (s + e) / 2;
        int l = getMax(idx * 2, s, mid, ts, te);
        int r = getMax(idx * 2 + 1, mid + 1, e, ts, te);

        return Math.max(l, r);
    }

    static int getMin(int idx, int s, int e, int ts, int te) {
        if (ts > e || te < s) return Integer.MAX_VALUE;
        if (ts <= s && e <= te) return minTree[idx];

        int mid = (s + e) / 2;
        int l = getMin(idx * 2, s, mid, ts, te);
        int r = getMin(idx * 2 + 1, mid + 1, e, ts, te);

        return Math.min(l, r);
    }

    static void makeTree() {
        maxTree = new int[SIZE];
        minTree = new int[SIZE];
        Arrays.fill(minTree, Integer.MAX_VALUE);

        for (int i = 0; i < n; i++) {
            maxTree[LENGTH + i] = arr[i];
            minTree[LENGTH + i] = arr[i];
        }

        for (int i = LENGTH - 1; i > 0; i--) {
            maxTree[i] = Math.max(maxTree[i * 2], maxTree[i * 2 + 1]);
            minTree[i] = Math.min(minTree[i * 2], minTree[i * 2 + 1]);
        }
    }

    public static void main(String[] args) throws Exception{
        input();
        pro();
    }
}