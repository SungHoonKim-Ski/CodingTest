import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int n;
    static long[] arr, prefixSum;

    static void input() throws IOException {
        n = Integer.parseInt(br.readLine());

        arr = new long[n + 1];
        prefixSum = new long[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            prefixSum[i] = prefixSum[i - 1] + arr[i];
        }
    }

    static void pro() {
        long max = prefixSum[n];
        for (int i = n ; i >= 1; i--) {
            if (max % i != 0) continue;
            int res = find(max / i);

            if (res != -1) {
                sb.append(res).append('\n');
                return;
            }
        }
    }

    static int find(long num) {
        int cnt = 0;
        long sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += arr[i];
            if (sum < num) {
                continue;
            } else if (sum == num) {
                sum = 0;
                cnt++;
            }
            else {
                return -1;
            }
        }
        return n - cnt;
    }

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            input();
            pro();
        }

        System.out.println(sb);
    }
}
