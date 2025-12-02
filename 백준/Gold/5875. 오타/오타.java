import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int n;
    static char[] str;
    static int[] arr;
    static boolean[] suffix, prefix;

    public static void main(String[] args) throws IOException {
        str = br.readLine().toCharArray();

        n = str.length;

        arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = arr[i - 1];
            if (str[i - 1] == '(') arr[i]++;
            else arr[i]--;
        }

        suffix = new boolean[n + 2];
        prefix = new boolean[n + 2];
        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1];

            if (arr[i] < 0) prefix[i] = true;
        }

        for (int i = n; i >= 1; i--) {
            suffix[i] = suffix[i + 1];

            if (arr[i] < arr[n]) suffix[i] = true;
        }

        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (str[i - 1] == '(') {
                if (arr[n] != 2) continue;
            } else {
                if (arr[n] != -2) continue;
            }
            if (!prefix[i - 1] && !suffix[i]) cnt++;
        }
        System.out.println(cnt);
    }
}