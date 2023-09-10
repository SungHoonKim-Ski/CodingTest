import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer sb = new StringBuffer();
    static StringTokenizer st;

    static int modVal = 1_000_000_007;

    public static void main(String[] args) throws IOException{

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        long x = pow(n, m);
        long y = pow(n - 1, m);
        long res = x - y;
        if (res < 0) res += modVal;
        System.out.println(res);
    }

    static long pow(int n, int m) {

        if (m == 1) {
            return n % modVal;
        }

        long tmp = pow(n, m / 2);
        if (m % 2 == 1) return (tmp * tmp % modVal) * n % modVal;
        else return tmp * tmp % modVal;
    }



}