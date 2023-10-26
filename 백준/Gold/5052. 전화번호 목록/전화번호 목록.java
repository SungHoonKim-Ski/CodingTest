import java.io.*;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static Trie root;
    static boolean isCorrect;
    static class Trie{
        Trie[] child = new Trie[10];
        boolean isEnd = false;
        int childCnt = 0;
        void addChild(StringBuilder addStr) {

            if (addStr.length() == 0) {
                isEnd = true;
                if (childCnt != 0) isCorrect = false;
                return;
            }
            if (isEnd) {
                isCorrect = false;
                return;
            }
            int addData = addStr.charAt(addStr.length() - 1) - '0';
            addStr.setLength(addStr.length() - 1);
            // 기존 입력값을 한번 뒤집은 뒤에
            // 입력값을 뒤에서부터 하나씩 빼면서 트라이에 add
            if (child[addData] == null) {
                childCnt++;
                child[addData] = new Trie();
            }
            child[addData].addChild(addStr);
        }
    }

    static void input() throws IOException{
        isCorrect = true;
        root = new Trie();
    }

    static void pro() throws IOException{

        int n = Integer.parseInt(br.readLine());
        StringBuilder inputBuffer = new StringBuilder();
        while (n-- > 0) {
            inputBuffer.append(br.readLine());
            if (!isCorrect) continue;
            // 기존 입력값을 한번 뒤집은 뒤에
            inputBuffer.reverse();
            // 입력값을 뒤에서부터 하나씩 빼면서 트라이에 add
            root.addChild(inputBuffer);
            inputBuffer.setLength(0);

        }

        if (isCorrect) sb.append("YES");
        else sb.append("NO");
        sb.append('\n');
    }

    public static void main(String[] args) throws IOException{
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            input();
            pro();
        }
        System.out.println(sb);
    }


}