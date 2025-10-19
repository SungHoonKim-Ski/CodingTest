import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static final int MAX = 20, MIN = 100_001;
    static int n, k;
    static int[] graph, singer;
    static int[][] nxt;

    /**
     * 진입차수가 2 이상인 곳에서 모이고 사이클이 생긴다.
     * 한 번 사이클에 들어오고 나면 사이클 내의 공연자는 만날 수 없다
     *
     * @throws IOException
     */

    static void input() throws IOException{
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        graph = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            graph[i] = Integer.parseInt(st.nextToken());
        }

        singer = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            singer[Integer.parseInt(st.nextToken())]++;
        }

        nxt = new int[MAX][n + 1];
        for (int i = 1; i <= n; i++) nxt[0][i] = graph[i];

        for (int i = 1; i < MAX; i++) {
            for (int j = 1; j <= n; j++) {
                nxt[i][j] = nxt[i - 1][nxt[i - 1][j]];
            }
        }
    }

    static void pro() {
        int left = 1, right = MIN, res = -1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (determination(mid)) {
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(res);
    }

    static boolean determination(int mid) {
        if (mid == 1) {
            for (int v = 1; v <= n; v++) if (singer[v] >= k) return true;
            return false;
        }

        int[] cur = new int[n + 1];
        for (int i = 1; i <= n; i++) cur[i] = singer[i];

        int shift = mid - 1;
        for (int p = 0; p < MAX; p++, shift >>= 1) {
            if ((shift & 1) == 0) continue;

            int[] next = new int[n + 1];
            for (int v = 1; v <= n; v++) {
                int to = nxt[p][v];
                int c = cur[v];
                if (c == 0) continue;
                next[to] += c;
                if (next[to] >= k) return true;
            }
            cur = next;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}