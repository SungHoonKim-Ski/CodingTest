import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n;
    static int[] sequence;
    static int[] dp;

    static void input() throws Exception {
        n = Integer.parseInt(br.readLine());
        sequence = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }
    }

    public static void pro() {
        dp = new int[n];

        int length = 0;
        for (int i = 0; i < n; i++) {
            int cur = sequence[i];
            int idx = binarySearch(0, length - 1, cur);

            dp[idx] = cur;
            if (idx == length) {
                length++;
            }
        }

        System.out.println(length);
    }

    static int binarySearch(int start, int end, int search) {
        while (start <= end) {
            int mid = (start + end) / 2;
            if (dp[mid] == search) return mid;
            if (dp[mid] < search) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return start;
    }

    public static void main(String[] args) throws Exception{
        input();
        pro();
    }
}