import java.io.*;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static Tree root, needUpdateTree;
    static int n;
    static int[] inputArr;
    static class Tree{
        int data;
        Tree left, right;
        Tree(int _data) {
            data = _data;
        }
    }

    static void input() throws IOException{
        n = Integer.parseInt(br.readLine());
        inputArr = new int[n];
        st = new StringTokenizer(br.readLine());
        int idx = 0;
        int updateIdx = -1;
        while (st.hasMoreTokens()) {
            inputArr[idx] = Integer.parseInt(st.nextToken());
            if (inputArr[idx] == -1) updateIdx = idx;
            idx++;
        }
        inputArr[updateIdx] = Integer.parseInt(br.readLine());
    }

    static void pro() {

        Arrays.sort(inputArr);
        makeTree(inputArr);
        postOrder(root);
        System.out.println(sb);
    }

    static void postOrder(Tree tree) {
        if (tree.left == null) {
            sb.append(tree.data).append(' ');
        } else {
            postOrder(tree.left);
            postOrder(tree.right);
            sb.append(tree.data).append(' ');
        }
    }

    static void makeTree(int[] arr) {
        root = makeTree(arr, 0, n - 1);
    }

    static Tree makeTree(int[] arr, int start, int end) {
        if (start > end) return null;

        int mid = (start + end) / 2;
        Tree tree = new Tree(arr[mid]);
        tree.left = makeTree(arr, start, mid - 1);
        tree.right = makeTree(arr, mid + 1, end);
        return tree;
    }


    public static void main(String[] args) throws IOException{
        input();
        pro();
    }


}