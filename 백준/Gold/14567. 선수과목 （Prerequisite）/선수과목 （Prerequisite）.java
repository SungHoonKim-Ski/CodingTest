import java.io.*;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int[] indeg, season;
    static int n, m, hasNext;

    static ArrayList<Integer>[] graph;

    static void input() throws IOException{
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();

        indeg = new int[n + 1];
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            // A번 과목이 B번 과목의 선수과목
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            indeg[b]++;
        }
        hasNext = n;
        season = new int[n + 1];
    }
    static void pro(){

        int curSeason = 1;
        Deque<Integer> que = new ArrayDeque<>();
        while (hasNext != 0) {

            for (int i = 1; i <= n; i++) {
                if (indeg[i] == 0) {
                    indeg[i] = -1;
                    que.add(i);
                    hasNext--;
                    season[i] = curSeason;
                }
            }

            while (!que.isEmpty()) {
                int cur = que.poll();
                for (int next : graph[cur]) {
                    indeg[next]--;
                }
            }

            curSeason++;
        }
        for (int i = 1; i <= n; i++) {
            sb.append(season[i]).append(' ');
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException{

        input();
        pro();
    }
}


