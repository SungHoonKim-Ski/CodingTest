import java.math.BigInteger;
import java.util.*;
import java.io.*;


public class Main
{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer sb = new StringBuffer();

    static int[] inputInt;
    static int ArrLen = 10;

    public static void input() throws Exception {

        inputInt = new int[ArrLen];
        for (int i = 0; i < ArrLen; i++) {
            inputInt[i] = Integer.parseInt(br.readLine());
        }
    }

    static void pro() {

        int sum = 0, dif = 100;
        for (int i = 0; i < ArrLen; i++) {
            if (sum + inputInt[i] < 100) {
                sum += inputInt[i];
                dif -= inputInt[i];
            } else {
                if (sum + inputInt[i] - 100 <= dif) {
                    sum += inputInt[i];
                }
                break;
            }
        }
        System.out.println(sum);

    }

    public static void main(String[] args) throws Exception
    {
        input();
        pro();

    }
}