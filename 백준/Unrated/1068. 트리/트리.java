import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int n, cnt = 0, removeIdx;
    static ArrayList<Integer>[] adj;
    static int[] parent;
    static int root;

    static void input() {

        n = scan.nextInt();
        parent = new int[n];
        adj = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            int node = scan.nextInt();
            if (node == -1) {
                root = i;
                continue;
            }
            adj[node].add(i);
        }
        removeIdx = scan.nextInt();
    }

    static void dfs(int x) {

        for (int y: adj[x]) {
            if (adj[y].size() == 0) {
                cnt++;
                continue;
            }
            dfs(y);
        }
    }

    static void remove(int x, int target) {

        for (int i = 0; i < adj[x].size(); i++) {
            if (adj[x].get(i) == target) {
                adj[x].remove(i);
                return;
            }
            remove(adj[x].get(i), target);
        }
    }



    static void pro() {

        if (removeIdx != root) {
            remove(root, removeIdx);
            if (adj[root].size() == 0) cnt = 1;
            else dfs(root);
        }

        System.out.println(cnt);
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