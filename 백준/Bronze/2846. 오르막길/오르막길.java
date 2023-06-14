import java.math.BigInteger;
import java.util.*;
import java.io.*;


public class Main
{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer sb = new StringBuffer();

    static int[] inputArr;
    static int N;

    public static void input() throws Exception {

        N = Integer.parseInt(br.readLine());
        inputArr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            inputArr[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void pro()
    {
        int dif = 0;
        int start = inputArr[0];

        for (int i = 1; i < N; i++) {
            if (inputArr[i - 1] < inputArr[i]) {
                dif = Math.max(inputArr[i] - start, dif);
            } else {
                start = inputArr[i];
            }
        }
        System.out.println(dif);
    }

    public static void main(String[] args) throws Exception
    {
        input();
        pro();
    }
}