import java.io.*;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static StringTokenizer st;

    static int N, M, Res;

    static ArrayList<int[]> NotMixList;

    static boolean[][] NotMixIce;

    static boolean[] visit;

    static void input() throws IOException
    {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visit = new boolean[N];

        NotMixIce = new boolean[N][N];

        NotMixList = new ArrayList<>();
        for (int i = 0 ; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int notMix1 = Integer.parseInt(st.nextToken()) - 1;
            int notMix2 = Integer.parseInt(st.nextToken()) - 1;
            NotMixIce[notMix2][notMix1] = true;
            NotMixIce[notMix1][notMix2] = true;
        }

    }

    static void pro() throws IOException
    {
        dfs(new int[]{-1, -1, -1}, 0,0);
        System.out.println(Res);
    }

    static void dfs(int[] mixIceArr, int curIdx, int depth) {

        if (depth == mixIceArr.length) {
            if (checkMixIce(mixIceArr)) Res++;
            return;
        }

        for (int i = curIdx; i < N; i++) {
            if (visit[i]) continue;
            visit[i] = true;
            mixIceArr[depth] = i;
            dfs(mixIceArr, i + 1,depth + 1);;
            mixIceArr[depth] = -1;
            visit[i] = false;
        }
    }

    static boolean checkMixIce(int[] mixIceArr) {

        if (NotMixIce[mixIceArr[0]][mixIceArr[1]]
                || NotMixIce[mixIceArr[2]][mixIceArr[1]]
                || NotMixIce[mixIceArr[0]][mixIceArr[2]]) return false;
        return true;
    }

    public static void main(String[] args) throws Exception{
        input();
        pro();

    }

}