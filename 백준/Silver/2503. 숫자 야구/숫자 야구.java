import java.io.*;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static StringTokenizer st;

    static boolean[][][] ExpectedNum;
    static int N;
    static void input() throws IOException
    {
        N = Integer.parseInt(br.readLine());
        ExpectedNum = new boolean[10][10][10];
    }

    static void pro() throws IOException
    {

        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            char[] inputCharArr = st.nextToken().toCharArray();

            int strike = Integer.parseInt(st.nextToken());
            int ball = Integer.parseInt(st.nextToken());
            check(strike, ball, inputCharArr);
        }
        int cnt = 0;
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                if (i == j) continue;
                for (int k = 1; k < 10; k++) {
                    if (i == k) continue;
                    if (j == k) continue;
                    if (!ExpectedNum[i][j][k]) {
                        cnt++;
                    }
                }
            }
        }
        System.out.println(cnt);
    }

    static void check(int s, int b, char[] inputCharArr) {

        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                if (i == j) continue;
                for (int k = 1; k < 10; k++) {
                    if (i == k) continue;
                    if (j == k) continue;
                    int curStrike = 0, curBall = 0;
                    if (i == inputCharArr[0] - '0') curStrike++;
                    if (j == inputCharArr[1] - '0') curStrike++;
                    if (k == inputCharArr[2] - '0') curStrike++;

                    if (i == inputCharArr[1] - '0' || i == inputCharArr[2] - '0') curBall++;
                    if (j == inputCharArr[0] - '0' || j == inputCharArr[2] - '0') curBall++;
                    if (k == inputCharArr[0] - '0' || k == inputCharArr[1] - '0') curBall++;

                    if (s != curStrike || b != curBall) ExpectedNum[i][j][k] = true;

                }
            }
        }


    }


    public static void main(String[] args) throws Exception{
        input();
        pro();

    }

}