import java.io.*;
import java.util.*;


public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int M, N, cnt = -1;
    static int MAX_VALUE = 101;
    static boolean[][] graph;
    static int[][] dist;

    static HashSet<Integer> hashSet;

    static void input() {

        N = scan.nextInt();
        M = scan.nextInt();
        graph = new boolean[MAX_VALUE][MAX_VALUE];
        dist = new int[MAX_VALUE][MAX_VALUE];

        hashSet = new HashSet<>();

        for (int i = 0; i < M; i++) {
            int s = scan.nextInt();
            int e = scan.nextInt();
            graph[s][e] = true;
            graph[e][s] = true;
            hashSet.add(s);
            hashSet.add(e);
        }
    }

    static void bfs(int start) {

        Queue<Integer> que = new LinkedList<>();
        dist[start][start] = 1;
        que.add(start);

        while (!que.isEmpty()) {
            int cur = que.poll();
            for (int i: hashSet) {
                if (graph[cur][i] && (dist[start][i] == 0)) {
                    que.add(i);
                    dist[start][i] = dist[start][cur] + 1;
                }
            }
        }
    }


    static void pro() {

        for (int i: hashSet){
            bfs(i);
        }

        int minVal = Integer.MAX_VALUE;
        int minIdx = 101;

        for (int i: hashSet) {
            int sum = 0;
            for (int j: hashSet) {
                sum += dist[i][j];
            }
            if (sum == 1) continue;
            if (sum < minVal) {
                minIdx = i;
                minVal = sum;
            }
        }
        System.out.println(minIdx);
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
