import java.io.*;
import java.util.*;

public class Main {

    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static char[] str;
    static int[] arr, prefix, kArr;
    static int n;

    static void input() throws IOException {
        str = br.readLine().toCharArray();
        n = str.length;
    }

    static void pro() {
        arr = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            if (str[i - 1] == 'S') arr[i] = -2;
            else if (str[i - 1] == 'K') arr[i] = 1;
        }

        prefix = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }

        kArr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            kArr[i] = kArr[i - 1];

            if (arr[i] == 1) kArr[i]++;
        }

        int max = -1;

        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(0, 0);
        for (int i = 1; i <= n; i++) {
            if (map.containsKey(prefix[i])) {
                int prev = map.get(prefix[i]);
                if (kArr[i] - kArr[prev] > 0) {
                    max = Math.max(max, i - prev);
                }
            } else {
                map.put(prefix[i], i);
            }
        }

        System.out.println(max);
    }


    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}