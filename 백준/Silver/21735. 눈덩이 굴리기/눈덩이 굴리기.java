import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int n, m, max = -1;
    static int[] arr;

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void pro() {
        recur(0, 0, 1);

        System.out.println(max);
    }

    static void recur(int depth, int loc, int size) {
        max = Math.max(max, size);
        if (loc > n || depth == m) {
            return;
        }

        if (loc + 1 <= n) {
            recur(depth + 1, loc + 1, size + arr[loc + 1]);
        }
        if (loc + 2 <= n) {
            recur(depth + 1, loc + 2, size / 2 + arr[loc + 2]);
        }
    }


    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}