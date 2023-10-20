import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer sb = new StringBuffer();
    static StringTokenizer st;

    static int n;
    static Tree root;

    static void input() throws IOException{
        n = Integer.parseInt(br.readLine());
        root = new Tree(" ");
    }

    static void pro() throws IOException{
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            Tree cur = root;
            while (cnt-- > 0) {
                String s = st.nextToken();
                if (!cur.child.containsKey(s)) {
                    cur.child.put(s, new Tree(s));
                }
                cur.childSet.add(s);
                cur = cur.child.get(s);
            }
        }

        dfs(root, 0);
        System.out.println(sb);
    }

    static void dfs(Tree cur, int depth) {
        if (depth != 0) {
            for (int i = 1; i < depth; i++) {
                sb.append('-').append('-');
            }
            sb.append(cur.data).append('\n');
        }
        for (String child : cur.childSet) {
            dfs(cur.child.get(child), depth + 1);
        }
    }

    static class Tree{

        String data;
        TreeSet<String> childSet;
        HashMap<String, Tree> child;
        Tree(String _data) {
            child = new HashMap<>();
            childSet = new TreeSet<>();
            data = _data;
        }
    }

    public static void main(String[] args) throws IOException{
        input();
        pro();
        System.out.println();
    }

}
