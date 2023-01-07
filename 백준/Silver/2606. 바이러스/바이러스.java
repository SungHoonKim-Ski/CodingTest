import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static BufferedReader br;
    static StringBuffer sb;

    public static void main(String[] args) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuffer();

        int n = Integer.parseInt(br.readLine()) + 1;
        int m = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][n];
        StringTokenizer st;
        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr[x][y] = 1;
            arr[y][x] = 1;
        }

        boolean[] isWarm = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        while (!queue.isEmpty()) {
            int warm = queue.poll();
            isWarm[warm] = true;

            for (int i=1; i < n; i++) {
                if (!isWarm[i] && arr[warm][i] == 1) {
                    queue.add(i);
                }
            }
        }

        int res = 0;
        for (int i=2; i<n; i++) {
            if (isWarm[i]) res++;
        }

        System.out.println(res);
    }
}