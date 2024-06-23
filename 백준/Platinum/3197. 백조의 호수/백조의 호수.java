import java.io.*;
import java.util.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer sb = new StringBuffer();
    static StringTokenizer st;
    static int r, c, day;
    static char[][] map;
    static boolean[][] visit, meetVisit;
    static int[][] loc;

    static ArrayList<int[]> nextMelt;
    static Queue<int[]> curMelt, que, nextQue;

    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};
    static void input() throws IOException{

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new char[r][c];
        meetVisit = new boolean[r][c];
        visit = new boolean[r][c];
        nextMelt = new ArrayList<>();
        nextQue = new ArrayDeque<>();

        int locCnt = 0;
        loc = new int[2][2];
        for (int i = 0; i < r; i++) {
            char[] str = br.readLine().toCharArray();
            for (int j = 0; j < c; j++) {
                map[i][j] = str[j];
                if (str[j] == 'L') {
                    map[i][j] = '.';
                    loc[locCnt][0] = i;
                    loc[locCnt++][1] = j;
                }

                if (map[i][j] == '.') {
                    nextMelt.add(new int[] {i, j});
                }
            }
        }
    }

    static void pro() {

        visit = new boolean[r][c];
        meetVisit = new boolean[r][c];

        nextQue.add(new int[] {loc[0][0], loc[0][1]});
        meetVisit[loc[0][0]][loc[0][1]] = true;

        while (true) {
            day++;
            bfs();
//            for (int i = 0; i < r; i++) {
//                System.out.println(Arrays.toString(map[i]));
//            }
//            System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
            if (canMeet()) break;
        }
        System.out.println(day);
    }
    static void bfs() {

        curMelt = new ArrayDeque<>(nextMelt);
        nextMelt.clear();

        while (!curMelt.isEmpty()) {

            int[] cur = curMelt.poll();

            for (int x = 0; x < 4; x++) {
                int ny = dy[x] + cur[0];
                int nx = dx[x] + cur[1];

                if (ny == -1 || nx == -1 || ny == r || nx == c) continue;
                if (visit[ny][nx]) continue;

                visit[ny][nx] = true;

                if (map[ny][nx] == 'X') {
                    nextMelt.add(new int[] {ny, nx});
                } else {
                    curMelt.add(new int[] {ny, nx});
                }
            }
        }

        for (int[] cur : nextMelt) {
            map[cur[0]][cur[1]] = '.';
        }
    }

    static boolean canMeet() {

        que = new ArrayDeque<>(nextQue);
        nextQue.clear();

        while (!que.isEmpty()) {
            int[] cur = que.poll();
            if (cur[0] == loc[1][0] && cur[1] == loc[1][1]) return true;

            for (int i = 0; i < 4; i++) {
                int ny = dy[i] + cur[0];
                int nx = dx[i] + cur[1];

                if (ny == -1 || nx == -1 || ny == r || nx == c) continue;
                if (meetVisit[ny][nx]) continue;

                if (map[ny][nx] == '.') {
                    meetVisit[ny][nx] = true;
                    que.add(new int[] {ny, nx});
                } else {
                    nextQue.add(new int[] {cur[0], cur[1]});
                }
            }
        }

        return false;
    }


    public static void main(String[] args) throws Exception{
        input();
        pro();
    }
}