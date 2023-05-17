import java.io.*;
import java.util.StringTokenizer;

class Solution {


    static StringBuilder sb = new StringBuilder();
    static BufferedReader br;
    static StringTokenizer st;

    static int N, K;
    static int[][] DP;
    static int[] V, C;


    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        DP = new int[N + 1][K + 1];
        V = new int[N + 1];
        C = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            V[i] = Integer.parseInt(st.nextToken());
            C[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void pro(int tc) throws Exception{

        for (int i = 1; i <= N; i++) {
            for (int w = 1; w <= K; w++) {
                DP[i][w] = DP[i - 1][w];
                if (w - V[i] >= 0) {
                    DP[i][w] = Math.max(DP[i - 1][w], DP[i - 1][w - V[i]] + C[i]);
                }
            }
        }
        sb.append(String.format("#%d %d\n", tc, DP[N][K]));
    }

    public static void main(String[] args) throws Exception{

        br = new BufferedReader(new InputStreamReader(System.in));
//        br = new BufferedReader(new InputStreamReader(new FileInputStream("res/input.txt")));
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++) {
            input();
            pro(tc);
        }
        System.out.println(sb);

    }

}