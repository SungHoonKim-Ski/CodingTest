import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer sb = new StringBuffer();
    static StringTokenizer st;

    static int n, nDivTwo;
    static int minDifStats = Integer.MAX_VALUE;

    static int[][] board;
    static boolean[] visit;

    public static void input() throws IOException{

        n = Integer.parseInt(br.readLine());
        nDivTwo = n / 2;

        board = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visit = new boolean[n];
    }

    public static void pro() {
        dfs(0, 0);
        System.out.println(minDifStats);
    }

    public static void dfs(int depth, int startIdx) {

        if (depth == nDivTwo) {

            int startTeamStats = 0;
            for (int i = 0; i < n; i++) {
                if (!visit[i]) continue;
                for (int j = i + 1; j < n; j++) {
                    if (!visit[j]) continue;
                    startTeamStats += board[i][j];
                    startTeamStats += board[j][i];
                }
            }

            int linkTeamStats = 0;
            for (int i = 0; i < n; i++) {
                if (visit[i]) continue;
                for (int j = i + 1; j < n; j++) {
                    if (visit[j]) continue;
                    linkTeamStats += board[i][j];
                    linkTeamStats += board[j][i];
                }
            }

            minDifStats = Math.min(minDifStats, Math.abs(startTeamStats - linkTeamStats));
            return;
        }

        for (int i = startIdx; i < n; i++) {
            if (visit[i]) continue;
            visit[i] = true;
            dfs(depth + 1, i + 1);
            visit[i] = false;
        }
    }

    public static void main(String[] args) throws IOException{
            input();
            pro();
    }

}
