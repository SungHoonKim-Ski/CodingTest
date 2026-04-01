import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static long[] arr, brr;

    static void input() throws IOException {
        arr = new long[3];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        brr = new long[3];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) {
            brr[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void pro() {
        long cnt = 0;
        int i = 0;
        while(true) {
            if (brr[0] < 3 && brr[1] < 3 && brr[2] < 3) break;
            long c = Math.min(arr[i], brr[i]);
            brr[i] -= c;
            arr[i] -= c;
            brr[(i + 1) % 3] += brr[i] / 3;
            brr[i] %= 3;

            cnt += c;

            i++;
            i %= 3;
        }

        for (i = 0; i < 3; i++) {
            long c = Math.min(arr[i], brr[i]);
            cnt += c;
        }

        System.out.println(cnt);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}