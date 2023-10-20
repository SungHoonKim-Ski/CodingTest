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

        for (int i = 0; i < n; i++) { // 트리를 만드는 부분
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            Tree cur = root;
            while (cnt-- > 0) {
                String s = st.nextToken();

                // 해당하는 자식 노드가 없다면 새로 만들어준다
                if (!cur.child.containsKey(s)) {
                    cur.child.put(s, new Tree(s));
                }

                // 이후 현재 노드에 자식 데이터들을
                // 나중에 정렬된 순서대로 부르기 위해 TreeSet에 저장한다
                cur.childSet.add(s);

                //이후 자식 노드에서 위 과정을 반복한다
                cur = cur.child.get(s);
            }
        }
    }

    static void pro() throws IOException{

        dfs(root, 0);
        System.out.println(sb);
    }

    static void dfs(Tree cur, int depth) {

        for (int i = 1; i < depth; i++) { // 출력 조건에 따라 출력하며 DFS 탐색
            sb.append('-').append('-');
        }

        // 루트 노드는 시작점이고, 쓰레기 값을 가지고 있으므로 제외하고 출력
        if (depth != 0) sb.append(cur.data).append('\n'); 

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
    }

}
