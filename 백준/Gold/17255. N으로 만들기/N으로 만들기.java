import java.io.*;
import java.util.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer sb = new StringBuffer();
    static StringTokenizer st;

    static int candidateCnt;
    static void input() throws IOException{
        sb = new StringBuffer(br.readLine());
    }

    static void pro() {

        dfs(sb);
        System.out.println(candidateCnt);
    }

    static void dfs(StringBuffer sb) {

        if (sb.length() == 0) {
            candidateCnt++;
            return;
        }

        StringBuffer sb1 = new StringBuffer(sb);
        sb1.deleteCharAt(0);
        StringBuffer sb2 = new StringBuffer(sb);
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