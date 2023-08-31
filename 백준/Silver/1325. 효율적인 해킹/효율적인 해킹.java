import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer sb = new StringBuffer();
    static StringTokenizer st;
    static int n, m;

    static ArrayList<Integer>[] graph;

    static boolean[] visit;

    static int[] hackCnt;
    public static void input() throws IOException{


        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());


        graph = new ArrayList[n + 1];
        hackCnt = new int[n + 1];
        visit = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph[s].add(e);
        }

    }

    public static void pro() {



        for (int i = 1; i <= n; i++) {
            bfs(i);

        }

        int maxCount = -1;
        for (int i = 1; i <= n; i++) {
            if (maxCount < hackCnt[i]) {
                sb.setLength(0);
                sb.append(i).append(' ');
                maxCount = hackCnt[i];
            } else if (maxCount == hackCnt[i]) sb.append(i).append(' ');
        }
        System.out.println(sb);
    }

    public static void bfs(int start) {

        Deque<Integer> queue = new ArrayDeque<>();
        visit = new boolean[n + 1];
        visit[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {

            int cur = queue.poll();

            for (int next : graph[cur]) {
                if (visit[next]) continue;
                visit[next] = true;
                hackCnt[next]++;
                queue.add(next);
            }
        }
    }

    public static void main(String[] args) throws IOException{
        input();
        pro();
    }

}
