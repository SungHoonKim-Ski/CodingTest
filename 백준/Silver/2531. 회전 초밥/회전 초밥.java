import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, d, k, c;
    static int[] arr;
    static boolean exist;

    static void input() throws Exception {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if (arr[i] == c) exist = true;
        }
    }

    public static void pro() {
        int[] count = new int[d + 1];

        int max = 0, kinds = 0;
        int left = 0;
        for (int i = 0; i < k; i++) {
            if (count[arr[i]] == 0) kinds++;
            count[arr[i]]++;
        }

        max = kinds;

        for (int right = k; right < n * 2; right++) {
            if (count[arr[right % n]] == 0) kinds++;
            count[arr[right % n]]++;

            count[arr[left % n]]--;
            if (count[arr[left % n]] == 0) kinds--;
            left++;

            max = Math.max(max, kinds);
            
            if (count[c] == 0) max = Math.max(max, kinds + 1);
        }

        System.out.println(max);
    }

    public static void main(String[] args) throws Exception{
        input();
        pro();
    }
}