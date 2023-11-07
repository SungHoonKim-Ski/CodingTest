import java.io.*;
import java.util.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static class Edge{
        // 간선, 가중치의 정보
        int to, weight;

        Edge(int _to, int _weight) {
            to = _to; weight = _weight;
        }
    }

    static class Info{
        // 시작점 기준으로 idx 정점까지의 비용을 저장하는 class
        // PrioirtyQueue에 사용

        int idx, dist;
        Info(int _idx, int _dist) {
            idx = _idx; dist = _dist;
        }
    }

    static ArrayList<Edge>[] graph;
    static int v, e, start;
    
    static int[] myMinDist;
    static int[] deliveryLoc;
    static HashMap<Integer, int[]> deliveryMinDistMap;

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

/*  아이디어는 내 정점 기준 다익스트라 + 야구르트 아주머니 기준 다익스트라 10번
    총 11번 다익스트라를 돌리는데

    전부 동일한 간선을 사용하므로 시작 정점만 다익스트라 함수에 준다면
    해당 정점 기준으로 모든 정점으로의 최단 거리를 구할 수 있고,
    이 값을 int[] 에 담아서 return하게 한다면,

    한개의 다익스트라 함수에게 11번 시작 정점을 넣어주고,
    그 함수 결과로 주는 최단 거리 int[] 배열을 받을 수 있음

    그리고 야구르트 아주머니는 동일한 지점을 재방문 할 수도 있으므로
    만약 이전에 해당 정점 기준으로 다익스트라를 계산했다면, 또 계산할 필요는 x
    
    그래서 내 시작점 기준으로 다익스트라를 돌린 값은 myMinDist[]에
    야구르트 아주머니 기준 다익스트라를 돌린 값은 HashMap<Integer, int[]> 맵에 저장하고
    이 때 key는 시작 정점, value는 시작 정점 기준 다른 정점까지의 최단거리
    
    
    이후에 필요한 내용은 아구르트 아주머니가 어떤 정점으로 최단거리로 움직이는데,
    내가 먼저 또는 동시에 해당 정점에 도착할 수 있는지 여부를 확인해야 함
    
    내가 살 수 있는 정점의 번호를 canBuyLoc에,
    야구르트 아주머니의 현재 위치를 curDeliveryLoc에 저장하고,
    야구르트 아주머니가 움직일 때마다 움직인 시간을 더해주어야 하므로, 이를 timeSum이라는 변수에 저장
    
    이후 아주머니가 다음 정점으로 갈 수 있는지 확인하며
    다음 정점으로 갈 수 있다면, 야구르트 아주머니의 위치인 curDeliceryLoc 값을 변경해주고
    해당 정점까지 이동한 총 시간을 timeSum 값에다가 계속 더해줌
    그리고 만약 야구르트 아주머니의 현재 위치 기준으로 내 최단거리(시간)이 작거나 같다면 이 값을 갱신
*/
