import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static ArrayList<Integer>[] graph;
    static int N, S, D, distSum;

    static boolean[] visit, isCount;

    static void input() throws IOException{
         st = new StringTokenizer(br.readLine());
         N = Integer.parseInt(st.nextToken());
         S = Integer.parseInt(st.nextToken());
         D = Integer.parseInt(st.nextToken());

         graph = new ArrayList[N + 1];
         for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

         for (int i = 1; i < N; i++) {
             st = new StringTokenizer(br.readLine());
             int start = Integer.parseInt(st.nextToken());
             int end = Integer.parseInt(st.nextToken());
             graph[start].add(end);
             graph[end].add(start); // 양방향 그래프이므로 둘 다 추가
         }

         visit = new boolean[N + 1];
         isCount = new boolean[N + 1];
    }

    static void pro() {

        visit[S] = true;
        isCount[S] = true;
        dfs(S);
        System.out.println(distSum * 2); // 왕복이므로 2배
    }

    static int dfs(int curIdx) {

        int maxDist = 0;

        for (int nextIdx : graph[curIdx]) {
            if (visit[nextIdx]) continue;
            visit[nextIdx] = true;
            maxDist = Math.max(maxDist, dfs(nextIdx) + 1);
        }


        if (!isCount[curIdx] && maxDist >= D) {
            isCount[curIdx] = true;
            distSum++;
        }

        return maxDist;
    }

    public static void main(String[] args) throws IOException{
        input();
        pro();
    }


}