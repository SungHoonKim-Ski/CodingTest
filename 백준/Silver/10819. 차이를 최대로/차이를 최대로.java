import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, max;
    static int[] arr;
    static boolean[] visit;

    static void input() throws Exception {
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }

    public static void pro() {
        visit = new boolean[n];
        recur(0, new int[n]);
        System.out.println(max);
    }

    static void recur(int depth, int[] used) {
        if (depth == n) {
            int res = 0;
            for (int i = 1; i < n; i++) {
                res += Math.abs(used[i - 1] - used[i]);
            }
            max = Math.max(res, max);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visit[i]) continue;
            used[depth] = arr[i];
            visit[i] = true;
            recur(depth + 1, used);
            visit[i] = false;
        }
    }

    public static void main(String[] args) throws Exception{
        input();
        pro();
    }
}