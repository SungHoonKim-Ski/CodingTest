import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static final int MAX = 500_000;

    static int n, q, log = 1;
    static int[] arr;
    static int[][] sparse;


    static void input() throws IOException{
        n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        arr = new int[n + 1];
        for (int i = 1; i <= n; i++) arr[i] = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(br.readLine());
    }

    static void pro() throws IOException {
        while ((1 << log) <= MAX) {
            log++;
        }
        sparse = new int[log + 1][n + 1];

        for (int i = 1; i <= n; i++) sparse[0][i] = arr[i];

        for (int i = 1; i <= log; i++) {
            for (int j = 1; j <= n; j++) {
                int next = sparse[i - 1][j];
                sparse[i][j] = sparse[i - 1][next];
            }
        }

        while (q-- > 0) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            sb.append(query(x,y)).append('\n');
        }
        System.out.println(sb);
    }

    static int query(int x, int y) {
        for (int i = 0; i <= log; i++) {
            if (((x >> i) & 1) != 0) {
                y = sparse[i][y];
            }
        }
        return y;
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}