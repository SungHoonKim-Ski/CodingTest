import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int n, m;
    static long[][] map, ans, prefixSum;

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new long[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = Long.parseLong(st.nextToken());
            }
        }
    }

    static void pro() {
        ans = new long[n + 1][n + 1];
        prefixSum = new long[n + 2][n + 2];

        int mid = m / 2;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                prefixSum[i][j] += prefixSum[i - 1][j] + prefixSum[i][j - 1] - prefixSum[i - 1][j - 1];
                long cur = map[i][j] + prefixSum[i][j];
                
                if (i <= n - m + 1 && j <= n - m + 1) {
                    long bomb = -cur;
                    ans[i + mid][j + mid] = bomb;
                    
                    prefixSum[i][j] += bomb;
                    prefixSum[i + m][j] -= bomb;
                    prefixSum[i][j + m] -= bomb;
                    prefixSum[i + m][j + m] += bomb;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                sb.append(ans[i][j]).append(' ');
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