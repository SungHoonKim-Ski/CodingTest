import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static BufferedReader br;

    static PriorityQueue<Integer> largeHeap;
    static PriorityQueue<Integer> smallHeap;
    static int mid = 0;
    public static void main(String[] args) throws Exception {

        br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int TC = Integer.parseInt(str);

        largeHeap = new PriorityQueue<>();
        smallHeap = new PriorityQueue<>(Collections.reverseOrder());
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();
        for (int tc = 1; tc <= TC; tc++) {
            int N = Integer.parseInt(br.readLine());
            sb.append(N / 2 + 1).append('\n');
            st = new StringTokenizer(br.readLine(), " ");
            mid = Integer.parseInt(st.nextToken());
            sb.append(mid).append(' ');
            int x, y;
            x = y = 0;
            for (int i = 1; i < N; i++) {
                if (i % 10 == 0) {
                    st = new StringTokenizer(br.readLine(), " ");
                }
                if (i % 20 == 0) sb.append('\n');
                if (i % 2 == 1) x = Integer.parseInt(st.nextToken());
                else {
                    y = Integer.parseInt(st.nextToken());
                    compare(mid, x, y);
                    sb.append(mid).append(' ');
                }
            }
            smallHeap.clear();
            largeHeap.clear();
            System.out.println(sb);
            sb.setLength(0);
        }
        System.out.println(sb);
    }

    public static void compare(int m, int x, int y) {

        if (m > x && m > y) {
            smallHeap.add(x);
            smallHeap.add(y);
            largeHeap.add(m);
            mid = smallHeap.poll();
        }else if (m < x && m < y) {
            largeHeap.add(x);
            largeHeap.add(y);
            smallHeap.add(m);
            mid = largeHeap.poll();
        }else if (x < y) {
            largeHeap.add(y);
            smallHeap.add(x);
        }else {
            largeHeap.add(x);
            smallHeap.add(y);
        }
    }
}