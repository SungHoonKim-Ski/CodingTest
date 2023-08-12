import java.util.*;
import java.io.*;
import java.math.*;


public class Main
{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer sb = new StringBuffer();
    static StringTokenizer st;
    static int N;
    public static void input() throws IOException{
        N = Integer.parseInt(br.readLine());
    }

    public static void pro() {

        if (N < 5) {
            System.out.println(0);
            return;
        }
        BigInteger num = BigInteger.ONE;
        for (int i = 2; i <= N; i++) {
            num = num.multiply(new BigInteger(String.valueOf(i)));
        }

        char[] numCharArr  = num.toString().toCharArray();
        int cnt = 0;
        for (int i = numCharArr.length - 1; i != 0; i--) {
            if (numCharArr[i] != '0') break;
            else cnt++;
        }
        System.out.println(cnt);

    }

    public static void main(String args[]) throws IOException
    {
        input();
        pro();

    }
}