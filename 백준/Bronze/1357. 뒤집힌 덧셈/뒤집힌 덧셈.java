import java.math.BigInteger;
import java.util.*;
import java.io.*;


public class Main
{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int X, Y;

    public static void input() throws Exception {

        StringTokenizer st = new StringTokenizer(br.readLine());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
    }

    static void pro() {
        System.out.println(Rev(Rev(X) + Rev(Y)));
    }

    static int Rev(int num) {

        char[] numChar = String.valueOf(num).toCharArray();
        char[] revChar = new char[numChar.length];

        for (int i = 0; i < numChar.length; i++) {
            revChar[i] = numChar[numChar.length - 1 - i];
        }

        return Integer.parseInt(String.valueOf(revChar));
    }




    public static void main(String[] args) throws Exception
    {
        input();
        pro();
    }
}