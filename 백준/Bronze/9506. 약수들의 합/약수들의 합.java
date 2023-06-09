import java.math.BigInteger;
import java.util.*;
import java.io.*;


public class Main
{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer sb = new StringBuffer();

    static int N = 0;

    public static void input() throws Exception {

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
    }

    static void pro() {

        Deque<Integer> que = new LinkedList<>();

        int n = N/2;
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (N % i == 0) {
                sum += i;
                que.add(i);
            }
        }
        sb.append(N).append(' ');
        if (sum == N) {
            sb.append('=').append(' ');
            while (!que.isEmpty()) sb.append(que.pop()).append(' ').append('+').append(' ');
            sb.setLength(sb.length() - 3);
        } else {
            sb.append("is NOT perfect.");
        }
        sb.append('\n');
    }

    public static void main(String[] args) throws Exception
    {
        while (true) {
            input();
            if (N == -1) break;
            pro();
        }
        System.out.println(sb);

    }
}