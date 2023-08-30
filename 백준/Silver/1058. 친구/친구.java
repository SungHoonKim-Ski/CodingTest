import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer sb = new StringBuffer();
    static StringTokenizer st;

    static boolean[][] graph;
    static boolean[] visit;
    static int[] friendCnt;
    static int n, maxCnt = 0;
    public static void input() throws IOException{

        n = Integer.parseInt(br.readLine());
        graph = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            char[] inputCharArr = br.readLine().toCharArray();
            for (int j = 0; j < n; j++) {
                graph[i][j] = inputCharArr[j] == 'Y'; // Y인 경우 연결된 그래프
                // 양방향 그래프이지만 입력에서 다 제공
            }
        }
        friendCnt = new int[n];
    }

    public static void pro() {

        for (int i = 0; i < n; i++) {
            visit = new boolean[n];
            visit[i] = true;
            backtracking(0, i, i);
            maxCnt = Math.max(friendCnt[i], maxCnt);
        }
        System.out.println(maxCnt);
    }

    public static void backtracking(int depth, int cur, int called) {

        if (depth == 2) return;

        for (int next = 0; next < n; next++) {
            if (next == cur) continue;
            if (!graph[cur][next]) continue;
            if (!visit[next]) friendCnt[called]++;
            visit[next] = true;
            backtracking(depth + 1, next, called);
        }
    }



    public static void main(String[] args) throws IOException{
        input();
        pro();
    }

}
