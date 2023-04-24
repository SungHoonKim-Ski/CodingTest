import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n;
    static int[] InputArr;
    static StringBuffer sb;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        sb = new StringBuffer();
        StringTokenizer st = new StringTokenizer(br.readLine());
        InputArr = new int[n];
        for (int i = 0; i < n; i++) {
            InputArr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(cal_func());
    }

    static int cal_func() {

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n - 1; i++) {
            min = Math.min(min, Math.abs(InputArr[i] - InputArr[i + 1]));
        }
        return min;
    }
}
