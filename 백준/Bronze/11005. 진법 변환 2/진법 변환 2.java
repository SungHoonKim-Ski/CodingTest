import java.math.BigInteger;
import java.util.*;
import java.io.*;


public class Main
{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer sb = new StringBuffer();

    static int N, B;

    public static void input() throws Exception {

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
    }

    static void pro() {

        Stack<Integer> stack = new Stack<>();
        while (N != 0) {
            stack.add(N % B);
            N /= B;
        }

        while (!stack.isEmpty()) {

            if (stack.peek() < 10) sb.append(stack.pop());
            else sb.append((char)(stack.pop() + 'A' - 10));
        }

        System.out.println(sb);

    }

    public static void main(String[] args) throws Exception
    {
        input();
        pro();
    }
}