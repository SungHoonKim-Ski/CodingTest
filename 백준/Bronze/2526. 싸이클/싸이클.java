import java.math.BigInteger;
import java.util.*;
import java.io.*;


public class Main
{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer sb = new StringBuffer();
    static StringTokenizer st;

    static int N, P;
    
    public static void input() throws Exception
    {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
    }

    static void pro()
    {
        
        int num = N;
        int[] pArr = new int[P + 1];
        if (N > P) {
            pArr[P]++;
        }
        while (true) {
            num *= N;
            num %= P;
            pArr[num]++;
            if (pArr[num] == 3) {
                pArr[num]--;
                break;
            }
        }

        int cnt = 0;
        for (int i = 0; i < P; i++) if (pArr[i] == 2) cnt++;
        System.out.println(cnt);
    }

    public static void main(String[] args) throws Exception
    {
        input();
        pro();
    }
}