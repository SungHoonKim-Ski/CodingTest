import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static BufferedReader br;
    static StringBuffer sb;

    static int res = 0;
    static int[] Arr;
    static int N;
    static int[] DpArr;
    public static void main(String[] args) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuffer();

        N = Integer.parseInt(br.readLine());
        Arr = new int[N+1];
        DpArr = new int[N+1];
        Arr[0] = 0;
        DpArr[0] = 0;

        for (int i=1; i<=N; i++) {
            Arr[i] = Integer.parseInt(br.readLine());
        }

        DpArr[1] = Arr[1];
        if (N > 1) {
            DpArr[2] = Arr[1] + Arr[2];
        }

        System.out.println(dp(N));
    }

    public static int dp(int index) {
        if (index < 1) {
            return 0;
        }
        if (DpArr[index] == 0) {
            DpArr[index] = Math.max(dp(index-2), dp(index-3) + Arr[index-1]) + Arr[index];
        }
        return DpArr[index];
    }
}