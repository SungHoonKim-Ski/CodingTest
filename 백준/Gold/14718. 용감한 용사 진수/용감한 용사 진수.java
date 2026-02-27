import java.io.*;
import java.util.*;

public class Main {

    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int n, k, min = 1 << 30;
    static int[][] arr;
    static boolean[] visit;

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n][3];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static void pro() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    int x = arr[i][0];
                    int y = arr[j][1];
                    int z = arr[k][2];

                    if (check(x, y, z)) {
                        min = Math.min(min, x + y + z);
                    }
                }
            }
        }

        System.out.println(min);
    }

    static boolean check(int x, int y, int z) {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (x >= arr[i][0] && y >= arr[i][1] && z >= arr[i][2]) {
                cnt++;
            }
        }

        return cnt >= k;
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}