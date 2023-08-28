import java.sql.Array;
import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer sb = new StringBuffer();
    static StringTokenizer st;

    static int n, minVal = Integer.MAX_VALUE;
    static int[] peopleArr;
    static int minDifStats = Integer.MAX_VALUE;
    static boolean[] visit, color;

    static ArrayList<Integer>[] graph;

    public static void input() throws IOException{

        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        peopleArr = new int[n + 1];

        for (int i = 1; i <= n; i++) peopleArr[i] = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            while (cnt-- > 0) {
                int s = i;
                int e = Integer.parseInt(st.nextToken());
                graph[s].add(e);
                graph[e].add(s);
            }
        }

        visit = new boolean[n + 1];
        color = new boolean[n + 1];
    }

    public static void pro() {

        for (int i = 1; i < n; i++) {
            permutation(0, i, 1);
        }
        if (minVal == Integer.MAX_VALUE) minVal = -1;
        System.out.println(minVal);
    }

    static void permutation(int depth, int needDepth, int curIdx) {

        if (depth == needDepth) {

            int cnt = 0;
            boolean[] checkVisit = new boolean[n + 1];

            for (int i = 1; i <= n; i++) {
                if (!checkVisit[i]) {
                    checkVisit[i] = true;
                    cnt++;
                    if (cnt > 2) break;
                    Queue<Integer> que = new ArrayDeque<>();
                    que.add(i);
                    boolean curColor = color[i];
                    while (!que.isEmpty()) {
                        int cur = que.poll();
                        for (int next : graph[cur]) {
                            if (checkVisit[next]) continue;
                            if (curColor != color[next]) continue;
                            checkVisit[next] = true;
                            que.add(next);
                        }
                    }
                }
            }

            if (cnt == 2) {
                int blueCnt = 0;
                int redCnt = 0;

                for (int i = 1; i <= n; i++) {
                    if (color[i]) blueCnt += peopleArr[i];
                    else redCnt += peopleArr[i];
                }
                minVal = Math.min(minVal, Math.abs(redCnt - blueCnt));
            }
            return;
        }

        for (int i = curIdx; i <= n; i++) {
            if (visit[i]) continue;
            visit[i] = true;
            color[i] = true;
            permutation(depth + 1, needDepth, i + 1);
            color[i] = false;
            visit[i] = false;
        }
    }


    public static void main(String[] args) throws IOException{
        input();
        pro();
    }

}
