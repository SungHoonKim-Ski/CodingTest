import java.io.*;
import java.util.*;

public class Main {

    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int n, max;
    static Tree[] trees;
    static int[] indeg;

    static boolean[] visit;

    static void input() throws IOException {

        n = Integer.parseInt(br.readLine());
        indeg = new int[n + 1];
        trees = new Tree[n + 1];
        for (int i = 1; i <= n; i++) {
            trees[i] = new Tree(i);
        }

        for (int i = 2; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            char cmd = st.nextToken().charAt(0);
            if (cmd == 'S') { // 양
                int sheep = Integer.parseInt(st.nextToken());
                trees[i].sheep = sheep;
            } else {
                int wolf = Integer.parseInt(st.nextToken());
                trees[i].wolf = wolf;
            }
            int parent = Integer.parseInt(st.nextToken());
            trees[i].parent = trees[parent];
            indeg[parent]++;
        }

    }

    static void pro() {

        Deque<Tree> que = new ArrayDeque<>();
        // 현재 좌표, 양의 수를 담은 int[2] que
        long result = 0;
        for (int i = 2; i <= n; i++) {
            if (indeg[i] == 0) que.add(trees[i]);
        }

        while (!que.isEmpty()) {

            Tree curTree = que.poll();
            if (curTree.index == 1) break;

            indeg[curTree.parent.index]--; // 부모의 간선 수 제거

            if (curTree.wolf < curTree.sheep) {
                curTree.sheep -= curTree.wolf;;
                curTree.wolf = 0;
            } else curTree.sheep = 0;

            if (indeg[curTree.parent.index] == 0) que.add(curTree.parent); // 부모에게 더이상 연결된 간선이 없다면, que에 추가
            if (curTree.sheep == 0) continue; // 현재 트리가 양이 없을 경우 고려할 필요 x
            curTree.parent.sheep += curTree.sheep;
        }

        System.out.println(trees[1].sheep);

    }

    static class Tree {

        Tree parent;
        int index;
        long sheep, wolf;

        Tree(int _index) {
            index = _index;
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
