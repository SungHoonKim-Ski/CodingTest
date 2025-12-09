import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int n, k, t, x, y, v, p;
    static int[][] graph;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        graph = new int[n + 1][4];

        st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());
        graph[0] = new int[] {x, y, v, 1};

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            p = Integer.parseInt(st.nextToken());

            graph[i] = new int[] {x, y, v, p};
        }

        boolean[] visit = new boolean[n + 1];
        ArrayList<Integer> resList = new ArrayList<>();
        Queue<int[]> que = new ArrayDeque<>();

        visit[0] = true;
        que.add(graph[0]);
        k *= k;

        while (!que.isEmpty()) {
            int[] cur = que.poll();

            int cx = cur[0];
            int cy = cur[1];
            int cv = cur[2];

            for (int i = 1; i <= n; i++) {
                if (visit[i]) continue;

                int nx = graph[i][0];
                int ny = graph[i][1];
                int nv = graph[i][2];
                int np = graph[i][3];

                int dist = Math.abs(cx - nx) * Math.abs(cx - nx) + Math.abs(cy - ny) * Math.abs(cy - ny);

                if (dist <= k) {
                    if (Math.abs(cv - nv) <= t) {
                        que.add(graph[i]);
                        visit[i] = true;
                        if (np == 1) resList.add(i);
                    }
                }
            }
        }

        if (resList.size() == 0) sb.append(0);
        else {
            Collections.sort(resList);

            for (int res : resList) {
                sb.append(res).append(' ');
            }
        }

        System.out.println(sb);
    }
}