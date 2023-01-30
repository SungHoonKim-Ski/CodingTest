import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    private static BufferedReader br;
    static int[][] Board;
    static boolean[][] Visited;
    static int[] dy = {1, 0, -1, 1, 0, -1, 1, -1};
    static int[] dx = {1, 1, 1, -1, -1, -1, 0, 0};
    static int N;
    static Queue<int[]> BombQueue;
    static int Click_Cnt;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        BombQueue = new LinkedList<>();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            N = sc.nextInt();
            Board = new int[N][N];
            Visited = new boolean[N][N];
            Click_Cnt = 0;

            for (int i=0; i<N; i++) {
                char[] input = sc.next().toCharArray();
                for (int j=0; j<N; j++) {
                    if (input[j] == '*') {
                        BombQueue.add(new int[]{i, j});
                        Visited[i][j] = true;
                        Board[i][j] = -1;
                    }else {
                        Board[i][j] = 0;
                    }
                }
            }

            while (!BombQueue.isEmpty()) {
                int[] cur = BombQueue.poll();
                int curY = cur[0];
                int curX = cur[1];

                for (int i=0; i<8; i++) {
                    int nextY = curY + dy[i];
                    int nextX = curX + dx[i];
                    if (nextY > (N-1) || nextY < 0 || nextX > (N-1) || nextX < 0) continue;
                    if (Board[nextY][nextX] == -1) continue;
                    Board[nextY][nextX]++;
                }
            }

            for (int i=0; i<N; i++) {
                for (int j=0; j<N; j++) {
                    if (!Visited[i][j]) {
                        if (Board[i][j] == 0) {
                            if (!Visited[i][j]) {
                                Click_Cnt++;
                                dfs(i, j);
                            }
                        }
                    }
                }
            }

            for (int i=0; i<N; i++) {
                for (int j=0; j<N; j++) {
                    if (!Visited[i][j]) Click_Cnt++;
                }
            }

            System.out.printf("#%d %d\n", test_case, Click_Cnt);
        }
    }

    static void dfs(int y, int x) {
        Visited[y][x] = true;
        for (int i=0; i<8; i++) {
            int nextY = y + dy[i];
            int nextX = x + dx[i];
            if (nextY > (N - 1) || nextY < 0 || nextX > (N - 1) || nextX < 0) continue;
            if (Board[nextY][nextX] == 0 && !Visited[nextY][nextX]) {
                dfs(nextY, nextX);
            }else if (!Visited[nextY][nextX]) Visited[nextY][nextX] = true;
        }
    }
}