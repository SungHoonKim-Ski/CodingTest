import java.util.*;
import java.io.*;


public class Main
{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n;
    static char[][] inputCharArr;
    static Trie root;

    static class Trie{

        Trie[] next;
        int childCnt;

        boolean isLast;

        public Trie() {
            this.next = new Trie[26];
            this.childCnt = 0;
            isLast = false;
        }

    }


    public static void input() throws IOException{

        root = new Trie();
        inputCharArr = new char[n][];
        for (int i = 0; i < n; i++) {
            inputCharArr[i] = br.readLine().toCharArray();
            insert(inputCharArr[i]);
        }
    }
    public static void insert(char[] cArr) {

        Trie cursor = root;
        for (int i = 0; i < cArr.length; i++) {
            int idx = cArr[i] - 'a';
            if (cursor.next[idx] == null) {
                cursor.childCnt++;
                cursor.next[idx] = new Trie();
            }
            cursor = cursor.next[idx];
        }
        cursor.isLast = true;
    }


    public static void pro() {

        float sum = 0;
        for (int i = 0; i < n; i++) {
            sum += count(inputCharArr[i]);
        }

        double avg = sum / n;
        sb.append(String.format("%.2f", avg)).append('\n');
    }

    public static int count(char[] inputChar) {

        int cnt = 1;
        Trie cursor = root.next[inputChar[0] - 'a'];
        for (int i = 1; i < inputChar.length; i++) {
            int nextIdx = inputChar[i] - 'a';
            if (cursor.childCnt != 1 || cursor.isLast) {
                cnt++;
            }
            cursor = cursor.next[nextIdx];
        }
        return cnt;
    }

    public static void main(String args[]) throws IOException
    {
        String s;
        while ((s = br.readLine()) != null) {
            n = Integer.parseInt(s);
            input();
            pro();
        }
        System.out.println(sb);
    }
}