import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, k, maxReadable;

    static String[] str;

    static void input() throws Exception {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        str = new String[n];
        for (int i = 0; i < n; i++) {
            str[i] = br.readLine();
        }
    }

    public static void pro() {
        for (int i = 0; i < n; i++) {
            str[i] = str[i].substring(4, str[i].length() - 4);
        }
        
        k -= 5;
        if (k < 0) {
            System.out.println(0);
            return;
        }
        
        HashSet<Character> set = new HashSet<>();
        set.add('a');
        set.add('n');
        set.add('t');
        set.add('i');
        set.add('c');
        
        backTrack(0, 0, set);
        System.out.println(maxReadable);
    }

    static void backTrack(int depth, int curIdx, HashSet<Character> studyChars) {
        if (depth >= k) {
            maxReadable = Math.max(maxReadable, readableCount((studyChars)));
            return;
        }

        for (int i = curIdx; i < 26; i++) {
            char c = (char) ('a' + i);
            if (studyChars.contains(c)) continue;
            studyChars.add(c);
            backTrack(depth + 1, i + 1, studyChars);
            studyChars.remove(c);
        }
    }

    public static int readableCount(HashSet<Character> studyChars) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            boolean isReadable = true;
            for (char c: str[i].toCharArray()) {
                if (!studyChars.contains(c)) {
                    isReadable = false;
                    break;
                }
            }
            if (isReadable) count++;
        }

        return count;
    }

    public static void main(String[] args) throws Exception{
        input();
        pro();
    }
}


