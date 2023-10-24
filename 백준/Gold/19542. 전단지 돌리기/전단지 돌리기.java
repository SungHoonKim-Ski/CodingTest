import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static ArrayList<Integer>[] graph; // 입력 그래프
    
    static int N, S, D, distSum; // 초기값과 결과값을 위한 distSUm
    static boolean[] visit, isCount; 
    // dfs를 위한 visit 배열과
    // 부모와 자식의 거리가 D 이상인 경우 최소한 해당 부모까지는 방문을 해야만 함
    // 이 때 distSum++을 함과 동시에 isCount[parent] = true를 통해 해당 부모르
    // 체크했다는 표시를 위한 배열
    
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
            if (visit[nextIdx]) continue; // 양방향 그래프이므로 방문 처리 필요
            visit[nextIdx] = true;
            maxDist = Math.max(maxDist, dfs(nextIdx) + 1);
            // 부모 기준으로 가장 먼 자식의 거리 + 1이 maxDist
            // 재귀적으로 자식들을 호출
        }

        if (!isCount[curIdx] && maxDist >= D) {
            // 만약 자식과의 거리가 D 이상이면서 이 자식을 세지 않앗다면 카운트++
            isCount[curIdx] = true;
            distSum++;
        }
        
        return maxDist;
        // 자식 기준으로 가장 먼 자식의 거리를 return
        // 이 경우 시간 복잡도가 O(N)만에 해결될듯 싶은데..
    }

    public static void main(String[] args) throws IOException{
        input();
        pro();
    }


}