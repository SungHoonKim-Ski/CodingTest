import java.math.BigInteger;
import java.util.*;
import java.io.*;


public class Main
{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n;
    static BigInteger[] fibArr;
    final static int modVal = 1000000;

    public static void input() throws IOException{

//       BigInteger bi = new BigInteger(br.readLine());
//       n = bi.mod(new BigInteger(String.valueOf(modVal))).intValue();
        n = Integer.parseInt(br.readLine());
        if (n < 2) fibArr = new BigInteger[2];
        else fibArr = new BigInteger[n + 1];
        fibArr[1] = BigInteger.ONE;
        fibArr[0] = BigInteger.ZERO;
    }
    public static void pro() {
        fibo(n);
        System.out.println(fibArr[n]);
    }

    public static BigInteger fibo(int f) {
        if (fibArr[f] != null) return fibArr[f];
        fibArr[f] = fibo(f - 2).add(fibo(f - 1));
        return fibArr[f];
    }



    public static void main(String args[]) throws IOException
    {
        input();
        pro();
    }
}