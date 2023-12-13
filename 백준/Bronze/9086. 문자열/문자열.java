import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer sb = new StringBuffer();

    static char[] str;

    static void input() throws IOException{
        str = br.readLine().toCharArray();
    }

    static void pro() throws IOException{
        sb.append(str[0]).append(str[str.length - 1]);
        sb.append('\n');
    }

    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            input();
            pro();
        }
        System.out.println(sb);
    }

}