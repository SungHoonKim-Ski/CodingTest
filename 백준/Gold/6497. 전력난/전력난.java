import java.io.*;
import java.util.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer sb = new StringBuffer();
    static StringTokenizer st;
    static int n, m;
    static long costSum;

    static int[] parent;
    static ArrayList<Edge> edgeList;

    static class Edge implements Comparable<Edge>{
        int from, to;
        long weight;

        Edge(int _from, int _to, long _weight) {
            from = _from; to = _to; weight = _weight;
        }

        @Override
        public int compareTo(Edge e) {
            return Long.compare(this.weight, e.weight);
        }
    }

    static void input() throws IOException{

        parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;

        costSum = 0;

        edgeList = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            edgeList.add(new Edge(x, y, z));
            costSum += z;
        }
    }

    static boolean union(int a, int b) {

        int parentA = find(a);
        int parentB = find(b);
        if (parentA == parentB) return false;
        parent[parentB] = parentA;
        return true;
    }

    static int find(int a) {
        if (parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }
    static void pro() {
        
        Collections.sort(edgeList);

        int vertex = 0;

        for (Edge e : edgeList) {

            if (union(e.from, e.to)) {
                vertex++;
                costSum -= e.weight;
                if (vertex == n + 1) break;
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