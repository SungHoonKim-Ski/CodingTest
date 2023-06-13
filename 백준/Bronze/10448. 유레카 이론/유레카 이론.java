import java.math.BigInteger;
import java.util.*;
import java.io.*;


public class Main
{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer sb = new StringBuffer();

    static int[] numT;
    static int K;
    static int MAX_NUM = 1000;

    public static void input() throws Exception {
        K = Integer.parseInt(br.readLine());
    }

    static void init() {
        numT = new int[MAX_NUM + 1];
        numT[1] = 1;
        for (int i = 2; i <= MAX_NUM; i++) {
            numT[i] = numT[i - 1] + i;
        }
    }

    static void pro() {

        boolean flag = false;

        for (int i = 1; i <= K; i++) {
            for (int j = i; j <= K; j++) {
                for (int k = j; k <= K; k++) {
                    if (K == numT[i] + numT[j] + numT[k]) {
                        flag = true;
                        break;
                    }
                }
                if (flag) break;
            }
            if (flag) break;
        }
        if (flag) {
            sb.append(1);
        } else {
            sb.append(0);
        }
        sb.append('\n');
    }

    public static void main(String[] args) throws Exception
    {
        init();
        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            input();
            pro();
        }
        System.out.println(sb);
    }
}