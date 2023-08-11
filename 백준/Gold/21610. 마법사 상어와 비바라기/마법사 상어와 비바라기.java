import java.util.*;
import java.io.*;
import java.math.*;


public class Main
{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer sb = new StringBuffer();
    static StringTokenizer st;
    static int N, M;

    static long[][] Board;

    static int[] DArr; // 방향
    static int[] SArr; // 명령


    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};

    static HashSet<Cloud> CloudSet;

    static class Cloud{
        int y, x;
        Cloud(int y, int x) {
            this.y = y;
            this.x = x;
        }

        @Override
        public int hashCode() {
            return (y * 1000003) ^ (x * 1000003);
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Cloud) {
                return y == ((Cloud)obj).y && x == ((Cloud)obj).x;
            } else return false;
        }
    }
    
    public static void input() throws IOException{

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Board = new long[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) Board[i][j] = Integer.parseInt(st.nextToken());
        }

        DArr = new int[M];
        SArr = new int[M];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            DArr[i] = Integer.parseInt(st.nextToken());
            SArr[i] = Integer.parseInt(st.nextToken());
        }

    }

    public static void pro() {

        CloudSet = new HashSet<>();
        CloudSet.add(new Cloud(N, 1));
        CloudSet.add(new Cloud(N, 2));
        CloudSet.add(new Cloud(N - 1, 1));
        CloudSet.add(new Cloud(N - 1, 2));

        for (int i = 0; i < M; i++) {

//            1. 모든 구름이 di 방향으로 si칸 이동한다.
            move(DArr[i] - 1, SArr[i]);

//            2. 각 구름에서 비가 내려 구름이 있는 칸의 바구니에 저장된 물의 양이 1 증가한다.
//            3. 구름이 모두 사라진다.
             addWater();

//            4. 2에서 물이 증가한 칸 (r, c)에 물복사버그 마법을 시전한다.
//            물복사버그 마법을 사용하면, 대각선 방향으로 거리가 1인 칸에
//            물이 있는 바구니의 수만큼 (r, c)에 있는 바구니의 물이 양이 증가한다.
//              4-a. 이때는 이동과 다르게 경계를 넘어가는 칸은 대각선 방향으로 거리가 1인 칸이 아니다.
//                   예를 들어, (N, 2)에서 인접한 대각선 칸은 (N-1, 1), (N-1, 3)이고,
//                   (N, N)에서 인접한 대각선 칸은 (N-1, N-1)뿐이다.
            bug();
            
            addCloud();
//            5. 바구니에 저장된 물의 양이 2 이상인 모든 칸에 구름이 생기고, 물의 양이 2 줄어든다.
//                  이때 구름이 생기는 칸은 3에서 구름이 사라진 칸이 아니어야 한다.
        }

        long cnt = 0;
        for (int i = 1; i <= N; i++) for (int j = 1; j <= N; j++) cnt += Board[i][j];
        System.out.println(cnt);

    }

    static void move(int d, int s) {

        HashSet<Cloud> newClout = new HashSet<>();

        s %= N;
        for (Cloud cloud : CloudSet) {
            int ny = cloud.y;
            for (int i = 0; i < s; i++) {
                ny += dy[d];
                if (ny == N + 1) ny = 1;
                else if (ny == 0) ny = N;
            }

            int nx = cloud.x;
            for (int i = 0; i < s; i++) {
                nx += dx[d];
                if (nx == N + 1) nx = 1;
                else if (nx == 0) nx = N;
            }

            newClout.add(new Cloud(ny, nx));
        }
        CloudSet = new HashSet<>(newClout);
    }
    
    static void addWater() {
        for (Cloud cloud : CloudSet) Board[cloud.y][cloud.x]++;
    }
    
    static void bug() {
        for (Cloud cloud : CloudSet) {
            for (int i = 1; i < 8; i+= 2) {
                int ny = cloud.y + dy[i];
                int nx = cloud.x + dx[i];
                if (ny == 0 || nx == 0 || ny == (N + 1) || nx == (N + 1)) continue;
                if (Board[ny][nx] == 0) continue;
                Board[cloud.y][cloud.x]++;
            }
        }
    }
    
    static void addCloud() {
        HashSet<Cloud> newClout = new HashSet<>();
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (CloudSet.contains(new Cloud(i, j))) continue;
                if (Board[i][j] >= 2) {
                    Board[i][j] -= 2;
                    newClout.add(new Cloud(i, j));
                }
            }
        }
        CloudSet = new HashSet<>(newClout);
    }
        
    public static void main(String args[]) throws IOException
    {
        input();
        pro();

    }
}