import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n, m;
    static int[] a, b;

    static void input() throws IOException{
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        a = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(st.nextToken());

        b = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) b[i] = Integer.parseInt(st.nextToken());
    }

    static void pro() {
        int[] count = new int[7];
        for (int i = 0; i < n; i++) {
            count[a[i] % 7]++;
        }

        boolean[] div = new boolean[7];

        long sum = 0;
        int left = n;
        for (int i = 0; i < m; i++) {
            sum += b[i];
            int mod = (int)(7 - sum % 7) % 7;

            if (count[mod] == left) {
                sum -= b[i];
                continue;
            }
            if (div[mod]) continue;

            div[mod] = true;
            left -= count[mod];
        }

        int k = 0;
        for (int i = 0; i < n; i++) {
            if (div[a[i] % 7]) continue;

            k++;
            sb.append((a[i] + sum) % 1_000_000_007).append(' ');
        }
        System.out.println(k);
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}