import java.io.*;
import java.util.*;


public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static List<Integer>[] list;

    static int[][] res;


    static void input() {

        N = scan.nextInt();
        list = new List[N];
        res = new int[N][N];

        for (int i = 0; i < N; i++) list[i] = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int e = scan.nextInt();
                if (e == 1) {
                    list[i].add(j);
                    res[i][j] = 1;
                }
            }
        }
    }

    static void bfs(int s, int e) {

        Queue<Integer> que = new LinkedList<>();
        boolean[] visit = new boolean[N];
        visit[e] = true;

        que.add(e);

        while (!que.isEmpty()) {
            int v = que.poll();
            for (int i: list[v]) {
                if (!visit[i]) {
                    que.add(i);
                    res[s][i] = 1;
                    visit[i] = true;
                }
            }
        }
    }

//    static void dfs(int v) {
//        visit[v] = true;
//        for (int i: list[v]) {
//            if (!visit[i]) {
//                res++;
//                dfs(i);
//            }
//        }
//    }

    static void pro() {
        for (int i = 0; i < N; i++) {
            for (int j: list[i]) {
                bfs(i, j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(res[i][j]).append(' ');
            }
            sb.append('\n');
        }

        System.out.println(sb);
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
