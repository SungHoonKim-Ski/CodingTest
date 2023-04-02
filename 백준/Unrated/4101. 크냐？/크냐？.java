import java.io.*;
import java.util.*;


public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int A, B;
    static int[] parentArr;
    static List<Integer>[] list;


    static boolean[] visit;


    static void input() {
        A = scan.nextInt();
        B = scan.nextInt();
    }

    static void bfs() {

        Queue<Integer> que = new LinkedList<>(); // parent, cur
        visit[1] = true;
        que.add(1);

        while (!que.isEmpty()) {

            int parent = que.poll();
            for (int child: list[parent]) {
                if (!visit[child]) {
                    visit[child] = true;
                    parentArr[child] = parent;
                    que.add(child);
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

        sb.append(A > B ? "Yes" : "No").append('\n');
    }

    public static void main(String[] args) {

        while (true) {
            input();
            if (A == 0 && B == 0) break;
            pro();
        }
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
