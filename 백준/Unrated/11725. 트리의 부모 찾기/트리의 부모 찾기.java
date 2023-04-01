import java.io.*;
import java.util.*;


public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[] parentArr;
    static List<Integer>[] list;


    static boolean[] visit;


    static void input() {

        N = scan.nextInt();
        visit = new boolean[N + 1];
        list = new List[N + 1];
        parentArr = new int[N + 1];

        for (int i = 1; i <= N; i++) list[i] = new ArrayList<>();
        for (int i = 1; i < N; i++) {
            int s = scan.nextInt();
            int e = scan.nextInt();
            list[s].add(e);
            list[e].add(s);
        }
    }

    static void bfs() {

        Queue<Integer> que = new LinkedList<>(); // parent, cur
        visit[1] = true;

        for (int i: list[1]) {
            que.add(1);
            que.add(i);
            visit[i] = true;
        }

        while (!que.isEmpty()) {

            int parent = que.poll();
            int child = que.poll();

            parentArr[child] = parent;
            for (int e: list[child]) {
                if (!visit[e]) {
                    visit[e] = true;
                    que.add(child);
                    que.add(e);
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

        bfs();
        for (int i = 2; i <= N; i++) sb.append(parentArr[i]).append('\n');
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
