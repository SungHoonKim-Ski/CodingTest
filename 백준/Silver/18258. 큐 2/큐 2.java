import java.io.*;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;

    static void input() throws IOException
    {
        N = Integer.parseInt(br.readLine());
    }

    static void pro() throws IOException
    {
        StringTokenizer st;
        Deque<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        while (N-- > 0) {

            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            switch (cmd) {
                case "push":
                    queue.add(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    if (queue.isEmpty()) sb.append(-1);
                    else sb.append(queue.poll());
                    sb.append('\n');
                    break;
                case "size":
                    sb.append(queue.size()).append('\n');
                    break;
                case "empty":
                    if (queue.isEmpty()) sb.append(1);
                    else sb.append(0);
                    sb.append('\n');
                    break;
                case "front":
                    if (queue.isEmpty()) sb.append(-1);
                    else sb.append(queue.peekFirst());
                    sb.append('\n');
                    break;
                case "back":
                    if (queue.isEmpty()) sb.append(-1);
                    else sb.append(queue.peekLast());
                    sb.append('\n');
            }
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception{
        input();
        pro();

    }

}