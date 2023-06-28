import java.util.*;
import java.io.*;


public class Main
{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer sb = new StringBuffer();
    static StringTokenizer st;
    static Stack<char[]> stack;

    public static void input() throws Exception
    {
        stack = new Stack<>();
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            stack.push(st.nextToken().toCharArray());
        }
    }

    static void pro(int tc)
    {
        sb.append(String.format("Case #%d: ", tc));
        while (!stack.isEmpty()) sb.append(String.valueOf(stack.pop())).append(' ');
        sb.append('\n');
    }

    public static void main(String[] args) throws Exception
    {
        int n = Integer.parseInt(br.readLine());
        for (int i = 1; i <= n; i++) {
            input();
            pro(i);
        }
        System.out.println(sb);
    }
}
