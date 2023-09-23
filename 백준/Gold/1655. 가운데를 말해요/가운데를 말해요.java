import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer sb = new StringBuffer();
    static StringTokenizer st;

    static int n;
    static int[] input;

    static void input() throws IOException{
        n = Integer.parseInt(br.readLine());
        input = new int[n];
        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(br.readLine());
        }

    }

    static void pro() {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {

            if (maxHeap.size() != minHeap.size()) minHeap.add(input[i]);
            else maxHeap.add(input[i]);

            int minTop = -1;
            if (!minHeap.isEmpty()) minTop = minHeap.peek();
            int maxTop = maxHeap.peek();

            if (!minHeap.isEmpty()) {
                if (maxTop > minTop) {
                    minTop = minHeap.poll();
                    minHeap.add(maxHeap.poll());
                    maxHeap.add(minTop);
                }
            }

            sb.append(maxHeap.peek()).append('\n');
        }
        System.out.println(sb);

    }



    public static void main(String[] args) throws IOException{
        input();
        pro();

    }

}
