import java.io.*;
import java.util.*;

public class Main {

    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int[] arr, brr, crr;
    static int n;

    static void input() throws IOException {
        n = Integer.parseInt(br.readLine());

        arr = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        brr = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            brr[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void pro() {
        crr = new int[n + 1];
        int[] sum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            crr[i] = arr[i] - brr[i];
            sum[i] = sum[i - 1] + crr[i];
        }

        long cnt = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 1; i <= n; i++) {
            if (map.containsKey(sum[i])) {
                cnt += map.get(sum[i]);
            }
            map.put(sum[i], map.getOrDefault(sum[i], 0) + 1);
        }

        System.out.println(cnt);
    }


    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}