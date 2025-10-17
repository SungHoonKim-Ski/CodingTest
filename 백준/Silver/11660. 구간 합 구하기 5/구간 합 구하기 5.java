import java.io.*;
import java.util.*;

public class Main {

    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int n, k;
    static int[][] map;

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static void pro() throws IOException {
        int[][] prefixSum = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                prefixSum[i][j] = prefixSum[i][j - 1] + map[i][j];
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                prefixSum[j][i] += prefixSum[j - 1][i];
            }
        }

        while (k-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            if (x1 == 1 && y1 == 1) {
                sb.append(prefixSum[x2][y2]);
            }
            else if (x1 == 1) {
                sb.append(prefixSum[x2][y2] - prefixSum[x2][y1 - 1]);
            }
            else if (y1 == 1) {
                sb.append(prefixSum[x2][y2] - prefixSum[x1 - 1][y2]);
            } else {
                sb.append(
                    prefixSum[x2][y2]
                        - prefixSum[x1 - 1][y2]
                        - prefixSum[x2][y1 - 1]
                        + prefixSum[x1 - 1][y1 - 1]
                );
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}