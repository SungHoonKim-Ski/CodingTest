import java.math.BigInteger;
import java.util.*;
import java.io.*;


public class Main
{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;

    public static void input() throws Exception {
//        inputInt = new BigInteger(br.readLine());
        N = Integer.parseInt(br.readLine());
    }

    public static void pro() throws Exception {

        BigInteger sum = BigInteger.ZERO;
        while (N-- > 0) {
            sum = sum.add(new BigInteger(br.readLine()));
        }

        if (sum.equals(BigInteger.ZERO)) System.out.println(0);
        else if (sum.compareTo(BigInteger.ZERO) > 0) System.out.println('+');
        else System.out.println('-');
    }




    public static void main(String[] args) throws Exception
    {
        for (int i = 0; i < 3; i++) {
            input();
            pro();
        }
    }
}