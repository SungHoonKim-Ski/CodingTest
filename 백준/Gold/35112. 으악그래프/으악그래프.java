import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int[] parent;

    static int n, m;
    public static int find(int a) {
        if (a == parent[a]) return a;

        return parent[a] = find(parent[a]);
    }

    public static boolean union(int x, int y) {
        int xP = find(x);
        int yP = find(y);

        if (xP == yP) return false;

        parent[yP] = xP;
        return true;
    }


    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) parent[i] = i;

        int extra = 0;

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if (!union(x, y)) {
                extra++;
            }
        }

        System.out.println(extra <= 1 ? "Yes" : "No");
    }
}
