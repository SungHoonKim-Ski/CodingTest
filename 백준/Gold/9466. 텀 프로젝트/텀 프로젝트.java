import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n;
    static int[] pointer, indeg;

    static void input() throws Exception {
        n = Integer.parseInt(br.readLine());
        pointer = new int[n + 1];
        indeg = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            pointer[i] = Integer.parseInt(st.nextToken());
            indeg[pointer[i]]++;
        }
    }

    public static void pro() {
        Queue<Integer> que = new ArrayDeque<>();

        for (int i = 1; i <= n; i++) {
            if (indeg[i] != 0) continue;
            que.add(i);
        }

        int count = 0;

        while (!que.isEmpty()) {
            int cur = que.poll();

            count++;
            int next = pointer[cur];
            indeg[next]--;

            if (indeg[next] == 0) {
                que.add(next);
            }
        }

        sb.append(count).append('\n');
    }

    public static void main(String[] args) throws Exception {
        int tc = Integer.parseInt(br.readLine());

        while (tc -- > 0) {
            input();
            pro();
        }
        System.out.println(sb);
    }
}