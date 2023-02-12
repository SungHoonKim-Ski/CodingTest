import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    private static BufferedReader br;

    static PriorityQueue<Integer> largeHeap;
    static PriorityQueue<Integer> smallHeap;
    static int mid = 0;
    public static void main(String[] args) throws Exception {

        System.setIn(new java.io.FileInputStream("res/sample_input.txt"));

        br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int TC = Integer.parseInt(str);

        largeHeap = new PriorityQueue<>();
        smallHeap = new PriorityQueue<>(Collections.reverseOrder());
        StringTokenizer st;
        for (int tc = 1; tc <= TC; tc++) {
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            mid = Integer.parseInt(st.nextToken());
            int res = 0;

            for (int i = 0; i < N; i ++) {
                st = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                compare(mid, x, y);
                res += mid;
                res %= 20171109;
            }

            System.out.printf("#%d %d%n", tc, res);

            smallHeap.clear();
            largeHeap.clear();
        }
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