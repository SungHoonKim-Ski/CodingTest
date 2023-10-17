import java.util.*;
import java.io.*;

public class Main {

    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer sb = new StringBuffer();

    static int k, n, treeCnt = 1;
    static int[] arr;
    static Tree[] trees;

    public static void input() throws IOException{
       k = Integer.parseInt(br.readLine());
       n = (int) (Math.pow(2, k));
       arr = new int[n];
       trees = new Tree[n];
       for (int i = 1; i < n; i++) trees[i] = new Tree();
    }
    public static void pro() throws IOException {

        st = new StringTokenizer(br.readLine());
        addTree(trees[1], 1);

        ArrayDeque<Tree> que = new ArrayDeque<>();
        que.add(trees[1]);
        int curDepth = 1;
        while (!que.isEmpty()) {
            Tree curTree = que.poll();
            if (curDepth != curTree.depth) {
                curDepth = curTree.depth;
                sb.append('\n');
            }
            sb.append(curTree.data).append(' ');
            for (Tree child : curTree.child) {
                que.add(child);
            }
        }
        System.out.println(sb);
    }

    static void addTree(Tree tree, int depth) {

        if (depth == k) {
            tree.depth = depth;
            tree.data = Integer.parseInt(st.nextToken());
            return;
        }
        tree.child.add(trees[++treeCnt]);
        tree.child.add(trees[++treeCnt]);

        addTree(tree.child.get(0), depth + 1);
        tree.data = Integer.parseInt(st.nextToken());
        tree.depth = depth;
        addTree(tree.child.get(1), depth + 1);
    }

    static class Tree{

        int data, depth;
        ArrayList<Tree> child;
        Tree() {
            child = new ArrayList<>();
        }
    }

    public static void main(String[] args) throws IOException{
        input();
        pro();
    }

}
