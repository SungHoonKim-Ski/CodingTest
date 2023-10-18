import java.io.*;
import java.util.*;

public class Main {

    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int n, maxWeight;
    static Tree[] trees;
    static ArrayList<Integer> weightList;

    static void input() throws IOException {

        n = Integer.parseInt(br.readLine());
        trees = new Tree[n + 1];
        for (int i = 1; i <= n; i++) {
            trees[i] = new Tree();
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            trees[parent].child.add(trees[child]);
            trees[child].weight = weight;

            weightList = new ArrayList<>();
        }

    }

    static void pro() {

        int maxDiameter = 0;
        ArrayList<Integer> weightSumList = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
//            if (trees[i].child.size() < 2) continue;
            // 자식이 없거나 1개인 경우 상위 노드 탐색에서 고려한 조건 범위 내에 들어간다

            for (Tree child : trees[i].child) {
                maxWeight = 0;
                dfs(child, 0);
                weightSumList.add(maxWeight);
            }
            if (weightSumList.size() == 0) continue;
            if (weightSumList.size() == 1) {
                maxDiameter = Math.max(weightSumList.get(0), maxDiameter);
            } else {
                weightSumList.sort(Collections.reverseOrder());
                maxDiameter = Math.max(weightSumList.get(0) + weightSumList.get(1), maxDiameter);
            }
            weightSumList.clear();
        }
        System.out.println(maxDiameter);
    }

    static void dfs(Tree tree, int weightSum) {

        int curWeight = weightSum + tree.weight;
        if (tree.child.size() == 0) {
            maxWeight = Math.max(curWeight , maxWeight);
        } else {
            for (Tree child : tree.child) {
                dfs(child, curWeight);
            }
        }
    }

    static class Tree {
        int weight;
        ArrayList<Tree> child;

        Tree() {
            child = new ArrayList<>();
        }
    }

    public static void main(String[] args)  throws IOException{
        input();
        pro();
    }
}
