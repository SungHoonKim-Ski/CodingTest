import java.math.BigInteger;
import java.util.*;
import java.io.*;


public class Main
{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer sb = new StringBuffer();
    static StringTokenizer st;

    static int N, S, E;

    public static void input() throws Exception
    {
        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
    }

    static void pro()
    {
        int cnt = 0;
        if (S == 0) cnt++;
        for (int i = S; i <= E; i++) {
            int j = i;
            while (j != 0) {
                if (j % 10 == 0) cnt++;
                j /= 10;
            }
        }
        sb.append(cnt).append('\n');

    }

    public static void main(String[] args) throws Exception
    {
        N = Integer.parseInt(br.readLine());
        while(N-- > 0) {
            input();
            pro();
        }
        System.out.println(sb);
    }
}