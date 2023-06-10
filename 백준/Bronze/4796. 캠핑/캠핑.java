import java.math.BigInteger;
import java.util.*;
import java.io.*;


public class Main
{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer sb = new StringBuffer();

    static int L, P, V;

    public static void input() throws Exception {

        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
    }

    static void pro(int cnt) {

        int mod = V % P;
        int div = V / P;
        int res = div * L + Math.min(mod, L);
        sb.append(String.format("Case %d: %d", cnt, res)).append('\n');
    }

    public static void main(String[] args) throws Exception
    {
        int i = 1;
        while (true) {
            input();
            if (L == P && P == V && L == 0) break;
            pro(i);
            i++;
        }
        System.out.println(sb);
    }
}