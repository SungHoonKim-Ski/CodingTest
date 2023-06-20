import java.math.BigInteger;
import java.util.*;
import java.io.*;


public class Main
{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer sb = new StringBuffer();
    static StringTokenizer st;

    static int N, Len, Res = 4;

    public static void input() throws Exception
    {
        String s = br.readLine();
        Len = s.length();
        N = Integer.parseInt(s);
    }

    static void dfs(int depth, int prev) {

        if (prev > N) return;
        Res = Math.max(prev, Res);
        if (depth == Len) return;
        dfs(depth + 1, prev * 10 + 4);
        dfs(depth + 1, prev * 10 + 7);
    }

    static void pro()
    {
        dfs(0, 0);
        System.out.println(Res);
    }

    public static void main(String[] args) throws Exception
    {
        input();
        pro();
    }
}