import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer sb = new StringBuffer();
    static StringTokenizer st;

    static int a;
    static char[] b;

    static void input() throws IOException{
        a = Integer.parseInt(br.readLine());
        b = br.readLine().toCharArray();
    }

    static void pro() {

        int sum = 0;
        for (int i = b.length - 1, j = 0; i >= 0; i--, j++) {
            int mul = a * (b[i] - '0');
            sb.append(mul).append('\n');
            sum += mul * (int) Math.pow(10, j);
        }
        sb.append(sum);
        System.out.println(sb);


    }

    public static void main(String[] args) throws IOException{
        input();
        pro();

    }

}
