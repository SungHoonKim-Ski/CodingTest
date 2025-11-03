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
        arr = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void pro() {
        int[] num = new int[n + 1];
        int[] temp = new int[n + 1];
        for (int i = 1; i <= n; i++) num[i] = i;

        long[] cycle = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (cycle[j] != 0) continue;
                temp[j] = num[arr[j]];
                if (temp[j] == j) {
                    cycle[j] = i;
                }
            }
            for (int j = 1; j <= n; j++) num[j] = temp[j];
        }

        long res = 1;
        for (int i = 1; i <= n; i++) {
            res = lcm(res, cycle[i]);
        }

//        System.out.println(Arrays.toString(cycle));
        System.out.println(res);
    }

    static long gcd(long a, long b) {
        if(b == 0) return a;
        return gcd(b, a % b);
    }

    static long lcm(long a, long b) {
        return a * b / gcd(a,b);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}