import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.FileInputStream;

class Node{

    int data;
    Node left;
    Node right;
    public Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution {

    private final static int MAX_NODE = 10001;
    private static Node[] node = new Node[MAX_NODE];
    static Node root;
    static List<Integer> DataAParentList, DataBParentList;
    static StringBuffer sb;
    static boolean flag;

    static void init(int length) {
        root = null;
        node[0] = null;
        for (int i=1; i<=length; i++) {
            node[i] = new Node(-1);
        }
        root = node[1];
    }

    static void new_node(int index, int child) {

        if (node[index].data == -1) node[index].data = index;
        if (node[index].left == null) {
            node[index].left = node[child];
        }
        else {
            node[index].right = node[child];
        }
        node[child].data = child;
    }

    static void traversal_rec(Node node, List<Integer> dataList, int target) {
        if (node == null || node.data == -1) {
            return;
        }
        if (!flag) dataList.add(node.data);
        else return;
        if (node.data == target) {
            flag = true;
            return;
        }
        traversal_rec(node.left, dataList, target);
        traversal_rec(node.right, dataList, target);
        if (!flag) dataList.remove((Object)node.data);
    }

    static int countChild(Node node, int data, int flag) {

        if (node == null || node.data == -1) {
            return 0;
        }
        int res = 0;
        if (node.data == data) {
            flag = 1;
        }
        if (flag == 1) {
            res = 1;
        }
        res += countChild(node.left, data, flag) + countChild(node.right, data, flag);

        return res;
    }


    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++)
        {
            sb = new StringBuffer();
            int V = sc.nextInt();
            int E = sc.nextInt();
            int dataA = sc.nextInt();
            int dataB = sc.nextInt();

            init(V);
            for (int i=0; i<E; i++) {
                new_node(sc.nextInt(), sc.nextInt());
            }
            DataAParentList = new ArrayList<>();
            DataBParentList = new ArrayList<>();
            flag = false;
            traversal_rec(root, DataAParentList, dataA);
            flag = false;
            traversal_rec(root, DataBParentList, dataB);

            int max = 0;
            for (int i=0; i<DataAParentList.size(); i++) {
                if (DataBParentList.contains(DataAParentList.get(i))) max = DataAParentList.get(i);
            }
            flag = false;
            sb.append(String.format("#%d %d %d", test_case, max, countChild(root, max, 0)));
            System.out.println(sb);
        }
    }
}

