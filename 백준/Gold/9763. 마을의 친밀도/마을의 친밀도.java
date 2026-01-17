import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int n;
    static int[][] arr;

    static void input() throws IOException {
        n = Integer.parseInt(br.readLine());

        arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken()) + 1000;
            }
        }
    }

    static void pro() {
        int min = 1 << 30;
        for (int i = 0; i < n; i++) {
            int min1 = 1 << 30, min2 = 1 << 30;

            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                int d = diff(i, j);
                if (d < min1) {
                    min2 = min1;
                    min1 = d;
                    continue;
                }
                if (d < min2) {
                    min2 = d;
                }
            }
            min = Math.min(min, min1 + min2);
        }

        System.out.println(min);
    }

    static int diff(int a, int b) {
        int x = Math.abs(arr[a][0] - arr[b][0]);
        int y = Math.abs(arr[a][1] - arr[b][1]);
        int z = Math.abs(arr[a][2] - arr[b][2]);

        return x + y + z;
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
