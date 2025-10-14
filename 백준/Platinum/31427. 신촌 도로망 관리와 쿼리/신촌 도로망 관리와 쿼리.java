import java.io.*;
import java.util.*;

public class Main {
    static class Edge {
        int from, to;

        Edge(int from, int to) {
            this.from = from; this.to = to;
        }
    }

    static class Info {
        int idx, school;
        long cost;

        Info(int idx, int school, long cost) {
            this.idx = idx; this.school = school; this.cost = cost;
        }
    }
    static final int MAX = 5;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n, m, q;
    static ArrayList<Edge>[] graph;
    static int[][][][][][] used;

    static boolean[] schoolVisit, visit;
    static PriorityQueue<Info> que;

    static int[] parent;

    static void input() throws IOException{
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        graph = new ArrayList[MAX];
        for (int i = 0; i < MAX; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = st.nextToken().charAt(0) - 'A';

            graph[z].add(new Edge(x, y));
        }

        parent = new int[n + 1];
    }

    static void init() {
        used = new int[MAX][MAX][MAX][MAX][MAX][MAX];
        schoolVisit = new boolean[MAX];
        que = new PriorityQueue<>((o1, o2) -> Long.compare(o1.cost, o2.cost));
        recur(0, new int[MAX]);
    }

    static void recur(int depth, int[] order) {
        if (depth == MAX) {
            mst(order);
            return;
        }

        for (int i = 0; i < MAX; i++) {
            if (schoolVisit[i]) continue;
            schoolVisit[i] = true;
            order[depth] = i;
            recur(depth + 1, order);
            schoolVisit[i] = false;
        }
    }

    static boolean union(int a, int b) {
        int pa = find(a);
        int pb = find(b);

        if (pa == pb) return false;
        parent[pb] = pa;
        return true;
    }

    static int find(int a) {
        if (parent[a] == a) return a;
        else return parent[a] = find(parent[a]);
    }

    static void mst(int[] order) {
        int[] curUsed = new int[MAX];

        int[] rank = new int[MAX];
        for (int i = 0; i < MAX; i++) {
            rank[order[i]] = i;
        }
        for (int i = 1; i <= n; i++) parent[i] = i;

        visit = new boolean[n + 1];
        int visitCount = 0;
        for (int i = 0; i < MAX; i++) {
            for (Edge e : graph[rank[i]]) {
                if (union(e.from, e.to)) {
                    visitCount++;
                    curUsed[rank[i]]++;

                    if (visitCount == n - 1) break;
                }
            }
            if (visitCount == n - 1) break;
        }


        used[order[0]][order[1]][order[2]][order[3]][order[4]] = curUsed;
    }

    static void pro() throws IOException {
        while (q-- > 0) {
            int[] realCost = new int[MAX];

            st = new StringTokenizer(br.readLine());
            ArrayList<int[]> orderArr = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                realCost[i] = Integer.parseInt(st.nextToken());
                orderArr.add(new int[] {i, realCost[i]});
            }

            Collections.sort(orderArr, ((o1, o2) -> o1[1] - o2[1]));
            int[] rank = new int[5];
            for (int i = 0; i < 5; i++) {
                int school = orderArr.get(i)[0];
                rank[school] = i;
            }

            int[] eachUsed = used[rank[0]][rank[1]][rank[2]][rank[3]][rank[4]];
            long sum = 0;

            for (int i = 0; i < MAX; i++) {
                sum += eachUsed[i] * (long)realCost[i];
            }
            sb.append(sum).append('\n');
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        input();
        init();
        pro();
    }
}