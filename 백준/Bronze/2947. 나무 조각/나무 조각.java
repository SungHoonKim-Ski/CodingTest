import java.math.BigInteger;
import java.util.*;
import java.io.*;


public class Main
{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer sb = new StringBuffer();

    static int[] inputArr = new int[5];

    public static void input() throws Exception
    {
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < inputArr.length; i++) {
            inputArr[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void pro()
    {
        while (!check()) {
            for (int i = 1; i < inputArr.length; i++) {
                if (inputArr[i - 1] > inputArr[i]) {
                    swap(i-1, i);
                    print();
                }
            }

        }
    }

    static void swap(int x1, int x2) {
        int tmp = inputArr[x1];
        inputArr[x1] = inputArr[x2];
        inputArr[x2] = tmp;
    }

    static void print() {
        for (int i = 0; i < inputArr.length; i++) {
            sb.append(inputArr[i]).append(' ');
        }
        sb.append('\n');
    }
    static boolean check() {

        for (int i = 1; i < inputArr.length; i++) {
            if (inputArr[i - 1] > inputArr[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception
    {
        input();
        pro();
        System.out.println(sb);
    }
}