import java.io.*;
import java.util.*;


public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M, goalX, goalY;
    static List<Integer>[] graph;
    static int[] dist;
    static void input() {

        N = scan.nextInt();
        graph = new List[N + 1];
        dist = new int[N + 1];
        
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();
        
        goalX = scan.nextInt();
        goalY = scan.nextInt();
        M = scan.nextInt();
        
        while (M-- > 0) {
            int s = scan.nextInt();
            int e = scan.nextInt();
            graph[s].add(e);
            graph[e].add(s);
        }
        
    }

    static void bfs(int s) {
        
        Queue<Integer> que = new LinkedList<>();
        que.add(s);
        dist[s] = 1;

        while (!que.isEmpty()) {

            int cur = que.poll();
            for (int i: graph[cur]) {
                if (dist[i] == 0) {
                    que.add(i);
                    dist[i] = dist[cur] + 1;
                }
            }
        }
    }

    static void pro() {

        bfs(goalX);
        System.out.println(dist[goalY] - 1);
    }

    public static void main(String[] args) {
        input();
        pro();
    }


    static class FastReader {
        // BufferedReader의 빠른 속도,
        // + Scanner의 타입별 입력값을 받는 기능을 혼합
        // (자바 내부에 구현된 Scanner는 속도가 느림)
        // 다른분의 코드를 참고한 코드
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
