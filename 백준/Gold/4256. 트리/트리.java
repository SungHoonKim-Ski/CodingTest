import java.io.*;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, curIdx;
    static int[] preOrderArr, inorderArr;

    static Tree root;

    static class Tree{
        int data, childCnt;
        Tree left, right;
        Tree(int _data) {data = _data;}
    }
    static void input() throws IOException{
        n = Integer.parseInt(br.readLine());
        preOrderArr = new int[n];
        inorderArr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) preOrderArr[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) inorderArr[i] = Integer.parseInt(st.nextToken());

        curIdx = 0;
    }

    static void pro(){
        root = addTree(0, 0, n - 1);
        postOrder(root);
        sb.append('\n');
    }

    static void postOrder(Tree tree) {
        if (tree.left != null) postOrder(tree.left);
        if (tree.right != null) postOrder(tree.right);
        sb.append(tree.data).append(' ');
    }

    static Tree addTree(int left, int rootIdx, int right) {

        if (rootIdx == n) return null;

        int curData = preOrderArr[rootIdx];
        Tree tree = new Tree(curData);

        int mid = -1;
        for (int i = left; i <= right; i++) {
            if (curData == inorderArr[i]) {
                mid = i;
                break;
            }
        }

        if (mid == -1) return null; // 범위 내에서 찾지 못하는 경우 존재

        tree.left = addTree(left, rootIdx + 1, mid);
        int leftCnt = 0;
        if (tree.left != null) {
            tree.childCnt += tree.left.childCnt + 1;
            leftCnt = tree.childCnt;
        }
        tree.right = addTree(mid + 1, rootIdx + leftCnt + 1,  right);
        if (tree.right != null) tree.childCnt += tree.right.childCnt + 1;
        return tree;
    }

    public static void main(String[] args) throws IOException{
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            input();
            pro();
        }
        System.out.println(sb);
    }


}