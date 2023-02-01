import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node{

    char data;
    Node left;
    Node right;
    public Node(char data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution {
    private final static int MAX_NODE = 100;
    private static Node[] node = new Node[MAX_NODE];
    static Node root;
    static StringBuffer sb;

    static void init(int length) {
        root = null;
        node[0] = null;
        for (int i=1; i<=length; i++) {
            node[i] = new Node('\n');
        }
        root = node[1];
    }

    static void new_node(int index, char data, Node left, Node right) {

        node[index].data = data;
        node[index].left = left;
        node[index].right = right;
    }

    final static void traversal_rec(Node node) {
        if (node == null) return;
        if (node.data == '\n') return;
        traversal_rec(node.left);
        sb.append(node.data);
        traversal_rec(node.right);
    }

    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        System.setIn(new FileInputStream("res/sample_input.txt"));
//        Scanner sc = new Scanner(System.in);
        int T = 10;
        for(int test_case = 1; test_case <= T; test_case++)
        {
            sb = new StringBuffer();
            sb.append('#').append(test_case).append(' ');
            int length = Integer.parseInt(br.readLine());
            init(length);
            for (int i=0; i<length; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                int index = Integer.parseInt(st.nextToken());
                char data = st.nextToken().charAt(0);
                Node left = null;
                Node right = null;
                if (st.hasMoreTokens()) left = node[Integer.parseInt(st.nextToken())];
                if (st.hasMoreTokens()) right = node[Integer.parseInt(st.nextToken())];
                new_node(index, data, left, right);
            }
            traversal_rec(root);
            System.out.println(sb);
        }
    }
}

