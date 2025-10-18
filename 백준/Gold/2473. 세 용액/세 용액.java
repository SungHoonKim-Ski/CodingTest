import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n;
    static long[] arr;

    static void input() throws IOException{
        n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        arr = new long[n];
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
    }

    static void pro() {
        Arrays.sort(arr);
        long min = Long.MAX_VALUE;
        long[] elements = new long[3];

        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                long sum = arr[i] + arr[left] + arr[right];
                long absSum = Math.abs(sum);
                if (absSum < min) {
                    min = absSum;
                    elements[0] = arr[i];
                    elements[1] = arr[left];
                    elements[2] = arr[right];
//                    System.out.println(min + " : " +Arrays.toString(elements));
                }

                if (sum <= 0) left++;
                else right--;
            }
        }
        sb.append(elements[0]).append(' ');
        sb.append(elements[1]).append(' ');
        sb.append(elements[2]);

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}