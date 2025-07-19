import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n;
    static int[] arr;

    static void input() throws Exception {
        n = Integer.parseInt(br.readLine());

        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }

    public static void pro() {
        int left = 0;
        int[] count = new int[10];

        int max = 0, kinds = 0;
        for (int right = 0; right < n; right++) {
            if (count[arr[right]] == 0) {
                kinds++;
            }
            count[arr[right]]++;

            while (kinds > 2) {
                count[arr[left]]--;
                if (count[arr[left]] == 0) kinds--;
                left++;
            }

            max = Math.max(max, right - left + 1);
        }

        System.out.println(max);
    }

    public static void main(String[] args) throws Exception{
        input();
        pro();
    }
}