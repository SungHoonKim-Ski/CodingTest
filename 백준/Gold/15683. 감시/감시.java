import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer sb = new StringBuffer();
    static StringTokenizer st;
    static int n, m, minCCTVArea;

    static int[][] board;

    static Pos[][][] dir;
    static List<Pos> cctvList;

    public static void input() throws IOException{


        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        minCCTVArea = n * m;

        dir = new Pos[6][][];

        dir[1] = new Pos[4][];
        dir[1][0] = new Pos[] {new Pos(1, 0)};
        dir[1][1] = new Pos[] {new Pos(-1, 0)};
        dir[1][2] = new Pos[] { new Pos(0, 1)};
        dir[1][3] = new Pos[] {new Pos(0, -1)};

        dir[2] = new Pos[2][];
        dir[2][0] = new Pos[] {new Pos(1, 0), new Pos(-1, 0)};
        dir[2][1] = new Pos[] {new Pos(0, 1), new Pos(0, -1)};

        dir[3] = new Pos[4][];
        dir[3][0] = new Pos[] {new Pos(-1, 0), new Pos(0, 1)};
        dir[3][1] = new Pos[] {new Pos(0, 1), new Pos(1, 0)};
        dir[3][2] = new Pos[] {new Pos(1, 0), new Pos(0, -1)};
        dir[3][3] = new Pos[] {new Pos(0, -1), new Pos(-1, 0)};

        dir[4] = new Pos[4][];
        dir[4][0] = new Pos[] {new Pos(0, -1), new Pos(-1, 0), new Pos(0, 1)};
        dir[4][1] = new Pos[] {new Pos(-1, 0), new Pos(0, 1), new Pos(1, 0)};
        dir[4][2] = new Pos[] {new Pos(0, 1), new Pos(1, 0), new Pos(0, -1)};
        dir[4][3] = new Pos[] {new Pos(1, 0), new Pos(0, -1), new Pos(-1, 0)};

        dir[5] = new Pos[1][];
        dir[5][0] = new Pos[] {new Pos(0, -1), new Pos(-1, 0), new Pos(0, 1), new Pos(1, 0)};

        cctvList = new ArrayList<>();

        board = new int[n][m];

        for (int y = 0; y < n; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < m; x++) {
                board[y][x] = Integer.parseInt(st.nextToken());
                if (board[y][x] == 0) continue;
                if (board[y][x] == 6) continue;
                cctvList.add(new Pos(y, x));
            }
        }

    }

    public static void pro() {

        backtracking(0);
        System.out.println(minCCTVArea);
    }

    public static void backtracking(int depth) {

        if (depth == cctvList.size()) {

            minCCTVArea = Math.min(minCCTVArea, countCCTVArea());
            return;
        }

        Pos cur = cctvList.get(depth);
        int curCCTVType = board[cur.y][cur.x];
        for (int i = 0; i < dir[curCCTVType].length; i++) {
            Stack<Pos> changePos = new Stack<>();
            for (int j = 0; j < dir[curCCTVType][i].length; j++) {
                changePos.addAll(checkChangeArea(cur, dir[curCCTVType][i][j]));
            }
            backtracking(depth + 1);
            rollbackChangeArea(changePos);
//                Stack<Pos> changePos = new Stack<>();
//                for (int k = 0; k < dir[curCCTVType][i].length; k++) {
//                    changePos.addAll(checkChangeArea(cur, dir[curCCTVType][k][j]));
//                }

//            }
        }
    }

    public static Stack<Pos> checkChangeArea(Pos cur, Pos dir) {

        Stack<Pos> changePos = new Stack<>();
        int ny = cur.y + dir.y;
        int nx = cur.x + dir.x;
        while (!isNotPossible(ny, nx)) {
            if (board[ny][nx] == 0) {
                changePos.add(new Pos(ny, nx));
                board[ny][nx] = -1;
            }
            ny += dir.y;
            nx += dir.x;
        }
        return changePos;
    }

    public static void rollbackChangeArea(Stack<Pos> changePos) {

        while (!changePos.isEmpty()) {
            Pos cur = changePos.pop();
            board[cur.y][cur.x] = 0;
        }
    }
    public static int countCCTVArea() {

        int cnt = 0;
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {
                if (board[y][x] == 0) cnt++;
            }
        }

        return cnt;
    }

    public static boolean isNotPossible(int y, int x) {
        if (y >= n || x >= m || y < 0 || x < 0) return true;
        if (board[y][x] == 6) return true;
        return false;
    }

    static class Pos{
        int y, x;
        Pos (int y, int x) {
            this.y = y;
            this.x = x;
        }
    }


    public static void main(String[] args) throws IOException{
        input();
        pro();
    }

}