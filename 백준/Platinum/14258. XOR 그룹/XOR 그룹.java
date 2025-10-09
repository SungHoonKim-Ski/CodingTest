import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n, m;
    static int[][] map;
    static int[] parent, value;
    static PriorityQueue<int[]> pq;

    static void input() throws IOException{
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        pq = new PriorityQueue<>((o1, o2) -> o2[2] - o1[2]);
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                pq.add(new int[] {i, j, map[i][j]});
            }
        }
    }

    static void pro() {
        parent = new int[n * m + 1];
        value = new int[n * m + 1];
        for (int i = 0; i < n * m; i++) {
            parent[i] = i;
            value[i] = map[i / m][i % m];
        }

        final int[] dx = {0, 1, 0, -1};
        final int[] dy = {1, 0, -1, 0};
        boolean[] available = new boolean[n * m + 1];

        long sum = 0, ans = 0;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int idx = cur[0] * m + cur[1];
            available[idx] = true;

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (!available[nx * m + ny]) continue;

                int nIdx = nx * m + ny;
                if (find(idx) == find(nIdx)) continue;

                sum -= value[find(nIdx)];
                union(idx, nIdx);
            }

            sum += value[find(idx)];
            ans = Math.max(ans, sum);
        }

        System.out.println(ans);
    }

    static void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);

        if (pa == pb) return;

        parent[pb] = pa;
        value[pa] ^= value[pb];
    }

    static int find(int a) {
        if (parent[a] == a) return a;
        else return parent[a] = find(parent[a]);
    }


    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}