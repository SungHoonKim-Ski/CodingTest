import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static final int[] dx = {0, 0, -1, 1};
    static final int[] dy = {-1, 1, 0, 0};

    static int n ,m;
    static char[][] map;
    static int[] start;
    static ArrayList<int[]> cams;
    static int[][] visit;

    static void input() throws IOException{
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        cams = new ArrayList<>();
        map = new char[n][m];

        for (int i = 0; i < n; i++) {
            char[] str = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                map[i][j] = str[j];
                if (map[i][j] == 'S') {
                    start = new int[] {i, j};
                    continue;
                }
                if (map[i][j] == 'C') {
                    cams.add(new int[] {i, j});
                    continue;
                }
            }
        }

        visit = new int[n][m];
        for (int i = 0; i < n; i++) Arrays.fill(visit[i], Integer.MAX_VALUE);
    }

    static void pro() {
        checkCam();
        if (visit[start[0]][start[1]] != -1) {
            find();
        }
        print();
    }

    static void checkCam() {
        int MAX = 100;
        for (int[] cam : cams) {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j <= MAX; j++) {
                    int nx = cam[0] + dx[i] * j;
                    int ny = cam[1] + dy[i] * j;

                    if (nx < 0 || ny < 0 || nx >= n || ny >= m) break;
                    if (map[nx][ny] == 'W') break;
                    if (map[nx][ny] == 'L' || map[nx][ny] == 'R' || map[nx][ny] == 'D' || map[nx][ny] == 'U') continue;
                    visit[nx][ny] = -1;
                }
            }
        }
    }

    static void find() {
        PriorityQueue<int[]> que = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        HashMap<Character, Integer> distMap = new HashMap<>();
        distMap.put('L', 0);
        distMap.put('R', 1);
        distMap.put('U', 2);
        distMap.put('D', 3);

        que.add(new int[] {0, start[0], start[1]});
        visit[start[0]][start[1]] = 0;

        while (!que.isEmpty()) {
            int[] cur = que.poll();
            int curMove = cur[0];
            char mapChar = map[cur[1]][cur[2]];

            if (mapChar == 'W') continue;
            if (visit[cur[1]][cur[2]] != curMove) continue;

            if (mapChar == 'L' || mapChar == 'R' || mapChar == 'U' || mapChar == 'D') {
                int nx = cur[1] + dx[distMap.get(mapChar)];
                int ny = cur[2] + dy[distMap.get(mapChar)];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (visit[nx][ny] <= curMove) continue;

                visit[nx][ny] = curMove;
                que.add(new int[] {curMove, nx, ny});
                continue;
            }

            int nMove = curMove + 1;
            for (int i = 0; i < 4; i++) {
                int nx = cur[1] + dx[i];
                int ny = cur[2] + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (visit[nx][ny] <= nMove) continue;

                visit[nx][ny] = nMove;
                que.add(new int[] {nMove, nx, ny});
            }

        }
    }

    static void print() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == '.') {
                    if (visit[i][j] == Integer.MAX_VALUE) visit[i][j] = -1;

                    sb.append(visit[i][j]).append('\n');
                }
            }
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}