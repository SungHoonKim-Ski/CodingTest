import java.math.BigInteger;
import java.util.*;
import java.io.*;


public class Main
{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer sb = new StringBuffer();

    static char[] inputChar;
    public static void input() throws Exception {

        inputChar = br.readLine().toCharArray();
    }

    static void pro() {

        for (int i = 0; i < inputChar.length; i++) {
            if (inputChar[i] >= 'A' && inputChar[i] <= 'Z') {
                if (inputChar[i] + 13 > 'Z') {
                    sb.append((char)(inputChar[i] - 13));
                }else {
                    sb.append((char)(inputChar[i] + 13));
                }
            } else if (inputChar[i] >= 'a' && inputChar[i] <= 'z') {
                if (inputChar[i] + 13 > 'z') {
                    sb.append((char)(inputChar[i] - 13));
                }else {
                    sb.append((char)(inputChar[i] + 13));
                }
            } else sb.append(inputChar[i]);
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception
    {
        input();
        pro();
    }
}