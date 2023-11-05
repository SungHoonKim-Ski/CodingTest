import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer sb = new StringBuffer();
    static StringTokenizer st;

    static class Edge {
        int to, weight;
        Edge(int _to, int _weight) {
            to = _to; weight = _weight;
        }
    }

    static class Info {
        int idx, dist;
        Info(int _idx, int _dist) {
            idx = _idx; dist = _dist;
        }
    }

    static final long INF = Integer.MAX_VALUE;

    static int n, m;
    static long[] dist;
    static ArrayList<Edge>[] graph;
    static void input() throws IOException{

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        dist = new long[n + 1];
        graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
            dist[i] = INF;
        }

        int start, end, weight;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            weight = Integer.parseInt(st.nextToken());

            graph[start].add(new Edge(end, weight));
        }
    }

    static void pro(){

        dist[1] = 0;
        boolean isCycle = false;

        for (int round = 1; round <= n; round++) {

            for (int start = 1; start <= n; start++) {

                for (Edge end : graph[start]) {
                    if (dist[start] == INF) continue;
                    
                    if (dist[end.to] > dist[start] + end.weight) {
                        dist[end.to] = dist[start] + end.weight;

                        if (round == n) {
                            isCycle = true;
                        }
                    }
                }
            }
        }

        if (isCycle) sb.append(-1);
        else {
            for (int i = 2; i <= n; i++) {
                if (dist[i] == INF) sb.append(-1);
                else sb.append(dist[i]);
                sb.append('\n');
            }
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException{

        input();
        pro();

    }

}