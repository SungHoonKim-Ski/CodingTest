import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

//    static class Edge {
//        public int to;
//        public int weight;
//
//        public Edge(int _to, int _weight) {
//            this.to = _to;
//            this.weight = _weight;
//        }
//    }
//
//    static class Info {
//        public int idx, dist;
//
//        public Info() {
//        }
//
//        public Info(int _idx, int _dist) {
//            this.idx = _idx;
//            this.dist = _dist;
//        }
//    }

    static int N, Max = 0;
    static int[] arr;
//    static int[] dist;
//    static ArrayList<Edge>[] edges;

    static void input() {
        N = scan.nextInt();
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = scan.nextInt();
            Max = Math.max(arr[i], Max);
        }
    }

//    static void dijkstra(int start) {
//
//        for (int i = 1; i <= N; i++) dist[i] = Integer.MAX_VALUE;
//        PriorityQueue<Info> pq = new PriorityQueue<>(Comparator.comparingLong(o -> o.dist));
//        // 다른 방법) PriorityQueue<Info> pq = new PriorityQueue<>((o1, o2) -> o1.dist - o2.dist);
//        pq.add(new Info(start, 0));
//        dist[start] = 0;
//        while (!pq.isEmpty()) {
//            Info info = pq.poll();
//            if (info.dist != dist[info.idx]) continue;
//            // 꺼낸 정보가 최신 정보랑 다르면, 의미없이 낡은 정보이므로 폐기한다.
//            /* TODO */
//
//            // 연결된 모든 간선들을 통해서 다른 정점들에 대한 정보를 갱신해준다.
//            for (Edge e : edges[info.idx]) {
//                // e.to 까지 갈 수 있는 더 짧은 거리를 찾았다면 이에 대한 정보를 갱신하고 PQ에 기록해준다.
//                if (e.weight + info.dist < dist[e.to]) {
//                    dist[e.to] = e.weight + dist[info.idx];
//                    pq.add(new Info(e.to, dist[e.to]));
//                }
//                /* TODO */
//            }
//        }
//    }

    static void pro() {
        float sum = 0;
        for (int i = 0; i < N; i++) sum += arr[i] / (float)Max;
        sum = sum / N * 100;
        System.out.println(sum);
    }

    public static void main(String[] args) {
        input();
        pro();
    }


    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}