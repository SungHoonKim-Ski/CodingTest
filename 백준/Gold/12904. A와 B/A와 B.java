import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static String S;
    static StringBuilder T;

    static void input() throws IOException{

        S = br.readLine();
        T = new StringBuilder();
        T.append(br.readLine());
    }

    static void pro() {

        while (T.length() > S.length()) {
            if (T.charAt(T.length() - 1) == 'A') T.setLength(T.length() - 1);
            else if (T.charAt(T.length() - 1) == 'B') {
                T.setLength(T.length() - 1);
                T.reverse();
            } else break;
        }

        int res = 0;
        if (T.toString().equals(S)) res = 1;
        System.out.println(res);
    }

    public static void main(String[] args) throws Exception{
        input();
        pro();
    }
}