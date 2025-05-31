import java.io.*;
import java.util.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, m;
    static int[] time;
    static int[][] info;
    static int[] prefixSumTime;

    static void input() throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        time = new int[n];
        prefixSumTime = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) time[i] = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) {
            prefixSumTime[i] = prefixSumTime[i - 1] + time[i - 1];
        }


        info = new int[m][3];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            info[i] = new int[] {
                    Integer.parseInt(st.nextToken()) - 1
                    , Integer.parseInt(st.nextToken()) - 1
                    , Integer.parseInt(st.nextToken())
            };
        }
    }

    public static void pro() {

        int maxTime = 0;
        int returnZeroTime = prefixSumTime[n];

        for (int i = 0; i < m; i++) {
            int[] cur = info[i];
            int start = cur[0];
            int end = cur[1];
            int wait = cur[2];

            int startTime = prefixSumTime[start];
            
            int endTime = prefixSumTime[end];
            if (end <= start) endTime += returnZeroTime;
            
            int waitCycle = (wait - startTime + returnZeroTime - 1) / returnZeroTime;
            if (waitCycle < 0) waitCycle = 0;
            
            int insertTime = startTime + waitCycle * returnZeroTime;
            int deleteTime = insertTime + (endTime - startTime);

            maxTime = Math.max(maxTime, deleteTime);
        }

        System.out.println(maxTime);


    }


    public static void main(String[] args) throws Exception{
        input();
        pro();
    }
}
