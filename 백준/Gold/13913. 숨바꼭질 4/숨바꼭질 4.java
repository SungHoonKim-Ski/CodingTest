import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static final int MAX = 100_000;

    static int[] dist, prev;
    static int n, k;

    static void input() throws Exception {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
    }

    public static void pro() {
        dist = new int[MAX + 1];
        prev = new int[MAX + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[n] = 0;
        Queue<int[]> que = new ArrayDeque<>();
        que.add(new int[] {n, 0});

        while (!que.isEmpty()) {
            int[] cur = que.poll();
            if (cur[0] == k) break;

            int next = cur[0] - 1;
            if (next >= 0 && dist[next] == Integer.MAX_VALUE) {
                dist[next] = cur[1] + 1;
                prev[next] = cur[0];
                que.add(new int[] {next, dist[next]});
            }

            next = cur[0] + 1;
            if (next <= MAX && dist[next] == Integer.MAX_VALUE) {
                dist[next] = cur[1] + 1;
                prev[next] = cur[0];
                que.add(new int[] {next, dist[next]});
            }

            next = cur[0] * 2;
            if (next <= MAX && dist[next] == Integer.MAX_VALUE) {
                dist[next] = cur[1] + 1;
                prev[next] = cur[0];
                que.add(new int[] {next, dist[next]});
            }
        }

        sb.append(dist[k]).append('\n');

        ArrayList<Integer> prevList = new ArrayList<>();
        prevList.add(k);
        while(k != n) {
            k = prev[k];
            prevList.add(k);
        }

        for (int i = prevList.size() - 1; i >= 0; i--) {
            sb.append(prevList.get(i)).append(' ');
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception{
        input();
        pro();
    }
}