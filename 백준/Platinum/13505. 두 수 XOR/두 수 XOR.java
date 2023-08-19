import java.util.*;
import java.io.*;


public class Main
{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n;
    static int[] inputInt;
    static Trie root;

    static class Trie{

        Trie[] next;
        int depth;
        boolean isLast;

        public Trie() {
            this.next = new Trie[2];
            this.isLast = false;
        }

    }


    public static void input() throws IOException{

        n = Integer.parseInt(br.readLine());
        inputInt = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            inputInt[i] = Integer.parseInt(st.nextToken());
        }
    }



    public static void pro() {

        root = new Trie();
        insertNum();
        int maxVal = -1;
        for (int i = 0; i < n; i++) {
            maxVal = Math.max(search(i),maxVal);
        }
        System.out.println(maxVal);
    }

    public static void insertNum() {


        for (int i = 0; i < n; i++) {

            int curNum = inputInt[i];
            Trie curCursor = root;

            int compareNum = 1 << 30;
            while (compareNum != 0) {

                int idx = (compareNum & curNum) > 0 ? 1 : 0;
                if (curCursor.next[idx] == null) {
                    curCursor.next[idx] = new Trie();
                    curCursor.isLast = false;
                }
                curCursor = curCursor.next[idx];
                compareNum >>= 1;
            }
        }
    }

    public static int search(int idx) {

        int flagNum = 1 << 30;

        int curNum = inputInt[idx];
        int maxNumber = 0;

        Trie curCursor = root;
        Trie oppoCursor = root;

        while (flagNum != 0) {

            maxNumber <<= 1;
            int nextIdx = (flagNum & curNum) > 0 ? 1 : 0;
            int oppoIdx = (nextIdx + 1) % 2;
            if (oppoCursor.next[oppoIdx] == null) {
                oppoCursor = oppoCursor.next[nextIdx];
                maxNumber += nextIdx;
            } else {
                oppoCursor = oppoCursor.next[oppoIdx];
                maxNumber += oppoIdx;
            }
            curCursor = curCursor.next[nextIdx];

            flagNum >>= 1;
        }
        return curNum ^ maxNumber;
    }

    public static void main(String args[]) throws IOException
    {
        input();
        pro();

    }
}