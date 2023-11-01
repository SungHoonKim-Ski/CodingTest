import java.util.*;
import java.io.*;

public class Main {

    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    static class Edge {
        int to, weight;
        Edge(int _to, int _weight) {
            to = _to; weight = _weight;
        }
    }
    static class Info {
        
    	int idx, dist;
//        HashSet<Road> visitRoads;
        Info(int _idx, int _dist) {
            idx = _idx; dist = _dist;
        }
//        Info(int _idx, int _dist, HashSet _visitRoads) {
//        	idx = _idx; dist = _dist; visitRoads = _visitRoads;
//        }
    }
//    static class RoadInfo {
//        int idx, weight;
//        HashSet<Road> roadNum;
//        RoadInfo(int _idx, int _weight) {
//            idx = _idx; weight = _weight;
//            roadNum = new HashSet<>();
//        }
//    }
    static class Road {

        int from, to;

        Road(int _from, int _to) {
            this.from = _from; this.to = _to;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Road) {
                Road road = (Road)obj;
                return (road.from == this.from && road.to == this.to);
            }
            return super.equals(obj);
        }

        @Override
        public int hashCode() {
            return (from * 100003) ^ (to * 100003);
        }
    }
    
    
    static ArrayList<Edge>[] graph, reverseGraph;
//    static HashSet<Road>[] visit;
    static int n, m, start, end, maxDist;
    static int[] dist, revIndeg, indeg;

    static void input() throws IOException {

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

//        visit = new HashSet[n + 1];
//        for (int i = 1; i <= n; i++) visit[i] = new HashSet<>();

        graph = new ArrayList[n + 1];
        reverseGraph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
            reverseGraph[i] = new ArrayList<>();
        }

        dist = new int[n + 1];
        revIndeg = new int[n + 1];
        indeg = new int[n + 1];

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph[from].add(new Edge(to, weight));
            reverseGraph[to].add(new Edge(from, weight));
            revIndeg[from]++;
            indeg[to]++;
        }
        st = new StringTokenizer(br.readLine());

        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
    }

    static void revToplogic() {

        for (int i = 1; i <= n; i++) dist[i] = Integer.MIN_VALUE;

        dist[end] = 0;

        Deque<Info> que = new ArrayDeque<>();
        que.add(new Info(end, 0));

        while (!que.isEmpty()) {

            Info curInfo = que.poll();

            for (Edge next : reverseGraph[curInfo.idx]) {
                if (revIndeg[next.to] == 0) continue;
                dist[next.to] = Math.max(dist[next.to], curInfo.dist + next.weight);
                revIndeg[next.to]--;

                if (revIndeg[next.to] == 0) {
                    Info info = new Info(next.to, dist[next.to]);
                    que.add(info);
                }
            }
        }
        maxDist = dist[start];
    }
    
    static void toplogic() {

        for (int i = 1; i <= n; i++) dist[i] = Integer.MIN_VALUE;

        dist[start] = 0;

        Deque<Info> que = new ArrayDeque<>();
        que.add(new Info(start, 0));

        while (!que.isEmpty()) {

            Info curInfo = que.poll();

            for (Edge next : graph[curInfo.idx]) {
                if (indeg[next.to] == 0) continue;
                
                dist[next.to] = Math.max(dist[next.to], curInfo.dist + next.weight);
                indeg[next.to]--;

                if (indeg[next.to] == 0) {
                    Info info = new Info(next.to, dist[next.to]);
                    que.add(info);
                }
            }
        }
        maxDist = dist[end];
        
//        for (int i = 1; i <= n; i++) System.out.printf("%d ", dist[i]);
//        System.out.println();
//        
//        System.out.println(maxDist);
    }
    
    static void bfs() {
    	
//    	for (int i = 1; i <= n; i++) {
//    		sb.append(dist[i]).append(' ');
//    	}
//    	System.out.println(sb);
    	
    	int cnt = 0;
    	Deque<Info> que = new ArrayDeque<>();
    	HashSet<Road> visit = new HashSet<>();
    	
    	que.add(new Info(end, 0));
    	
    	while(!que.isEmpty()) {
    		
    		Info cur = que.poll();
			
    		for (Edge next : reverseGraph[cur.idx]) {
    			if (dist[next.to] == dist[cur.idx] - next.weight) {
//    				sb.append(cur.idx).append(" -> ").append(next.to).append('\n');
    				if (visit.add(new Road(cur.idx, next.to)))
    				que.add(new Info(next.to, dist[next.to]));
    			}
    		}
    	}
//    	System.out.println(sb);
    	System.out.println(maxDist);
    	System.out.println(visit.size());
//    	System.out.println(maxDist);
    	
    }
    
    static void pro(){
        toplogic();
        bfs();
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}