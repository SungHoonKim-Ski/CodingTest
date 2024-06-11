import java.io.*;
import java.util.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int candidateCnt;
    static String n;
    static void input() throws IOException{
        n = br.readLine();
        sb = new StringBuilder(n);
    }

    static void pro() {

        dfs(sb);
        System.out.println(candidateCnt);
    }

    static void dfs(StringBuilder sb) {

        if (sb.length() == 0) {
            candidateCnt++;
            return;
        }

        StringBuilder sb1 = new StringBuilder(sb);
        sb1.deleteCharAt(0);
        StringBuilder sb2 = new StringBuilder(sb);
        sb2.deleteCharAt(sb2.length() - 1);
        dfs(sb1);
        if (sb1.toString().contentEquals(sb2)) return;
        dfs(sb2);
    }

    public static void main(String[] args) throws Exception{
        input();
        pro();
    }
}