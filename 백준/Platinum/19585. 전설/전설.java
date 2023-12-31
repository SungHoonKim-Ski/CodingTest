import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer sb = new StringBuffer();
    static StringTokenizer st;
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
    static ColorTrie colorRoot;
    static HashSet<String> nameSet;

    static void input() throws IOException{
        
        colorRoot = new ColorTrie();
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

        while (q-- > 0) {

            ColorTrie colorTrie = colorRoot;
            boolean isCorrect = false;

            String teamName = br.readLine();
            char[] teamNameArr = teamName.toCharArray();
            int teamNameLength = teamNameArr.length;;

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