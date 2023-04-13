import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int n, q;
    static int[] goal;
    static boolean[] visit;
    static void input() {

        n = scan.nextInt();
        q = scan.nextInt();
        visit = new boolean[n + 1];
        goal = new int[q];
        for (int i = 0; i < q; i++) {
            goal[i] = scan.nextInt();
        }
    }

    static void dfs(int cur, int lastVisit ,int goal) {

        if (cur == 1) {
            if (lastVisit == 0) {
                visit[goal] = true;
                sb.append(0).append('\n');
            }else {
                sb.append(lastVisit).append('\n');
            }
            return;
        }

        if (visit[cur]) {
            lastVisit = cur;
        }
        dfs(cur / 2, lastVisit, goal);
    }

    static void pro() {
        for (int i = 0; i < q; i++) {
            dfs(goal[i], 0, goal[i]);
        }
    }

    public static void main(String[] args) {
        input();
        pro();
        System.out.println(sb);
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