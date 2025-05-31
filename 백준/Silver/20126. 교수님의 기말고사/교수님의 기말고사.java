import java.io.*;
import java.util.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, m, s;
    static int[][] times;

    static void input() throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        times = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            times[i] = new int[] {start, end};
        }
    }

    public static void pro() {
        Arrays.sort(times, (o1, o2) -> (o1[0] != o2[0] ? o1[0] -o2[0] : o1[1] - o2[1]));

        int cur = 0;
        for (int[] time: times) {
            if (time[0] - cur >= m) {
                if (cur + m <= s) System.out.println(cur);
                return;
            } else {
                cur = time[0] + time[1];
            }
        }
        if (cur + m <= s) System.out.println(cur);
        else System.out.println(-1);
    }



    public static void main(String[] args) throws Exception{
        input();
        pro();
    }
}
