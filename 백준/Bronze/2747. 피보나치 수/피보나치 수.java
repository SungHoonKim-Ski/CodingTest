import java.math.BigInteger;
import java.util.*;
import java.io.*;


public class Main
{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n;
    static int[] fibArr;
    final static int modVal = 1000000007;

    public static void input() throws IOException{

       BigInteger bi = new BigInteger(br.readLine());
       n = bi.mod(new BigInteger(String.valueOf(modVal))).intValue();
       fibArr = new int[n + 2];
       fibArr[1] = 1;
    }
    public static void pro() {
        fibo(n);
        System.out.println(fibArr[n]);
    }

    public static int fibo(int f) {
        if (f == 0) return 0;
        if (f == 1) return 1;
        if (fibArr[f] != 0) return fibArr[f];
        fibArr[f] = (fibo(f - 2) + fibo(f - 1));
        return fibArr[f];
    }



    public static void main(String args[]) throws IOException
    {
        input();
        pro();
    }
}