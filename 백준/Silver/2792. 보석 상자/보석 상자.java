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
        R *= 2; // L의 초기값은 0이고 R의 최대값은 보석들 중 최대값 즉
        // 보석의 종류만큼만 아이들에게 나누어 줄 수 있게 하는 값이므로
        // 최대값에 2를 곱해주면 mid가 초기 최대값으로 나옴 
        while (L < R) {
            int stdCnt = 0;
            int mid = (L + R) / 2;
            
            if (mid == L) break; 
            // 무한 루프 방지
            // 더이상 나눌 수 없는 경우
            
            for (int i = 0; i < m; i++) {
                stdCnt += jewelCnt[i] / mid;
                if (jewelCnt[i] % mid != 0) stdCnt++;
            }
            if (stdCnt > n) { 
                // 보석을 mid만큼씩 나누어 줬을 때
                // 모든 아이들에게 나누어줄 수 없는 경우
                L = mid;
            } else { 
                // 가능한 경우
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