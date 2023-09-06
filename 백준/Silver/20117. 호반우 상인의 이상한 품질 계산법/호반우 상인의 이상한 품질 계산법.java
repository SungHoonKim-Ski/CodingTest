import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer sb = new StringBuffer();
    static StringTokenizer st;
    static int n;

    static int[] arr;

    public static void input() throws IOException{


        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
    }

    public static void pro() {

        if (n == 1) {
            System.out.println(arr[0]);
        } else {
            Arrays.sort(arr);
            int sum = 0;
            for (int i = 0; i < n / 2; i++) {
                sum += (arr[n - i - 1] * 2);
            }
            if (n % 2 != 0) sum += arr[n / 2];
            System.out.println(sum);
        }
    }


    public static void main(String[] args) throws IOException{
        input();
        pro();
    }

}