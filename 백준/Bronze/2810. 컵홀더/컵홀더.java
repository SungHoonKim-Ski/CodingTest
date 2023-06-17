import java.math.BigInteger;
import java.util.*;
import java.io.*;


public class Main
{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer sb = new StringBuffer();

    static int N;
    static char[] inputChar;

    public static void input() throws Exception
    {
        N = Integer.parseInt(br.readLine());
        inputChar = br.readLine().toCharArray();
    }

    static void pro()
    {

        int cnt = 1;

        for (int i = 0; i < N; i++) {
            if (inputChar[i] == 'L') i++;
            cnt++;
        }
        if (cnt > N) cnt = N;
        System.out.println(cnt);
    }

    public static void main(String[] args) throws Exception
    {
        input();
        pro();
    }
}