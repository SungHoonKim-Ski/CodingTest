import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer sb = new StringBuffer();
    static StringTokenizer st;
    static int n, h, nDivTwo;

    static int[] bottomRock, topRock;

    public static void input() throws IOException{


        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        nDivTwo = n / 2;
        bottomRock = new int[nDivTwo];
        topRock = new int[nDivTwo];

        for (int i = 0; i < nDivTwo; i++) {
            bottomRock[i] = Integer.parseInt(br.readLine());
            topRock[i] = Integer.parseInt(br.readLine());
        }
    }

    public static void pro() {

        Arrays.sort(topRock);
        Arrays.sort(bottomRock);

        int minBreakCnt = n; // 부신 장애물의 수
        int breakSpaceCnt = 0; // 해당 벽 만큼 부신 구간의 수

        for (int i = 1; i <= h; i++) {
            int breakWallCnt = binarySearch(i, bottomRock) + binarySearch(h - i + 1, topRock);
            if (minBreakCnt == breakWallCnt) {
                breakSpaceCnt++;
                continue;
            }
            if (minBreakCnt > breakWallCnt) {
                breakSpaceCnt = 1;
                minBreakCnt = breakWallCnt;
            }
        }
        sb.append(minBreakCnt).append(' ').append(breakSpaceCnt);
        System.out.println(sb);
    }

    static int binarySearch(int height, int[] rock) {
        int left = 0;
        int right = n / 2;

        while (left < right) {
            int mid = (left + right) / 2;
            if (rock[mid] >= height) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nDivTwo - right;
    }

    public static void main(String[] args) throws IOException{
        input();
        pro();
    }

}