import java.math.BigInteger;
import java.util.*;
import java.io.*;


public class Main
{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer sb = new StringBuffer();

    static char[][] inputChar;
    public static void input() throws Exception {

        StringTokenizer st = new StringTokenizer(br.readLine());
        inputChar = new char[st.countTokens()][];

        int i = 0;
        while (st.hasMoreTokens()) {
            inputChar[i] = st.nextToken().toCharArray();
            i++;
        }
    }

    static void pro() {

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < inputChar.length; i++) {
            for (int j = 0; j < inputChar[i].length; j++) {
                stack.add(inputChar[i][j]);
            }
            while (!stack.isEmpty()) {
                sb.append(stack.pop());
            }
            sb.append(' ');
        }
        sb.append('\n');
    }

    public static void main(String[] args) throws Exception
    {
        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            input();
            pro();
        }
        System.out.println(sb);
    }
}