import java.io.*;
import java.util.*;


public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static List<Integer>[] list;

    static boolean[][] res;


    static void input() {

        N = scan.nextInt();
        list = new List[N];
        res = new boolean[N][N];

        for (int i = 0; i < N; i++) list[i] = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int e = scan.nextInt();
                if (e == 1) {
                    list[i].add(j);
                    res[i][j] = true;
                }
            }
        }
    }

    static void bfs(int start) {

        Queue<Integer> que = new LinkedList<>();
        boolean[] visit = new boolean[N];

        que.add(start);

        while (!que.isEmpty()) {
            int s = que.poll();
            for (int e: list[s]) {
                if (!visit[e]) {
                    que.add(e);
                    res[start][e] = true;
                    visit[e] = true;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            sb.append(res[start][i] ? 1 : 0).append(' ');
        }
        sb.append('\n');
    }

    static void pro() {

        for (int i = 0; i < N; i++)  bfs(i);

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
