import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer sb = new StringBuffer();
    
    static int n;

    static void input() throws IOException{
        n = Integer.parseInt(br.readLine());
    }

    static void pro() throws IOException{
        int m = n / 4;
        while (m-- > 0) {
            sb.append("long ");
        }
        sb.append("int");
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException{
        input();
        pro();

    }

}