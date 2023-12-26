import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer sb = new StringBuffer();
    static StringTokenizer st;

    static BigInteger a, b;
    static void input() throws IOException{
        st = new StringTokenizer(br.readLine());
        a = new BigInteger(st.nextToken(), 2);
        b = new BigInteger(st.nextToken(), 2);
    }

    static void pro(){
        BigInteger c = a.add(b);
        sb.append(c.toString(2)).append('\n');
    }

    public static void main(String[] args) throws IOException{
        int tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            input();
            pro();
        }
        System.out.println(sb);
    }

}