import java.io.*;
import java.util.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer sb = new StringBuffer();
    static StringTokenizer st;
    static int r, c, day;
    static char[][] map;
    static boolean[][] visit, swanVisit;
    static int[][] swans;

    static ArrayList<int[]> meltList;
    static Queue<int[]> prevMeltQue, que, nextSwanQue;

    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};

    static void input() throws IOException{

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new char[r][c];
        swanVisit = new boolean[r][c];
        visit = new boolean[r][c];
        meltList = new ArrayList<>();
        nextSwanQue = new ArrayDeque<>();

        int swanCnt = 0;
        swans = new int[2][2];
        for (int i = 0; i < r; i++) {
            char[] str = br.readLine().toCharArray();
            for (int j = 0; j < c; j++) {
                map[i][j] = str[j];
                if (str[j] == 'L') {
                    map[i][j] = '.';
                    swans[swanCnt++] = new int[] {i, j};
                }

                if (map[i][j] == '.') {
                    meltList.add(new int[] {i, j});
                }
            }
        }
    }

    static void pro() {

        while (!canMeet()) {
            day++;
            melt();
        }

        System.out.println(day);
    }

    static void init() {
        nextSwanQue.add(new int[] {swans[0][0], swans[0][1]});
        swanVisit[swans[0][0]][swans[0][1]] = true;
    }

    static void melt() {
        prevMeltQue = new ArrayDeque<>(meltList);
        meltList.clear();

        while (!prevMeltQue.isEmpty()) {

            int[] cur = prevMeltQue.poll();

            for (int x = 0; x < 4; x++) {
                int ny = dy[x] + cur[0];
                int nx = dx[x] + cur[1];

                if (outOfMap(ny, nx)) continue;
                if (visit[ny][nx]) continue;

                visit[ny][nx] = true;

                if (map[ny][nx] == 'X') {
                    meltList.add(new int[] {ny, nx});
                } else {
                    prevMeltQue.add(new int[] {ny, nx});
                }
            }
        }

        for (int[] cur : meltList) {
            map[cur[0]][cur[1]] = '.';
        }
    }

    static boolean canMeet() {
        que = new ArrayDeque<>(nextSwanQue);
        nextSwanQue.clear();

        while (!que.isEmpty()) {
            int[] cur = que.poll();
            if (swanVisit[swans[1][0]][swans[1][1]]) return true;

            for (int i = 0; i < 4; i++) {
                int ny = dy[i] + cur[0];
                int nx = dx[i] + cur[1];

                if (outOfMap(ny, nx)) continue;
                if (swanVisit[ny][nx]) continue;

                if (map[ny][nx] == '.') {
                    swanVisit[ny][nx] = true;
                    que.add(new int[] {ny, nx});
                } else {
                    nextSwanQue.add(new int[] {cur[0], cur[1]});
                }
            }
        }

        return false;
    }

    static boolean outOfMap(int curY, int curX) {
        return curY < 0 || curX < 0 || curY >= r || curX >= c;
    }

    public static void main(String[] args) throws Exception{
        input();
        init();
        pro();
    }
}