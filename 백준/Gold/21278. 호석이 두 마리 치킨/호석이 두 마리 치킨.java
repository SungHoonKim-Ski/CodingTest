import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer sb = new StringBuffer();
    static StringTokenizer st;

    static int n, m;
    static ArrayList<Integer>[] graph;

    static int minTime;
    static int[] chickenLoc;
    static void input() throws IOException{

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph[s].add(e);
            graph[e].add(s);
        }

        minTime = Integer.MAX_VALUE;
        chickenLoc = new int[2];
    }

    static void pro(){

        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                bfs(i, j);
            }
        }
        sb.append(chickenLoc[0]).append(' ').append(chickenLoc[1]).append(' ').append(minTime);
        System.out.println(sb);
    }

    static void bfs(int loc1, int loc2) {

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[loc1] = 0;
        dist[loc2] = 0;

        Deque<Integer> que = new ArrayDeque<>();
        que.add(loc1); que.add(loc2);

        while (!que.isEmpty()) {
            int cur = que.poll();
            for (int next : graph[cur]) {
                if (dist[cur] + 1 >= dist[next]) continue;
                dist[next] = dist[cur] + 1;
                que.add(next);
            }
        }

        int sum = 0;
        for (int i = 1; i <= n; i++) sum += dist[i];
        sum *= 2;
        if (minTime > sum) {
            minTime = sum;
            chickenLoc[0] = loc1;
            chickenLoc[1] = loc2;
        }
    }


    public static void main(String[] args) throws IOException{
        input();
        pro();
    }

}