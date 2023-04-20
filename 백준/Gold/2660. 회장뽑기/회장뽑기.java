import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int n, min;
    static ArrayList<Integer>[] Graph;
    static int[] Cnt;

    static void input() throws IOException {

        n = scan.nextInt();
        min = n;
        Graph = new ArrayList[n + 1];
        Cnt = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            Graph[i] = new ArrayList<>();
        }
        int v1 = scan.nextInt(), v2 = scan.nextInt();
        while (v1 != -1 && v2 != -1) {
            Graph[v1].add(v2);
            Graph[v2].add(v1);
            v1 = scan.nextInt();
            v2 = scan.nextInt();
        }

    }

    static void pro() {

        for (int i = 1; i <= n; i++) {
            bfs(i);
        }

        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (Cnt[i] == min) res.add(i);
        }
        sb.append(min).append(' ').append(res.size()).append('\n');
        Collections.sort(res);
        for (int i = 0; i < res.size(); i++) {
            sb.append(res.get(i)).append(' ');
        }
        System.out.println(sb);
    }

    static void bfs(int x) {

        Queue<int[]> que = new LinkedList<>();
        que.add(new int[] {x, -1, 0});
        int[] depth = new int[n + 1];

        while (!que.isEmpty()) {
            int[] cur = que.poll(); // cur, prev, depth
            if (depth[cur[0]] == 0 || depth[cur[0]] > cur[2]){
                depth[cur[0]] = cur[2];
            }

            for (int y: Graph[cur[0]]) {
                if (y == cur[1]) continue;
                if (depth[y] == 0 || depth[y] > (cur[2] + 1)){
                    que.add(new int[] {y, cur[0], cur[2] + 1});
                }
            }
        }
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            if (x == i) continue;
            hashSet.add(depth[i]);
        }
        Cnt[x] = hashSet.size();
        min = Math.min(min, Cnt[x]);
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