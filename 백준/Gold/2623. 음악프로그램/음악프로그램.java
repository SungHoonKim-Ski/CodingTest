import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static int[] indeg;
    static ArrayList<Integer>[] adj;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        adj = new ArrayList[N + 1];
        indeg = new int[N + 1];
        for (int i = 1; i <= N; i++) adj[i] = new ArrayList<>();
        while (M-- > 0) {
            int cnt = scan.nextInt();
            int s = scan.nextInt();
            for (int i = 1; i < cnt; i++) {
                int e = scan.nextInt();
                adj[s].add(e);
                indeg[e]++;
                s = e;
            }

        }
    }

    static void pro() {
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) if (indeg[i] == 0) queue.add(i);
        while (!queue.isEmpty()) {

            int cur = queue.poll();
            sb.append(cur).append('\n');
            for (int v: adj[cur]) {
                indeg[v]--;
                if (indeg[v] == 0) queue.add(v);
            }
        }
        for (int i = 1; i <= N; i++) {
            if (indeg[i] != 0) {
                System.out.println(0);
                return;
            }
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
