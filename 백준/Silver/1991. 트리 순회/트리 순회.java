import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int n;
    static ArrayList<Character>[] child;
    static int[] leaf;

    static void input() {

        n = scan.nextInt();
        child = new ArrayList[n];

        for (int i = 0; i < n; i++) child[i] = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int root = scan.next().charAt(0) - 'A';
            char child1 = scan.next().charAt(0);
            child[root].add(child1);
            char child2 = scan.next().charAt(0);
            child[root].add(child2);
        }

    }

    static void preOrder(int x) {

        sb.append((char) (x + 'A'));

        for (char y: child[x]) {
            if (y == '.') continue;
            preOrder(y - 'A');
        }
    }

    static void inOrder(int x) {
        if (child[x].isEmpty()) {
            sb.append((char)(x + 'A'));
        }else {
            if (child[x].get(0) != '.') inOrder(child[x].get(0) - 'A');
            sb.append((char) (x + 'A'));
            if (child[x].get(1) != '.') inOrder(child[x].get(1) - 'A');
        }
    }

    static void postOrder(int x) {

        for (int y: child[x]) {
            if (y == '.') continue;
            postOrder(y - 'A');
        }
        sb.append((char) (x + 'A'));
    }

    static void pro() {
        preOrder(0);
        sb.append('\n');
        inOrder(0);
        sb.append('\n');
        postOrder(0);
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