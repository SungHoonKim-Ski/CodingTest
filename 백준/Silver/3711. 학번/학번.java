import java.math.BigInteger;
import java.util.*;
import java.io.*;


public class Main
{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer sb = new StringBuffer();
    static StringTokenizer st;

    static int G;
    static int[] inputArr;
    static boolean[] isNotDecimal;
    static int MAX_SIZE = 100000;

    static void init() {
        isNotDecimal = new boolean[MAX_SIZE];
        for (int i = 2; i < MAX_SIZE; i++) {
            if (isNotDecimal[i]) continue;
            for (int j = 2 * i; j < MAX_SIZE; j += i) {
                isNotDecimal[j] = true;
            }
        }
    }

    public static void input() throws Exception
    {

        G = Integer.parseInt(br.readLine());
        inputArr = new int[G];

        for (int i = 0; i < G; i++) {
            inputArr[i] = Integer.parseInt(br.readLine());
        }
    }

    static void pro()
    {
        HashSet<Integer> hashSet = new HashSet<>();

        int res = 1;
        if (G != 1) {
            for (int i = 1; i < MAX_SIZE; i++) {
                for (int j = 0; j < G; j++) {
                    if (!hashSet.add(inputArr[j] % i)) break;
                }
                if (hashSet.size() == G) {
                    res = i;
                    break;
                } else hashSet.clear();
            }
        }
        sb.append(res).append('\n');

    }

    public static void main(String[] args) throws Exception
    {
        init();
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            input();
            pro();
        }
        System.out.println(sb);
    }
}
