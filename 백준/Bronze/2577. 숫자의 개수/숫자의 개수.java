import java.io.*;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static StringTokenizer st;

    static int A, B, C;


    static void input() throws IOException
    {
        A = Integer.parseInt(br.readLine());
        B = Integer.parseInt(br.readLine());
        C = Integer.parseInt(br.readLine());
    }

    static void pro() throws IOException
    {
        int[] cnt = new int[10];
        char[] ans = String.valueOf(A * B * C).toCharArray();

        for (int i = 0; i < ans.length; i++) cnt[ans[i] - '0']++;

        for (int i = 0; i < cnt.length; i++) sb.append(cnt[i]).append('\n');

        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception{
        input();
        pro();

    }

}