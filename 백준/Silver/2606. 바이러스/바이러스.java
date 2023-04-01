import java.io.*;
import java.util.*;


public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int V, E;
    static List<Integer>[] list;
    static boolean[] visit;

    static int res = 0;

    static void input() {

        V = scan.nextInt();
        E = scan.nextInt();
        visit = new boolean[V + 1];
        list = new List[V + 1];
        for (int i = 1; i <= V; i++) list[i] = new ArrayList<>();
        for (int i = 0; i < E; i++) {
            int s = scan.nextInt();
            int e = scan.nextInt();
            list[s].add(e);
            list[e].add(s);
        }
    }

    static int bfs() {

        int cnt = 0;
        Queue<Integer> que = new LinkedList<>();
        visit[1] = true;
        for (int v: list[1]) {
            que.add(v);
            visit[v] = true;
        }

        while (!que.isEmpty()) {
            int v =  que.poll();
            cnt++;
            for (int i: list[v]) {
                if (!visit[i]) {
                    que.add(i);
                    visit[i] = true;
                }
            }
        }
        return cnt;
    }

    static void dfs(int v) {
        visit[v] = true;
        for (int i: list[v]) {
            if (!visit[i]) {
                res++;
                dfs(i);
            }
        }
    }

    static void pro() {
//        System.out.println(bfs());
        dfs(1);
        System.out.println(res);
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
