import java.io.*;
import java.util.*;


public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, K;

    static int MAX_VALUE = 100000;

    static int[] dist;
    static boolean[] visit;
    static void input() {

        N = scan.nextInt();
        K = scan.nextInt();
        dist = new int[MAX_VALUE + 1];
        visit = new boolean[MAX_VALUE + 1];
    }

    static void bfs(int s) {
        

        Queue<Integer> que = new LinkedList<>();
        que.add(s);
        dist[s] = 0;
        visit[s] = true;

        while (!que.isEmpty()) {

            int cur = que.poll();
            int nx = cur + 1;
            int ny = cur - 1;
            int nz = cur * 2;
            if (nx <= MAX_VALUE && !visit[nx]) {
                que.add(nx);
                visit[nx] = true;
                dist[nx] = dist[cur] + 1;
            }
            if (ny >= 0 && !visit[ny]) {
                que.add(ny);
                visit[ny] = true;
                dist[ny] = dist[cur] + 1;
            }
            if (nz <= MAX_VALUE && !visit[nz]) {
                que.add(nz);
                visit[nz] = true;
                dist[nz] = dist[cur] + 1;
            }
        }
    }

    static void pro() {

        bfs(N);
        System.out.println(dist[K]);
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
