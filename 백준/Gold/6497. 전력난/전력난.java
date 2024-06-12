import java.io.*;
import java.util.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer sb = new StringBuffer();
    static StringTokenizer st;
    static ArrayList<Edge>[] graph;

    static int n, m;

    static long[] minDist;
    static boolean[] visit;
    static long costSum;
    static class Info {
        int idx;
        long dist;

        Info(int _idx, long _dist) {
            idx = _idx; dist = _dist;
        }
    }
    static class Edge {
        int to;
        long weight;

        Edge(int _to, long _weight) {
            to = _to; weight = _weight;
        }
    }

    static void input() throws IOException{

        minDist = new long[n];
        visit = new boolean[n];
        Arrays.fill(minDist, Long.MAX_VALUE);

        graph = new ArrayList[n];
        costSum = 0;
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            graph[x].add(new Edge(y, z));
            graph[y].add(new Edge(x, z));
            costSum += z;
        }
    }

    static void pro() {

        PriorityQueue<Info> pq = new PriorityQueue<>((o1, o2) -> Long.compare(o1.dist,o2.dist));
        pq.add(new Info(0, 0));

        minDist[0] = 0;
//        visit[0] = true;

        while (!pq.isEmpty()) {
            Info cur = pq.poll();
            if (visit[cur.idx]) continue;
            visit[cur.idx] = true;
            costSum -= cur.dist;
            for (Edge next : graph[cur.idx]) {
                if (visit[next.to]) continue;
                pq.add(new Info(next.to, next.weight));
            }
        }


        sb.append(costSum).append('\n');
    }


    public static void main(String[] args) throws Exception{
        while (true) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            if (n == 0 && m == 0) break;
            input();
            pro();
        }
        System.out.println(sb);
    }
}