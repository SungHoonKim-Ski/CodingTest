import java.io.*;
import java.util.*;

public class Main {

    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int n, m, k;
    static int[][] map, building;

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            char[] str = br.readLine().toCharArray();
            for (int j = 1; j <= m; j++) {
                map[i][j] = str[j - 1] - '0';
            }
        }
    }

    static void pro() throws IOException {
        calBuilding();

        int[][] prefixSum = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                prefixSum[i][j] = prefixSum[i][j - 1] + building[i][j];
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                prefixSum[j][i] += prefixSum[j - 1][i];
            }
        }

        k = Integer.parseInt(br.readLine());
        while (k-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int res = 0;
            if (x1 == 1 && y1 == 1) {
                res += prefixSum[x2][y2];
            }
            else if (x1 == 1) {
                res += prefixSum[x2][y2] - prefixSum[x2][y1 - 1];
            }
            else if (y1 == 1) {
                res += prefixSum[x2][y2] - prefixSum[x1 - 1][y2];
            }
            else {
                res += prefixSum[x2][y2]
                        - prefixSum[x2][y1 - 1]
                        - prefixSum[x1 - 1][y2]
                        + prefixSum[x1 - 1][y1 - 1];
            }

            if (res == 0) sb.append("Yes");
            else sb.append("No ").append(res);

            sb.append('\n');
        }
        System.out.println(sb);
    }

    static void calBuilding() {
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        building = new int[n + 2][m + 2];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(building[i], 1);
        }

        Queue<int[]> que = new ArrayDeque<>();
        for (int i = 0; i < n + 2; i++) {
            que.add(new int[] {i, 0});
            building[i][0] = 0;
            que.add(new int[] {i, m + 1});
            building[i][m + 1] = 0;
        }

        for (int i = 0; i < m + 2; i++) {
            if (building[0][i] != 0) {
                que.add(new int[] {0, i});
                building[0][i] = 0;
            }
            if (building[n + 1][i] != 0) {
                que.add(new int[] {n + 1, i});
                building[n + 1][i] = 0;
            }
        }

        while (!que.isEmpty()) {
            int[] cur = que.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx < 0 || ny < 0 || nx > n || ny > m) continue;
                if (building[nx][ny] == 0) continue;
                if (map[nx][ny] == 1) continue;

                building[nx][ny] = 0;
                que.add(new int[] {nx, ny});
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}