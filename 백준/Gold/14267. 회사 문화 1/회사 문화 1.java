import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int n, m, root;
    static ArrayList<Integer>[] Tree;
    static int[] Cnt;

    static void input() throws IOException {

        n = scan.nextInt();
        m = scan.nextInt();
        Tree = new ArrayList[n + 1];
        Cnt = new int[n + 1];
        for (int i = 1; i<= n; i++) Tree[i] = new ArrayList<>();

        scan.nextInt();
        for (int i = 2; i <= n; i++) {
            int v = scan.nextInt();
            Tree[v].add(i);
        }
        for (int i = 0; i < m; i++) {
            int v = scan.nextInt();
            int cnt = scan.nextInt();
            Cnt[v] += cnt;
        }
    }

    static void dfs(int x) {
        for (int y: Tree[x]) {
            Cnt[y] += Cnt[x];
            dfs(y);
        }
    }

    static void pro() {

        for (int t: Tree[1]) dfs(t);
        for (int i = 1; i <= n; i++) sb.append(Cnt[i]).append(' ');
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
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