import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

class Node{

    String data;
    Node left;
    Node right;
    public Node(String data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution {
    private final static int MAX_NODE = 1000;
    private static Node[] node = new Node[MAX_NODE];
    static Node root;

    static HashSet<Character> operatorSet;
    static StringBuffer sb;

    static void init(int length) {
        root = null;
        node[0] = null;
        for (int i=1; i<=length; i++) {
            node[i] = new Node("-1");
        }
        root = node[1];
    }

    static void new_node(int index, String data, Node left, Node right) {

        node[index].data = data;
        node[index].left = left;
        node[index].right = right;
    }

    static double traversal_rec(Node node) {

        if (operatorSet.contains(node.data.charAt(0))) {
            switch (node.data.charAt(0)) {
                case '+':
                    return traversal_rec(node.left) + traversal_rec(node.right);
                case '-':
                    return traversal_rec(node.left) - traversal_rec(node.right);
                case '*':
                    return traversal_rec(node.left) * traversal_rec(node.right);
                case '/':
                    return traversal_rec(node.left) / traversal_rec(node.right);
            }
        }
        return Double.parseDouble(node.data);
    }

//    static double cal_tree(String operation) {
//        int cur = 0;
//        double res;
//        for (int i=1; i<operation.length(); i++) {
//            String tmp = "";
//            while (operation.charAt(cur) >= 48) {
//                tmp += operation.charAt(i);
//            }
//
//
//
//        }
//
//    }

    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        System.setIn(new FileInputStream("res/sample_input.txt"));
//        Scanner sc = new Scanner(System.in);
        int T = 10;
        operatorSet = new HashSet<>();
        operatorSet.add('+');
        operatorSet.add('-');
        operatorSet.add('*');
        operatorSet.add('/');
        for(int test_case = 1; test_case <= T; test_case++)
        {
            sb = new StringBuffer();
            int length = Integer.parseInt(br.readLine());
            init(length);
            for (int i=0; i<length; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                int index = Integer.parseInt(st.nextToken());
                String data = st.nextToken();
                Node left = null;
                Node right = null;
                if (st.hasMoreTokens()) left = node[Integer.parseInt(st.nextToken())];
                if (st.hasMoreTokens()) right = node[Integer.parseInt(st.nextToken())];
                new_node(index, data, left, right);
            }
            sb.append(String.format("#%d ", test_case));
            sb.append((int)traversal_rec(root));
            System.out.println(sb);
        }
    }
}

