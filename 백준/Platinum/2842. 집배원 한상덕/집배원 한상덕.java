import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int[] start;
    static int n, k, mid;
    static char[][] map;
    static int[][] height;
    static ArrayList<Integer> heightList;

    static int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
    static int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};

    static boolean[][] visit;
    static boolean find;

    static void input() throws IOException {
        n = Integer.parseInt(br.readLine());

        map = new char[n][n];
        for (int i = 0; i < n; i++) {
            char[] str = br.readLine().toCharArray();
            for (int j = 0; j < n; j++) {
                map[i][j] = str[j];
                if (map[i][j] == 'P') start = new int[] {i, j};
                if (map[i][j] == 'K') k++;
            }
        }

        height = new int[n][n];
        heightList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                height[i][j] = Integer.parseInt(st.nextToken());
                heightList.add(height[i][j]);
            }
        }
    }

    static boolean check() {
        for (int minHeight : heightList) {
            int maxHeight = minHeight + mid;
            if (height[start[0]][start[1]] > maxHeight || height[start[0]][start[1]] < minHeight) continue;

            visit = new boolean[n][n];
            visit[start[0]][start[1]] = true;
            Queue<int[]> que = new ArrayDeque<>();
            int cnt = 0;

            que.add(new int[] {start[0], start[1]});

            while(!que.isEmpty()) {
                int[] cur = que.poll();
                int x = cur[0];
                int y = cur[1];

                if (cnt == k) return true;

                for (int i = 0; i < 8; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                    if (visit[nx][ny]) continue;
                    if (height[nx][ny] > maxHeight || height[nx][ny] < minHeight) continue;

                    if (map[nx][ny] == 'K') cnt++;

                    visit[nx][ny] = true;
                    que.add(new int[] {nx, ny});
                }
            }
        }

        return false;
    }

    static void pro() {
        Collections.sort(heightList);
        int left = 0, right = 1_000_000, ans = -1;

        while (left <= right) {
            mid = (left + right) / 2;

            if (check()) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
