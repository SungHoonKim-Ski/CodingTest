import java.math.BigInteger;
import java.util.*;
import java.io.*;


public class Main
{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer sb = new StringBuffer();

    static int N;

    public static void input() throws Exception {

        N = Integer.parseInt(br.readLine());
    }

    static void pro() {

        int cnt = 1;
        if (N != 0) {
            int cycleNum = cycle(N);
            while (cycleNum != N) {
                cycleNum = cycle(cycleNum);
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    static int cycle(int input) {

        if (input == 0) return 0;
        int sum = input % 10 + input / 10;
        return (input % 10 * 10 + sum % 10);
    }


    public static void main(String[] args) throws Exception
    {
        input();
        pro();
    }
}