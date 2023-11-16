import java.io.*;
import java.util.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static final int INF = Integer.MAX_VALUE;

    static class Edge{
        int to, weight;
        Edge(int _to, int _weight) {
            to = _to; weight = _weight;
        }
    }
    static class Info{
        // 시작점 기준으로 idx 정점까지의 비용을 저장하는 class
        // PrioirtyQueue에 사용

        int idx, dist;
        boolean isMan;

        Info(int _idx, int _dist, boolean _isMan) {
            idx = _idx; dist = _dist; isMan = _isMan;
        }
    }

    static ArrayList<Edge>[] graph;
    static boolean[] isMan;
    static int v, e;
    static void input() throws Exception{

        st = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken());
        // 정점
        e = Integer.parseInt(st.nextToken());
        // 간선

        isMan = new boolean[v + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= v; i++) {
            isMan[i] = (st.nextToken().charAt(0) == 'M');
        }

        graph = new ArrayList[v + 1];
        for (int i = 1; i <= v; i++) graph[i] = new ArrayList<>();

        int u, v, w;
        for (int i = 1; i <= e; i++) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            graph[u].add(new Edge(v, w));
            graph[v].add(new Edge(u, w));
        }
    }

    static void pro() {

        System.out.println(prim(1));
    }

    static int prim(int start) {

        boolean[] visit = new boolean[v + 1];
        PriorityQueue<Info> pq = new PriorityQueue<>((o1, o2) -> o1.dist - o2.dist);

        pq.add(new Info(start, 0, isMan[start]));

        int distSum = 0;
        int visitCnt = v;

        while (!pq.isEmpty()) {

            Info cur = pq.poll();
            if (visit[cur.idx]) continue;
            visitCnt--;
            visit[cur.idx] = true;
            distSum += cur.dist;
//            System.out.println(cur.idx);

            for (Edge next : graph[cur.idx]) {
                if (cur.isMan == isMan[next.to]) continue;
                pq.add(new Info(next.to, next.weight, isMan[next.to]));
            }
        }
        if (visitCnt != 0) distSum = -1;
        return distSum;
    }

    public static void main(String[] args) throws Exception{

        input();
        pro();

    }
}

