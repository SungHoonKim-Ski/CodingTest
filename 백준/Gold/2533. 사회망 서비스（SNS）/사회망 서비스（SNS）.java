import java.io.*;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static Tree[] trees;

    static boolean[] visit;

    static class Tree{
        int[] dp;
        int idx;
        ArrayList<Integer> child;
        Tree(int _idx) {
            dp = new int[2];
            child = new ArrayList<>();
            idx = _idx;
        }
    }
    static void input() throws IOException{

        n = Integer.parseInt(br.readLine());
        visit = new boolean[n + 1];
        trees = new Tree[n + 1];

        for (int i = 1; i <= n; i++) {
            trees[i] = new Tree(i);
        }

        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            trees[s].child.add(e);
            trees[e].child.add(s);
        }
    }
    static void pro(){
        dfs(trees[1]);
        System.out.println(Math.min(trees[1].dp[0], trees[1].dp[1]));
    }

    static void dfs(Tree curTree) {

        int curIdx = curTree.idx;
        visit[curIdx] = true;
        curTree.dp[0] = 0;
        curTree.dp[1] = 1;
        for (int childIdx : curTree.child) {
            if (visit[childIdx]) continue;
            dfs(trees[childIdx]);
            curTree.dp[0] += trees[childIdx].dp[1];
            curTree.dp[1] += Math.min(trees[childIdx].dp[1], trees[childIdx].dp[0]);
        }

    }

    public static void main(String[] args) throws IOException{
        input();
        pro();
    }
}


