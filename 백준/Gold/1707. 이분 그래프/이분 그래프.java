import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static ArrayList<Integer>[] graph;
    static int[] visit;
    static int v, e;
    /**
     * indeg
     *
     */
    static void input() throws Exception {
        st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        graph = new ArrayList[v + 1];
        for (int i = 1; i <= v; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
            graph[v].add(u);
        }
    }


    public static boolean pro() {
        visit = new int[v + 1];
        Arrays.fill(visit, -1);

        for (int i = 1; i <= v; i++) {
            if (visit[i] != -1) continue;
            if (!bfs(i)) return false;
        }

        return true;
    }

    static boolean bfs(int start) {
        Queue<int[]> que = new ArrayDeque<>();
        que.add(new int[] {start, 0});
        visit[start] = 0;

        while (!que.isEmpty()) {
            int[] cur = que.poll();
            int nextFlag = (cur[1] + 1) % 2;

            for (int next : graph[cur[0]]) {
                if (visit[next] == cur[1]) return false;
                if (visit[next] == nextFlag) continue;
                visit[next] = nextFlag;
                que.add(new int[] {next, nextFlag});
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        int tc = Integer.parseInt(br.readLine());

        while (tc -- > 0) {
            input();
            if (pro()) sb.append("YES");
            else sb.append("NO");
            sb.append('\n');
        }

        System.out.println(sb);
    }
}