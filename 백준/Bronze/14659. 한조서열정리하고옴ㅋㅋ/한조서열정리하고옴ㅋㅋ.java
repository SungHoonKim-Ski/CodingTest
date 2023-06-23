import java.math.BigInteger;
import java.util.*;
import java.io.*;


public class Main
{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer sb = new StringBuffer();
    static StringTokenizer st;

    static int N;
    static int[] IntArr;

    public static void input() throws Exception
    {
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        IntArr = new int[N];
        for (int i = 0; i < N; i++) {
            IntArr[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void pro()
    {
        int max = 0;
        for (int i = 0; i < N-1; i++) {
            int cnt = 0;
            for (int j = i + 1; j < N; j++) {
                if (IntArr[i] > IntArr[j]) cnt++;
                else break;
            }
            max = Math.max(max, cnt);
        }
        System.out.println(max);
    }

    public static void main(String[] args) throws Exception
    {
        input();
        pro();
    }
}