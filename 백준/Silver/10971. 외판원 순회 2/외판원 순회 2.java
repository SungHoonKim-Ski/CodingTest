import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int[][] graph;
    static int n, min;
    static boolean[] visit;

    static void input() throws Exception {
        n = Integer.parseInt(br.readLine());
        graph = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if (graph[i][j] == 0) graph[i][j] = Integer.MAX_VALUE;
            }
        }
    }

    public static void pro() {
        min = Integer.MAX_VALUE;
        visit = new boolean[n];

        visit[0] = true;
        recur(1, 0, 0, 0);

        System.out.println(min);
    }

    static void recur(int depth, int cur, int start, int cost) {
        if (depth == n) {
            if (graph[cur][start] == Integer.MAX_VALUE) return;
            
            min = Math.min(min, cost + graph[cur][start]);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (cur == i) continue;
            if (visit[i]) continue;
            if (graph[cur][i] == Integer.MAX_VALUE) continue;

            visit[i] = true;
            recur(depth + 1, i, start, cost + graph[cur][i]);
            visit[i] = false;
        }
    }

    public static void main(String[] args) throws Exception{
        input();
        pro();
    }
}