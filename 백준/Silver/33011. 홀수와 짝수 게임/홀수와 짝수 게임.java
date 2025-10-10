import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n;
    static int arr[];

    static void input() throws IOException{
        n = Integer.parseInt(br.readLine());
        arr = new int[2];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(st.nextToken());
            arr[x % 2]++;
        }
    }

    static void pro() {
        int x = Math.max(arr[0], arr[1]);
        if (x % 2 == 0) {
            sb.append("heeda0528");
        } else {
            if (arr[0] == arr[1]) sb.append("heeda0528");
            else sb.append("amsminn");
        }
        sb.append('\n');
    }

    public static void main(String[] args) throws IOException {
        int q = Integer.parseInt(br.readLine());

        while (q-- > 0) {
            input();
            pro();
        }
        System.out.println(sb);
    }
}