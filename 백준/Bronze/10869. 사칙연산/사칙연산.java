import java.io.*;
import java.util.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int a, b;

    static void input() throws Exception{

        st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

    }

    static void pro() {
        
        sb.append(a + b).append('\n');
        sb.append(a - b).append('\n');
        sb.append(a * b).append('\n');
        sb.append(a / b).append('\n');
        sb.append(a % b);
        System.out.println(sb);
    }

   
    public static void main(String[] args) throws Exception{

        input();
        pro();

    }
}

