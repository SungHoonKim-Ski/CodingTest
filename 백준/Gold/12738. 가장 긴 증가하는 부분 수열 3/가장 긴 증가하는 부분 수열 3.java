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
            int idx = binarySearch(0, length - 1, sequence[i]);
            dp[idx] = sequence[i];

            if (idx == length) {
                length++;
            }
        }
        System.out.println(length);
    }

    private static int binarySearch(int left, int right, int find) {
        while (left <= right) {
            int mid = (right - left) / 2 + left;

            if (dp[mid] < find) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }

    public static void main(String[] args) throws Exception{
        input();
        pro();
    }
}