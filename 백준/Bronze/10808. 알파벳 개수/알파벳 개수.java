import java.io.*;
import java.util.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static char[] charArr;

    static void input() throws Exception{
        charArr = br.readLine().toCharArray();
    }

    static void pro() {

        int[] cnt = new int['z' - 'a' + 1];
        for (int i = 0; i < charArr.length; i++) {
            cnt[charArr[i] - 'a']++;
        }

        for(int i = 0; i < cnt.length; i++) {
            sb.append(cnt[i]).append(' ');
        }
        System.out.println(sb);


    }

    public static void main(String[] args) throws Exception{

        input();
        pro();
//        System.out.println(sb);;

    }
}
