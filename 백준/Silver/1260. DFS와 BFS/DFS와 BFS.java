import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static BufferedReader br;
    static StringBuffer sb;

    static int[][] Graph;
    static boolean[] IsVisited;
    static int N, M;

    public static void main(String[] args) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuffer();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        Graph = new int[N+1][N+1];
        IsVisited = new boolean[N+1];

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            Graph[a][b] = 1;
            Graph[b][a] = 1;
        }

        DFS(v);
        sb.append('\n');
        for (int i=1; i<IsVisited.length; i++) {
            IsVisited[i] = false;
        }
        BFS(v);
        System.out.println(sb);
    }

    
    
    public static void DFS(int start){ // recursive

        if (!IsVisited[start]) {
            sb.append(start).append(' ');
            IsVisited[start] = true;
        }


        for (int i=1; i<=N; i++) {
            if (!IsVisited[i] && Graph[start][i] == 1) {
                DFS(i);
            }
        }
    }

    public static void BFS(int start){ // queue

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            int point = queue.poll();
            if (!IsVisited[point]) {
                sb.append(point).append(' ');
                IsVisited[point] = true;
            }
            for (int i=1; i<=N; i++) {
                if (!IsVisited[i] && Graph[i][point] == 1) {
                    queue.add(i);
                }
            }
        }
    }
}