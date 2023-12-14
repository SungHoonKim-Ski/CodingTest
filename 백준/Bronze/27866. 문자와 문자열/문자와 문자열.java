import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer sb = new StringBuffer();

    static char[] str;
    static int n;

    static void input() throws IOException{
        str = br.readLine().toCharArray();
        n = Integer.parseInt(br.readLine());
    }

    static void pro() throws IOException{
        System.out.println(str[n - 1]);
    }

    public static void main(String[] args) throws IOException{
        input();
        pro();
    }

}