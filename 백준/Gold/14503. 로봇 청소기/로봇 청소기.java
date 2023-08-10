import java.io.*;
import java.util.*;

public class Main {


    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer sb = new StringBuffer();
    static StringTokenizer st;
    static int N, M, CurY, CurX, D;

    // 0 북 1 동 2 남 3서
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static int[][] NeedClean;

    static int NeedCleanCnt;

    static void input() throws Exception{

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        CurY = Integer.parseInt(st.nextToken());
        CurX = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        NeedClean = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                if (st.nextToken().charAt(0) == '1') { // 벽인경우
                    NeedClean[i][j] = -1;
                } else { // 벽이 아닌 경우 = 청소 필요
                    NeedCleanCnt++;
                }
            }

        }

    }

    static void pro(){

        int cleanCnt = 0;
        while (cleanCnt != NeedCleanCnt) {
//            현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소한다.

            if (NeedClean[CurY][CurX] == 0) {
                NeedClean[CurY][CurX]++;
                cleanCnt++;
            }

            boolean checkAround = false;
            for (int i = 0; i < 4; i++) {
                int ny = CurY + dy[i];
                int nx = CurX + dx[i];
                if (!checkValid(ny, nx)) continue;
                if (NeedClean[ny][nx] == 0) {
                    checkAround = true;
                    break;
                }
            }

//            2. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우,
    //            2A. 바라보는 방향을 유지한 채로 한 칸 후진할 수 있다면 한 칸 후진하고 1번으로 돌아간다.
    //            2B. 바라보는 방향의 뒤쪽 칸이 벽이라 후진할 수 없다면 작동을 멈춘다.
            if (!checkAround) {
                int ny = CurY - dy[D];
                int nx = CurX - dx[D];
                if (!checkValid(ny, nx)) break;
                if (NeedClean[ny][nx] == -1) break;
                CurY = ny;
                CurX = nx;
            } else {
//            현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우,
//                    3A. 반시계 방향으로 90' 회전한다.
//                    3B. 바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않은 빈 칸인 경우 한 칸 전진한다.
//                    3C. 1번으로 돌아간다.
                D = (D - 1 + 4) % 4;
                int ny = CurY + dy[D];
                int nx = CurX + dx[D];
                if (!checkValid(ny, nx)) continue;
                if (NeedClean[ny][nx] == 0) {
                    CurY = ny;
                    CurX = nx;
                }
            }
        }

        System.out.println(cleanCnt);

    }

    public static boolean checkValid(int y, int x) {
        if (y == -1 || x == -1 || y == N || x == M) return false;
        return true;
    }

    public static void main(String[] args) throws Exception{

        input();
        pro();
    }

}