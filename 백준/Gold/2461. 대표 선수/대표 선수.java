import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int n, m;
    static int[][] arr;

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static void pro() {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);

        int max = -1;
        for (int i = 0; i < n; i++) {
            Arrays.sort(arr[i]);

            pq.add(new int[] {arr[i][0], i, 0});
            max = Math.max(max, arr[i][0]);
        }

        int res = 1 << 30;
        while (true) {
            int[] cur = pq.poll();
            int value = cur[0];

            res = Math.min(res, max - value);

            if (cur[2] + 1 == m) break;

            pq.add(new int[] {arr[cur[1]][cur[2] + 1], cur[1], cur[2] + 1});
            max = Math.max(max, arr[cur[1]][cur[2] + 1]);
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}