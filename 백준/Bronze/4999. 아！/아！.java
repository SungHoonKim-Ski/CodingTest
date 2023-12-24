import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer sb = new StringBuffer();
    static StringTokenizer st;

    static String s1, s2;
    static void input() throws IOException{
        s1 = br.readLine();
        s2 = br.readLine();
    }

    static void pro() throws IOException {
        System.out.println(s1.contains(s2) ? "go" : "no");
    }

    public static void main(String[] args) throws IOException{
        input();
        pro();
    }

}