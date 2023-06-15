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

    static void pro() throws Exception
    {
        int max = -1;
        char[] str = new char[21];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            char[] curStr = st.nextToken().toCharArray();
            int cnt = Integer.parseInt(st.nextToken());
            if (cnt > max) {
                max = cnt;
                str = curStr;
            }
        }

        System.out.println(String.valueOf(str));
    }

    public static void main(String[] args) throws Exception
    {
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            input();
            pro();
        }
    }
}