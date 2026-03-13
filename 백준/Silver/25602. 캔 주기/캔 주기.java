import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int n, k, max = -1;
    static int[] arr;
    static int[][] like1, like2;

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        like1 = new int[k][n];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                like1[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        like2 = new int[k][n];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                like2[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static void pro() {
        recur(0, 0);

        System.out.println(max);
    }

    static void recur(int depth, int sum) {
        if (depth == k) {
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) continue;
            arr[i]--;
            for (int j = 0; j < n; j++) {
                if (arr[j] == 0) continue;
                arr[j]--;
                recur(depth + 1, sum + like1[depth][i] + like2[depth][j]);
                arr[j]++;
            }
            arr[i]++;
        }
    }


    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}