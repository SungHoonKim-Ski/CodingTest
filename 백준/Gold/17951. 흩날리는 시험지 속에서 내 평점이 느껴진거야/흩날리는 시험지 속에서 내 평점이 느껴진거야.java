import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer sb = new StringBuffer();
    static StringTokenizer st;
    static int n, k, avg, sum;
    static int[] arr;

    public static void input() throws IOException{


        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
        }
        avg = sum / k;
    }

    public static void pro() {

        int minScore = Integer.MIN_VALUE;

        int L = 0, R = 2000001;
        while (L + 1 < R) {

            int mid = (L + R) / 2;
            int scoreSum = 0;
            int groupCnt = 0;
            for (int i = 0; i < n; i++) {
                scoreSum += arr[i];
                if (scoreSum >= mid) {
                    groupCnt++;
                    scoreSum = 0;
                }
            }

            if (groupCnt >= k) L = mid;
            else R = mid;
        }
        System.out.println(L);
    }



    public static void main(String[] args) throws IOException{
        input();
        pro();
    }

}
