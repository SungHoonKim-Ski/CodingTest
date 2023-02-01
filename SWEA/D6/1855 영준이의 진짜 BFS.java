import java.util.*;

public class Solution {

    static Node[] nodes;
    static int[][] parentArr;
    static int MAX_LEVEL = 18;

    static class Node {

        int parent, depth;
        List<Integer> child = new ArrayList<>();

        private Node(int parent, int depth) {
            this.parent = parent;
            this.depth = depth;
        }
    }

    public static void main(String[] args) {

        int Root;
        int CurNode;
        int N;
        nodes = new Node[100001];
        parentArr = new int[100001][MAX_LEVEL+1];
        Queue<Integer> queue = new LinkedList<>();

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            N = sc.nextInt();
            nodes[1] = new Node( 0, 0);
            Root = 1;

            for (int i=2; i<=N; i++) {
                int parent = sc.nextInt();
                nodes[i] = new Node(i, nodes[parent].depth+1);
                nodes[parent].child.add(i);
                parentArr[i][0] = parent;
            }

            for (int n=2; n<=N; n++) {
                for (int i=1; i<= MAX_LEVEL; i++) {
                    parentArr[n][i] = parentArr[parentArr[n][i - 1]][i-1];
                }
            }

            long count = 0;
            CurNode = 1;
            queue.add(Root);
            while (!queue.isEmpty()) { // BFS와 순회 같이 진행
                int targetNode = queue.poll();
                for (int i=0; i<nodes[targetNode].child.size(); i++) {
                    queue.add(nodes[targetNode].child.get(i));
                }
                if (targetNode == 1) continue;

                int commonParent = LCA(CurNode, targetNode);
                count += nodes[CurNode].depth + nodes[targetNode].depth - nodes[commonParent].depth * 2L;
                CurNode = targetNode;
            }
            System.out.printf("#%d %d\n", test_case, count);
        }
    }

    static int LCA(int curNode, int targetNode) {

        int depthA = nodes[curNode].depth;
        int depthB = nodes[targetNode].depth;

        int depthGap;
        if (depthA < depthB) {
            int temp = curNode;
            curNode = targetNode;
            targetNode = temp;
            depthGap = depthB - depthA;
        } else {
            depthGap = depthA - depthB;
        }

        for (int ancestor = MAX_LEVEL; ancestor >= 0; ancestor--) {
            if ((1 << ancestor) <= depthGap) {
                curNode = parentArr[curNode][ancestor];
            }
        }

        if (curNode == targetNode) {
            return curNode;
        }

        for (int ancestor = MAX_LEVEL; ancestor >= 0; ancestor--) {
            if (parentArr[curNode][ancestor] != parentArr[targetNode][ancestor]) {
                curNode = parentArr[curNode][ancestor];
                targetNode = parentArr[targetNode][ancestor];
            }
        }

        return parentArr[curNode][0];
    }
}