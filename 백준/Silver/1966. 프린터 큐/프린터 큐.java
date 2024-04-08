import java.io.*;
import java.util.*;

public class Main {

    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static class Print {
        int index, priority;
        Print(int _index, int _priority) {
            index = _index; priority = _priority;
        }
    }

    static int n, m;
    static PriorityQueue<Integer> printPriorityQueue;
    static Deque<Print> printQueue;
    static void input() throws IOException{
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        printPriorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        printQueue = new ArrayDeque<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int priority = Integer.parseInt(st.nextToken());
            printPriorityQueue.add(priority);
            printQueue.add(new Print(i, priority));
        }
    }

    static void pro() {

        int count = 0;

        while (!printQueue.isEmpty()) {
            Print cur = printQueue.poll();
            if (cur.priority == printPriorityQueue.peek()) {
                count++;
                printPriorityQueue.poll();
                if (cur.index == m) break;
            } else {
                printQueue.add(cur);
            }
        }
        sb.append(count).append('\n');
    }

    public static void main(String[] args) throws IOException{
        int tc = Integer.parseInt(br.readLine());
        while (tc -- > 0) {
            input();
            pro();
        }
        System.out.println(sb);
    }
}