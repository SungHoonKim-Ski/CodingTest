import java.io.*;
import java.util.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, x;
    static long[] prefixSum, visitNum;

    static void input() throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        visitNum = new long[n];
        prefixSum = new long[n];
        st = new StringTokenizer(br.readLine());

        prefixSum[0] = visitNum[0] = Integer.parseInt(st.nextToken());
        for (int i = 1; i < n; i++) {
            visitNum[i] = Integer.parseInt(st.nextToken());
            prefixSum[i] = prefixSum[i - 1] + visitNum[i];
        }
    }

    public static void pro() {
        long max = prefixSum[x - 1], count = 1;
        
        for (int i = x; i < n; i++) {
            long sum = prefixSum[i] - prefixSum[i - x];
            if (sum > max) {
                max = sum;
                count = 1;
                continue;
            }

            if (sum == max) {
                count++;
            }
        }

        if (max == 0) System.out.println("SAD");
        else {
            sb.append(max).append('\n').append(count);
            System.out.println(sb);
        }
    }

    public static void main(String[] args) throws Exception{
        input();
        pro();
    }
}