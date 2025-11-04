import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n, max;
    static int[] arr;

    static void input() throws IOException{
        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void pro() {
        int left = 1, right = 300_000, res = 0;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (determination(mid)) {
                res = Math.max(res, mid);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(res);
    }

    static boolean determination(int mid) {
        int res = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] >= mid) {
                count++;
            } else {
                res = Math.max(res, count);
                count = 0;
            }
        }
        res = Math.max(res, count);

        return res >= mid;
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}