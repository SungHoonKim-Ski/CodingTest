import java.math.BigInteger;
import java.util.*;
import java.io.*;


public class Main
{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer sb = new StringBuffer();
    static StringTokenizer st;

    static int N;
    static int[] aCards, bCards;

    public static void input() throws Exception
    {
        aCards = new int[5];
        bCards = new int[5];

        st = new StringTokenizer(br.readLine());
        int aCnt = Integer.parseInt(st.nextToken());
        for (int i = 0; i < aCnt; i++) {
            int num = Integer.parseInt(st.nextToken());
            aCards[num]++;
        }

        st = new StringTokenizer(br.readLine());
        int bCnt = Integer.parseInt(st.nextToken());
        for (int i = 0; i < bCnt; i++) {
            int num = Integer.parseInt(st.nextToken());
            bCards[num]++;
        }
    }

    static void pro()
    {
        char res = 'D';

        for (int i = 4; i > 0; i--) {
            if (aCards[i] == bCards[i]) continue;
            if (aCards[i] > bCards[i]) {
                res = 'A';
            } else {
                res = 'B';
            }
            break;
        }

        sb.append(res).append('\n');
    }

    public static void main(String[] args) throws Exception
    {
        N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            input();
            pro();
        }
        System.out.println(sb);
    }
}