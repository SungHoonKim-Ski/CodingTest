import java.io.*;
import java.util.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static class Edge{
        int to, weight;

        Edge(int _to, int _weight) {
            to = _to; weight = _weight;
        }
    }

    static class Info{
        int idx, dist;
        Info(int _idx, int _dist) {
            idx = _idx; dist = _dist;
        }
    }
    static ArrayList<Edge>[] graph;
//    static HashMap<Integer, Integer>[] graph;
    static int v, e, start, deliveryStart;
    static int[] myMinDist;
    static HashMap<Integer, int[]> deliveryMinDistMap;
    static int[] deliveryLoc;

    static void input() throws Exception{
        st = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        graph = new ArrayList[v + 1];

        for (int i = 1; i <= v; i++) {
            graph[i] = new ArrayList<>();
        }

        while (e-- > 0) {

            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[u].add(new Edge(v, w));
            graph[v].add(new Edge(u, w));
        }

        deliveryLoc = new int[10];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 10; i++) deliveryLoc[i] = Integer.parseInt(st.nextToken());

        start = Integer.parseInt(br.readLine());
    }

    static int[] dijkstra(int start) {

        int[] dist = new int[v + 1];
        for (int i = 1; i <= v; i++) dist[i] = Integer.MAX_VALUE;

        dist[start] = 0;

        PriorityQueue<Info> pq = new PriorityQueue<>((o1, o2) -> o1.dist - o2.dist);
        pq.add(new Info(start, 0));

        while (!pq.isEmpty()) {

            Info cur = pq.poll();
            if (dist[cur.idx] != cur.dist) continue; // 최신 정보가 아니라면 continue;
            for (Edge next  : graph[cur.idx]) {
                if (dist[next.to] > cur.dist + next.weight) {
                    dist[next.to] = cur.dist + next.weight;
                    pq.add(new Info(next.to, dist[next.to]));
                }
            }
        }
        return dist;
    }

    static void pro() {

        myMinDist = dijkstra(start);

        deliveryMinDistMap = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            if (deliveryMinDistMap.containsKey(deliveryLoc[i])) continue;
            deliveryMinDistMap.put(deliveryLoc[i], dijkstra(deliveryLoc[i]));
            // 이미 해당 점 기준으로 최단거리를 안다면 또 계산할 필요 x
        }

        int canBuyLoc = Integer.MAX_VALUE;

        int curDeliveryLoc = deliveryLoc[0];
        long timeSum = 0;

        for (int i = 0; i < 10; i++) {

            int[] nextDist = deliveryMinDistMap.get(curDeliveryLoc);
            // 현재 위치 기준으로 다익스트라를 돌린 배열을 가져옴

            if (nextDist[deliveryLoc[i]] == Integer.MAX_VALUE) continue;

            // 만약 야구르트 아줌마가 다음 정점을 갈 수 있는 경우
            timeSum += nextDist[deliveryLoc[i]];
            curDeliveryLoc = deliveryLoc[i];
            // 그만큼 시간을 더해주고, 내 위치를 업데이트

            if (myMinDist[curDeliveryLoc] <= timeSum) {
                // 만약 야구르트 아줌마보다 내가 먼저 도착할 수 있다면
                canBuyLoc = Math.min(curDeliveryLoc, canBuyLoc);
                // 가장 작은 정점 번호로 업데이트해준다
            }
        }

        if (canBuyLoc == Integer.MAX_VALUE) canBuyLoc = -1;
        System.out.println(canBuyLoc);
    }

    public static void main(String[] args) throws Exception{

        input();
        pro();

    }
}