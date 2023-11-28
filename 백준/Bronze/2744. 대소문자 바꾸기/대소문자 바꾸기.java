import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer sb = new StringBuffer();

    static char[] inputChar;


    static void input() throws IOException{
        inputChar = br.readLine().toCharArray();
    }

    static void pro(){
        for (int i = 0; i < inputChar.length; i++) {
            if (inputChar[i] > 'Z') sb.append((char)(inputChar[i] - 32));
            else sb.append((char)(inputChar[i] + 32));
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException{
        input();
        pro();

    }

}