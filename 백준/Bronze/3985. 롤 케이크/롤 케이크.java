import java.util.*;
import java.io.*;


public class Main
{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer sb = new StringBuffer();
    static StringTokenizer st;

    static int N, L;

    public static void input() throws Exception
    {

        L = Integer.parseInt(br.readLine());
        N = Integer.parseInt(br.readLine());

    }

    static void pro() throws Exception
    {
        int expectMaxIdx = 0, expectMaxCnt = 0;
        int actualMaxIdx = 0, actualMaxCnt = 0;
        int[] actualArr = new int[L + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            int expectCnt = e - s + 1;
            if (expectMaxCnt < expectCnt) {
                expectMaxCnt = expectCnt;
                expectMaxIdx = i;
            }

            int actualCnt = 0;
            for (int j = s; j <= e; j++) {
                if (actualArr[j] == 0) {
                    actualArr[j] = i;
                    actualCnt++;
                }
            }

            if (actualMaxCnt < actualCnt) {
                actualMaxCnt = actualCnt;
                actualMaxIdx = i;
            }
        }
        sb.append(expectMaxIdx).append('\n').append(actualMaxIdx);
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception
    {
        input();
        pro();
    }
}
