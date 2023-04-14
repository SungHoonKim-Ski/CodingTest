import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int n, v1, v2;
    static Tree[] trees;

    static class Tree{
        int depth = 0, idx = 0;
        List<Tree> child;
        Tree parent;
        Tree() {
            child = new ArrayList<>();
        }
    }
    static void input() {

        n = scan.nextInt();
        trees = new Tree[n + 1];
        for (int i = 1; i <= n; i++) {
            trees[i] = new Tree();
            trees[i].idx = i;
        }
        for (int i = 1; i < n; i++) {
            int v1 = scan.nextInt();
            int v2 = scan.nextInt();
            trees[v1].child.add(trees[v2]);
            trees[v2].parent = trees[v1];
        }

        v1 = scan.nextInt();
        v2 = scan.nextInt();
    }

    static void lcs() {

        Tree v1Tree = trees[v1];
        Tree v2Tree = trees[v2];
        if (v1Tree.depth > v2Tree.depth) {
            while (v1Tree.depth != v2Tree.depth) {
                v1Tree = v1Tree.parent;
            }
        }else if (v1Tree.depth < v2Tree.depth) {
            while (v1Tree.depth != v2Tree.depth) {
                v2Tree = v2Tree.parent;
            }
        }
        while (v1Tree != v2Tree) {
            v1Tree = v1Tree.parent;
            v2Tree = v2Tree.parent;
        }
        System.out.println(v1Tree.idx);
    }

    static void calDepth(Tree tree, int depth) {

        tree.depth = depth;
        for (Tree t: tree.child) {
            calDepth(t, depth + 1);
        }
    }

    static void pro() {

        Tree tree = trees[1];
        while (tree.parent != null) tree = tree.parent;
        calDepth(tree, 0);
        lcs();
    }

    public static void main(String[] args) {

        for (int i = scan.nextInt(); i > 0; i--) {
            input();
            pro();
        }
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