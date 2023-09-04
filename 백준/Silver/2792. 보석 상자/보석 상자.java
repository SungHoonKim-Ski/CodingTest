import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer sb = new StringBuffer();
    static StringTokenizer st;
    static int n, m;

    static int R, L;

    static int[] jewelCnt;

    public static void input() throws IOException{


        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        jewelCnt = new int[m];
        for (int i = 0; i < m; i++) {
            jewelCnt[i] = Integer.parseInt(br.readLine());
            R = Math.max(jewelCnt[i], R);
        }
    }

    public static void pro() {

        int vaildMid = 0;
        R *= 2;
        while (L <= R) {
            int stdCnt = 0;
            int mid = (L + R) / 2;
            if (mid == L) break;
            for (int i = 0; i < m; i++) {
                stdCnt += jewelCnt[i] / mid;
                if (jewelCnt[i] % mid != 0) stdCnt++;
            }
            if (stdCnt > n) {
                L = mid;
            } else { // 가능한 경우
                vaildMid = mid;
                R = mid;
            }
        }
        System.out.println(vaildMid);
    }



    public static void main(String[] args) throws IOException{
        input();
        pro();
    }

}