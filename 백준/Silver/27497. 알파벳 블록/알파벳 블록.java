import java.io.*;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static StringTokenizer st;

    static int N;



    static void input() throws IOException
    {
        N = Integer.parseInt(br.readLine());
    }

    static void pro() throws IOException
    {

        Deque<Character> deque = new ArrayDeque<>();
        LinkedList<Integer> stack = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            switch (cmd) {
                case 1:
                    deque.addLast(st.nextToken().charAt(0));
                    stack.push(cmd);
                    break;
                case 2:
                    stack.push(cmd);
                    deque.addFirst(st.nextToken().charAt(0));
                    break;
                case 3:
                    if (deque.isEmpty()) continue;
                    int cur = stack.pop();
                    if (cur == 1) deque.pollLast();
                    else deque.pollFirst();
                    break;
                default:
                    System.out.println("ERROR");
                    break;
            }
        }
        if (deque.isEmpty()) sb.append(0);
        else {
            for (char c: deque) sb.append(c);
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception{
        input();
        pro();

    }

}