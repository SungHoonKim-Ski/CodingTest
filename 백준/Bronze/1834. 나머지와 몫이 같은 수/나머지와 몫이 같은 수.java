import java.math.BigInteger;
import java.util.*;
import java.io.*;


public class Main
{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer sb = new StringBuffer();

    static int N;

    public static void input() throws Exception
    {
        N = Integer.parseInt(br.readLine());
    }

    static void pro()
    {

        long cnt = 0;

        for (int i = 1; i < N; i++) {
            cnt += (long)N * i + i;
        }
        System.out.println(cnt);
    }

    public static void main(String[] args) throws Exception
    {
        input();
        pro();
    }
}