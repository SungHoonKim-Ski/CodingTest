import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int k;
    static long min, max;
    static char[] str;
    static boolean[] visit;

    static void input() throws Exception {
        k = Integer.parseInt(br.readLine());

        char[] tmp = br.readLine().toCharArray();
        str = new char[k];
        for (int i = 0; i < k; i++) {
            str[i] = tmp[i * 2];
        }
    }

    public static void pro() {
        min = Long.MAX_VALUE;
        max = -1;

        visit = new boolean[10];
        for (int i = 0; i < 10; i++) {
            visit[i] = true;
            int[] arr = new int[k + 1];
            arr[0] = i;
            dfs(1, arr);
            visit[i] = false;
        }

        boolean minZero = false, maxZero = false;
        if ((int)(min / Math.pow(10, k)) == 0) minZero = true;
        if ((int)(max / Math.pow(10, k)) == 0) maxZero = true;

        if (maxZero) sb.append(0);
        sb.append(max).append('\n');

        if (minZero) sb.append(0);
        sb.append(min);

        System.out.println(sb);
    }

    static void dfs(int depth, int[] arr) {
        if (depth == k + 1) {
            long res = connect(arr);
            min = Math.min(min, res);
            max = Math.max(max, res);
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (visit[i]) continue;
            if (str[depth - 1] == '<') {
                if (arr[depth - 1] > i) continue;
            } else {
                if (arr[depth - 1] < i) continue;
            }
            visit[i] = true;
            arr[depth] = (char)i;
            dfs(depth + 1, arr);
            visit[i] = false;
        }
    }

    static long connect(int[] arr) {
        long res = 0;
        for (int a : arr) {
            res *= 10;
            res += a;
        }
        return res;
    }

    public static void main(String[] args) throws Exception{
        input();
        pro();
    }
}