import java.io.*;
import java.lang.reflect.Array;
import java.util.*;


class A {
    int a;
    A(int a) {
        this.a = a;
    }
}

class B{
    int b;
    B(int b) {
        this.b = b;
    }
}


public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int n, R, Q;
    static ArrayList<Integer>[] tree;

    static int[] Dy;

    static void input() throws IOException {
        n = scan.nextInt();
        R = scan.nextInt();
        Q = scan.nextInt();
        tree = new ArrayList[n + 1];
        Dy = new int[n + 1];
        for (int i = 1; i <= n; i++) tree[i] = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            int v1 = scan.nextInt();
            int v2 = scan.nextInt();
            tree[v1].add(v2);
            tree[v2].add(v1);
        }
    }

    static void dfs(int x, int prev) {

        Dy[x] = 1;
        for (int t: tree[x]) {
            if (t == prev) continue;
            dfs(t, x);
            Dy[x] += Dy[t];
        }
    }

    static void pro() {

        dfs(R, -1);

        while (Q-- > 0) sb.append(Dy[scan.nextInt()]).append('\n');
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