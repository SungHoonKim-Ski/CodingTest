import java.io.*;
import java.util.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, m;

    static void input() throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
    }

    public static void pro() {
        backTrack(0, 1,  new int[m]);
        System.out.println(sb);
    }

    static void backTrack(int depth, int index, int[] elements) {
        if (depth == m) {
            for (int element: elements) {
                sb.append(element).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = 1; i <= n; i++) {
            elements[depth] = i;
            backTrack(depth + 1, i, elements);
        }
    }

    public static void main(String[] args) throws Exception{
        input();
        pro();
    }
}