import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer sb = new StringBuffer();
    static StringTokenizer st;
    static final int MOD_VAL = 1_000_007;
    static class ColorTrie {
        ColorTrie[] next;
        boolean isLast;
        ColorTrie() {
            next = new ColorTrie['z' - 'a' + 1];
            isLast = false;
        }

        void add(char[] str, ColorTrie root) {

            ColorTrie trie = root;

            for (int i = 0; i < str.length; i++) {
                if (trie.next[str[i] - 'a'] == null) {
                    trie.next[str[i] - 'a'] = new ColorTrie();
                }
                trie = trie.next[str[i] - 'a'];
            }
            trie.isLast = true;
        }
    }

    static class NameTrie {
        NameTrie[] next;
        boolean isLast;
        NameTrie() {
            next = new NameTrie['z' - 'a' + 1];
            isLast = false;
        }

        void addRev(char[] str, int idx) {
            if (str.length - 1 == idx) {
                isLast = true;
            } else {
                if (next[str[str.length - idx - 1] - 'a'] == null) {
                    next[str[str.length - idx - 1] - 'a'] = new NameTrie();
                }
                next[str[str.length - idx - 1] - 'a'].addRev(str, idx + 1);
            }
        }
    }
    static ColorTrie colorRoot;
    static NameTrie nameRoot;
    static HashSet<String> nameSet;

    static void input() throws IOException{
        colorRoot = new ColorTrie();
        nameRoot = new NameTrie();
        nameSet = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        while (c-- > 0) {
            colorRoot.add(br.readLine().toCharArray(), colorRoot);
        }

        while (n-- > 0) {
//            nameRoot.addRev(br.readLine().toCharArray(), 0);
            nameSet.add(br.readLine());
        }
    }

    static void pro() throws IOException{

        int q = Integer.parseInt(br.readLine());
//        HashSet<Integer> colorLengthSet = new HashSet<>();
//        HashSet<Integer> nameLengthSet = new HashSet<>();

        while (q-- > 0) {

            ColorTrie colorTrie = colorRoot;
//            NameTrie nameTrie = nameRoot;
            boolean isCorrect = false;

            String teamName = br.readLine();
            char[] teamNameArr = teamName.toCharArray();
            int teamNameLength = teamNameArr.length;;

//            int index = 0;

            for (int i = 0; i < teamNameLength; i++) {
                colorTrie = colorTrie.next[teamNameArr[i] - 'a'];

                if (colorTrie == null) break;

                if (colorTrie.isLast) {
                    if (nameSet.contains(teamName.substring(i + 1))) {
                        isCorrect = true;
                        break;
                    }
                }
            }

//
//            while (colorTrie != null) {
//
//                if (index == teamNameLength) break;
//
//                if (colorTrie.isLast) {
//                    colorLengthSet.add(index + 1);
//                    if (nameLengthSet.contains(teamNameLength - index + 1)) {
//                        isCorrect = true;
//                        break;
//                    }
//                }
//
//                colorTrie = colorTrie.next[teamNameArr[index] - 'a'];
//                index++;
//            }

//
//            index = 0;
//            while (nameTrie != null) {
//                if (index == teamNameArr.length) break;
//                if (nameTrie.isLast) {
//                    nameLengthSet.add(index + 1);
//                    if (colorLengthSet.contains(teamNameLength - index - 1)) {
//                        isCorrect = true;
//                        break;
//                    }
//                }
//                nameTrie = nameTrie.next[teamNameArr[teamNameLength - index - 1] - 'a'];
//                index++;
//            }

            if (!isCorrect) sb.append("No");
            else sb.append("Yes");
            sb.append('\n');
        }
        System.out.println(sb);
    }


    public static void main(String[] args) throws IOException{
        input();
        pro();

    }

}