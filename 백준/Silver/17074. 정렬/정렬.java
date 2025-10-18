import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n;
    static int[] arr;

    static void input() throws IOException{
        n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        arr = new int[n + 1];
        for (int i = 1; i <= n; i++) arr[i] = Integer.parseInt(st.nextToken());
    }

    static void pro() {
        boolean[] prefix = new boolean[n + 2];
        boolean[] suffix = new boolean[n + 2];

        prefix[1] = true;
        for (int i = 2; i <= n; i++) {
            prefix[i] = prefix[i - 1];

            if (prefix[i]) {
                prefix[i] = arr[i - 1] <= arr[i];
            }
        }

        suffix[n] = true;
        for (int i = n - 1; i > 0; i--) {
            suffix[i] = suffix[i + 1];

            if (suffix[i]) {
                suffix[i] = arr[i] <= arr[i + 1];
            }
        }

        long ans = 0;
        if (n >= 2 && suffix[2]) ans++;
        if (n >= 2 && prefix[n - 1]) ans++;

        for (int i = 2; i < n; i++) {
            boolean left = prefix[i - 1];
            boolean right = suffix[i + 1];

            if (!left || !right) continue;
            if (arr[i - 1] <= arr[i + 1]) ans++;
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}