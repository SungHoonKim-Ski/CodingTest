import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, m, MAX_VALUE = -1;
    static int[] arr;

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            MAX_VALUE = Math.max(MAX_VALUE, arr[i]);
        }
    }

    static void pro() {

        int left = 0, right = Integer.MAX_VALUE;
        int result = 0;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (determination(mid)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(result);
    }

    static boolean determination(int mid) {

        int min = arr[0];
        int max = arr[0];
        int count = 1;

        for (int i = 1; i < n; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
            if (max - min > mid) {
                count++;
                min = arr[i];
                max = arr[i];
            }
        }
        return count <= m;
    }

    public static void main(String[] args) throws Exception {
        input();
        pro();
    }
}