import java.util.*;

class Solution {
    static final int INF = 1_000_000_001;

    static class Road {
        int x1, y1, x2, y2, limit;
        Road(int x1, int y1, int x2, int y2, int limit) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
            this.limit = limit;
        }
        boolean vertical() {
            return x1 == x2;
        }
    }

    static class PointOnRoad {
        int id;
        int x, y;
        PointOnRoad(int id, int x, int y) {
            this.id = id;
            this.x = x;
            this.y = y;
        }
    }

    static class State {
        int node;
        int cap;
        State(int node, int cap) {
            this.node = node;
            this.cap = cap;
        }
    }

    HashMap<Long, Integer> idMap;
    ArrayList<Integer> xs, ys, limit;
    ArrayList<Integer>[] graph;
    int[] cityNode;

    long key(int x, int y) {
        return (((long) x) << 32) ^ (y & 0xffffffffL);
    }

    int getNode(int x, int y) {
        long k = key(x, y);
        if (idMap.containsKey(k)) return idMap.get(k);

        int id = xs.size();
        idMap.put(k, id);
        xs.add(x);
        ys.add(y);
        limit.add(INF);
        return id;
    }

    void updateCamera(int id, int camLimit) {
        limit.set(id, Math.min(limit.get(id), camLimit));
    }

    boolean onRoad(int x, int y, Road r) {
        return r.x1 <= x && x <= r.x2 && r.y1 <= y && y <= r.y2;
    }

    
    int[] intersect(Road a, Road b) {
    
        if (a.vertical() && !b.vertical()) {
            int x = a.x1;
            int y = b.y1;
            if (onRoad(x, y, a) && onRoad(x, y, b)) return new int[]{x, y};
            return null;
        }
        if (!a.vertical() && b.vertical()) {
            int x = b.x1;
            int y = a.y1;
            if (onRoad(x, y, a) && onRoad(x, y, b)) return new int[]{x, y};
            return null;
        }

        
        if (a.vertical() && b.vertical()) {
            if (a.x1 != b.x1) return null;
            if (a.y2 == b.y1) return new int[]{a.x1, a.y2};
            if (b.y2 == a.y1) return new int[]{a.x1, b.y2};
            return null;
        }
        if (a.y1 != b.y1) return null;
        if (a.x2 == b.x1) return new int[]{a.x2, a.y1};
        if (b.x2 == a.x1) return new int[]{b.x2, a.y1};
        return null;
    }

    void addEdge(int a, int b) {
        if (a == b) return;
        graph[a].add(b);
        graph[b].add(a);
    }

    public int[] solution(int[][] city, int[][] road) {
        int n = city.length;
        int m = road.length;

        Road[] roads = new Road[m];
        for (int i = 0; i < m; i++) {
            roads[i] = new Road(road[i][0], road[i][1], road[i][2], road[i][3], road[i][4]);
        }

        idMap = new HashMap<>();
        xs = new ArrayList<>();
        ys = new ArrayList<>();
        limit = new ArrayList<>();

        cityNode = new int[n];
        for (int i = 0; i < n; i++) {
            cityNode[i] = getNode(city[i][0], city[i][1]);
        }

        ArrayList<Integer>[] roadPoints = new ArrayList[m];
        for (int i = 0; i < m; i++) roadPoints[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int mx = (roads[i].x1 + roads[i].x2) / 2;
            int my = (roads[i].y1 + roads[i].y2) / 2;
            int id = getNode(mx, my);
            updateCamera(id, roads[i].limit);
            roadPoints[i].add(id);
        }

        for (int c = 0; c < n; c++) {
            int x = city[c][0];
            int y = city[c][1];
            for (int i = 0; i < m; i++) {
                if (onRoad(x, y, roads[i])) {
                    roadPoints[i].add(cityNode[c]);
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                int[] p = intersect(roads[i], roads[j]);
                if (p == null) continue;

                int id = getNode(p[0], p[1]);
                roadPoints[i].add(id);
                roadPoints[j].add(id);
            }
        }

        int nodeCount = xs.size();
        graph = new ArrayList[nodeCount];
        for (int i = 0; i < nodeCount; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            ArrayList<PointOnRoad> pts = new ArrayList<>();
            for (int id : roadPoints[i]) {
                pts.add(new PointOnRoad(id, xs.get(id), ys.get(id)));
            }

            if (roads[i].vertical()) {
                pts.sort((a, b) -> {
                    if (a.y != b.y) return Integer.compare(a.y, b.y);
                    return Integer.compare(a.id, b.id);
                });
            } else {
                pts.sort((a, b) -> {
                    if (a.x != b.x) return Integer.compare(a.x, b.x);
                    return Integer.compare(a.id, b.id);
                });
            }

            PointOnRoad prev = null;
            for (PointOnRoad cur : pts) {
                if (prev != null && prev.id != cur.id) {
                    addEdge(prev.id, cur.id);
                }
                prev = cur;
            }
        }

        int start = cityNode[0];
        int[] best = new int[nodeCount];
        Arrays.fill(best, -1);

        PriorityQueue<State> pq = new PriorityQueue<>((a, b) -> Integer.compare(b.cap, a.cap));
        best[start] = INF;
        pq.add(new State(start, INF));

        while (!pq.isEmpty()) {
            State cur = pq.poll();
            if (cur.cap != best[cur.node]) continue;

            for (int nxt : graph[cur.node]) {
                int nextCap = Math.min(cur.cap, limit.get(nxt));
                if (nextCap > best[nxt]) {
                    best[nxt] = nextCap;
                    pq.add(new State(nxt, nextCap));
                }
            }
        }

        int[] answer = new int[n - 1];
        for (int i = 1; i < n; i++) {
            int cap = best[cityNode[i]];
            answer[i - 1] = (cap == INF ? 0 : cap);
        }

        return answer;
    }
}