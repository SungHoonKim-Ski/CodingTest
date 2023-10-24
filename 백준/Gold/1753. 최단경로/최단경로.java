import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    static int V, E, start;
    static ArrayList<Edge>[] graph;

    static int[] cost;
    static class Edge{
        int to, weight;
        Edge(int _to, int _weight) {
            to = _to; weight = _weight;
        } 
    }
    
    static class Info{
        int idx, dist;
        Info (int _idx, int _dist) {
            idx = _idx; dist = _dist;
        }
    }
    
    static void input() throws IOException{
         st = new StringTokenizer(br.readLine());
         V = Integer.parseInt(st.nextToken());
         E = Integer.parseInt(st.nextToken());
         start = Integer.parseInt(br.readLine());

         graph = new ArrayList[V + 1];
         for (int i = 1; i <= V; i++) graph[i] = new ArrayList<>();

         while (E-- > 0) {
             st = new StringTokenizer(br.readLine());
             int u = Integer.parseInt(st.nextToken());
             int v = Integer.parseInt(st.nextToken());
             int w = Integer.parseInt(st.nextToken());
             graph[u].add(new Edge(v, w));
         }

         cost = new int[V + 1];
    }

    static void dijkstra(int start) {

        for (int i = 1; i <= V; i++) cost[i] = Integer.MAX_VALUE;
        cost[start] = 0;

        PriorityQueue<Info> pq = new PriorityQueue<>((o1, o2) -> o1.dist - o2.dist);

        pq.add(new Info(start, 0));
        while (!pq.isEmpty()) {
            Info curInfo = pq.poll();
            if (cost[curInfo.idx] != curInfo.dist) continue;

            for (Edge next : graph[curInfo.idx]) {
                if (cost[next.to] > curInfo.dist + next.weight) {
                    cost[next.to] = curInfo.dist + next.weight;
                    pq.add(new Info(next.to, cost[next.to]));
                }
            }
        }

        for (int i = 1; i <= V; i++) {
            if (cost[i] == Integer.MAX_VALUE) sb.append("INF");
            else sb.append(cost[i]);
            sb.append('\n');
        }
        System.out.println(sb);
    }

    static void pro() {
        dijkstra(start);

    }

    public static void main(String[] args) throws IOException{
        input();
        pro();
    }


}