import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    static char[][] Board;
    static int Res = 0;
    static int R, C;
    static HashSet<Character> boardSet;
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        Board = new char[R][C];

        for (int i=0; i<R; i++) {
            Board[i] = br.readLine().toCharArray();
        }
        boardSet = new HashSet<>();
        boardSet.add(Board[0][0]);
        BFS(0, 0);
        System.out.println(Res);
    }

    public static void BFS(int y, int x) {

        boolean hasNext = false;

        for (int i=0; i<4; i++) {
            int prevY = y + dy[i];
            int prevX = x + dx[i];

            if (prevY < 0 || prevX < 0 || prevX == C || prevY == R) continue;
            if (!boardSet.contains(Board[prevY][prevX])) {
                boardSet.add(Board[prevY][prevX]);
                BFS(prevY, prevX);
                boardSet.remove(Board[prevY][prevX]);
            }
        }

        if (!hasNext) {
            Res = Math.max(Res, boardSet.size());
        }

    }
}
