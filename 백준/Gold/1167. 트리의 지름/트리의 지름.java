import java.io.*;
import java.util.*;

public class Main {

    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int n;
    static Tree[] trees;

    static Tree curTree;
    static long curMaxWeight, maxWeight;

    static boolean[] visit;

    static void input() throws IOException {

        n = Integer.parseInt(br.readLine());
        trees = new Tree[n + 1];
        for (int i = 1; i <= n; i++) {
            trees[i] = new Tree(i);
        }

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int cur = Integer.parseInt(st.nextToken());
            while (st.hasMoreTokens()) {
                int child = Integer.parseInt(st.nextToken());
                if (child == -1) break;
                int weight = Integer.parseInt(st.nextToken());
                trees[cur].child.add(trees[child]);
                trees[cur].childWeight.add(weight);
            }
        }

    }

    static void pro() {

        visit = new boolean[n + 1];
        visit[1] = true;
        dfs(trees[1], 0);

        curMaxWeight = 0;
        visit = new boolean[n + 1];
        visit[curTree.index] = true;
        dfs(curTree, 0);
        System.out.println(curMaxWeight);
    }

    static void dfs(Tree tree, long weightSum) {

        if (curMaxWeight < weightSum) {
            curTree = tree;
            curMaxWeight = weightSum;
        }
        ArrayList<Integer> childWeightList = tree.childWeight;

        for (int i = 0; i < tree.child.size(); i++) {
            Tree child = tree.child.get(i);

            if (visit[child.index]) continue;

            int childWeight = childWeightList.get(i);
            visit[child.index] = true;
            dfs(child, weightSum + childWeight);
            visit[child.index] = false;
        }
    }

    static class Tree {
        int index;
        ArrayList<Tree> child;
        ArrayList<Integer> childWeight;

        Tree(int _index) {
            child = new ArrayList<>();
            childWeight = new ArrayList<>();
            index = _index;
        }
    }

    public static void main(String[] args)  throws IOException{
        input();
        pro();
    }
}
