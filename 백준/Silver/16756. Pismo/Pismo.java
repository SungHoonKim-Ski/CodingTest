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

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
    }

    static void pro() {
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n - 1; i++) {
            res = Math.min(res, Math.abs(arr[i] - arr[i + 1]));
        }
        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}