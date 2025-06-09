import java.io.*;
import java.util.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, x;
    static int[] visitNum;

    static void input() throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        visitNum = new int[n];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            visitNum[i] = Integer.parseInt(st.nextToken());
        }
    }

    public static void pro() {
        int sum = 0;
        for (int i = 0; i < x; i++) {
            sum += visitNum[i];
        }
        int max = sum;
        int count = sum != 0 ? 1 : 0;
        
        int right = x;
        for (int left = 0; left < n - x; left++) {
            sum -= visitNum[left];
            sum += visitNum[right++];

            if (sum > max) {
                max = sum;
                count = 1;
                continue;
            }

            if (sum == max) count++;
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