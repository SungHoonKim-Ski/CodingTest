import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n;

    static int[] arr;

    static void input() throws IOException{

        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        for (int i = 1; i <= n; i++) arr[i] = Integer.parseInt(br.readLine());
    }

    static void pro() {

        Arrays.sort(arr, 1, n + 1);

        long sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += Math.abs(arr[i] - i);
        }
        System.out.println(sum);

    }

    public static void main(String[] args) throws Exception{
        input();
        pro();
    }
}