import java.util.*;
import java.io.*;

public class Main {

    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer sb = new StringBuffer();

    static double k, n, a, b;

    public static void input() throws IOException{
        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
    }
    public static void pro() throws IOException {
        System.out.println(a / b);
    }


    public static void main(String[] args) throws IOException{
        input();
        pro();
    }

}
