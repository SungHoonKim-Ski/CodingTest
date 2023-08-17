import java.util.*;
import java.io.*;
public class Main
{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[] Fishs;
    static int[][] Board;
    static boolean[][] Visit;

    static int CurY, CurX, CurSize, CurNeedFish;

    static int[] dy = {-1, 0, 0, 1};
    static int[] dx = {0, -1, 1, 0};

    public static void input() throws IOException{

        N = Integer.parseInt(br.readLine());
        CurSize = CurNeedFish = 2;

        Board = new int[N][N];
        Fishs = new int[7];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                char c = st.nextToken().charAt(0);
                if (c == '9') {
                    CurY = i;
                    CurX = j;
                } else {
                    Fishs[c - '0']++; // 0은 사용 x
                    Board[i][j] = c - '0';
                }
            }
        }
    }



    public static void pro() {

        int move = 0;
        while (true) {

            boolean hasNextFish = false;
            int compare = Math.min(CurSize, 7);
            for (int i = 1; i < compare; i++) {
                if (Fishs[i] != 0) {
                    hasNextFish = true;
                    break;
                }
            }
            if (!hasNextFish) break;

            int[] nextFishInfo = searchBfs(); // y, x, move
            if (nextFishInfo == null) break;
            CurY = nextFishInfo[0];
            CurX = nextFishInfo[1];
            move += nextFishInfo[2];
//            System.out.println(Arrays.toString(nextFishInfo) + " / " + move);
            if (CurNeedFish == 0) {
                CurSize++;
                CurNeedFish = CurSize;
            }

        }
        System.out.println(move);
    }

    public static int[] searchBfs() {

        Queue<int[]> que = new LinkedList<>();

        que.add(new int[] {CurY, CurX, 0});
        Visit = new boolean[N][N];
        Visit[CurY][CurX] = true;

        List<int[]> sameDisShark = new ArrayList<>();

        while (!que.isEmpty()) {

            int[] cur = que.poll();
            if (sameDisShark.size() != 0 && Board[cur[0]][cur[1]] != 0 && Board[cur[0]][cur[1]] != CurSize) {

                if (Board[cur[0]][cur[1]] >= CurSize) continue;
                if (cur[2] > sameDisShark.get(0)[2]) continue;
                if (cur[2] < sameDisShark.get(0)[2]) sameDisShark.clear();
                sameDisShark.add(cur);
                continue;
            }
//            System.out.println(Arrays.toString(cur) + " / " + CurSize);
            for (int i = 0; i < 4; i++) {
                int ny = cur[0] + dy[i];
                int nx = cur[1] + dx[i];
                int nMove = cur[2] + 1;
                if (!vaild(ny, nx)) continue;
                if (Visit[ny][nx]) continue;
                if (Board[ny][nx] > CurSize) continue;
                Visit[ny][nx] = true;
                if (Board[ny][nx] == 0 || Board[ny][nx] == CurSize) {
                    que.add(new int[] {ny, nx, nMove});
                } else {
                    if (sameDisShark.size() == 0) sameDisShark.add(new int[] {ny, nx, nMove});
                    else if (sameDisShark.get(0)[2] == nMove) sameDisShark.add(new int[] {ny, nx, nMove});
                }
            }
        }
        if (sameDisShark.size() == 0) return null;
        int[] priorityShark = sameDisShark.get(0);
        for (int i = 1; i < sameDisShark.size(); i++) {
            int[] curShark = sameDisShark.get(i);
            if (curShark[0] < priorityShark[0]) { // 기존값이 y가 큰 경우
                priorityShark = curShark;
                continue;
            }
            if(curShark[0] == priorityShark[0]) { // y가 같은 경우
                priorityShark[1] = Math.min(priorityShark[1], curShark[1]);
            }
        }
        Fishs[Board[priorityShark[0]][priorityShark[1]]]--;
        Board[priorityShark[0]][priorityShark[1]] = 0;
        CurNeedFish--;
        return priorityShark;
    }

    public static boolean vaild(int y, int x) {
        if (y == N || x == N || y == -1 || x == -1) return false;
        return true;
    }


    public static void main(String args[]) throws IOException
    {
        input();
        pro();

    }
}