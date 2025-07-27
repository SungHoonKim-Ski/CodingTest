import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static List<Integer> cmdList;
    static int cmdSize, MAX = 500_000;
    static int[][] powers = {
            {0, 2, 2, 2, 2},
            {2, 1, 3, 4, 3},
            {2, 3, 1, 3, 4},
            {2, 4, 3, 1, 3},
            {2, 3, 4, 3, 1}
    };

    static int[][][] dp;

    static void input() throws Exception {
        cmdList = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        while (st.hasMoreElements()) {
            int in = Integer.parseInt(st.nextToken());
            if (in == 0) break;
            cmdList.add(in);
        }

        cmdSize = cmdList.size();
    }

    public static void pro() {
        dp = new int[cmdSize][5][5];
        for (int i = 0; i < cmdSize; i++)
            for (int j = 0; j < 5; j++)
                Arrays.fill(dp[i][j], -1);

        System.out.println(recur(0, 0, 0));
    }

    static int recur(int idx, int left, int right) {
        if (idx == cmdSize) return 0;

        if (dp[idx][left][right] != -1) return dp[idx][left][right];
        
        int cmd = cmdList.get(idx);
        int leftPower = recur(idx + 1, cmd, right) + powers[left][cmd];
        int rightPower = recur(idx + 1, left, cmd) + powers[right][cmd];

        return dp[idx][left][right] = Math.min(leftPower, rightPower);
    }

    public static void main(String[] args) throws Exception {
        input();
        pro();
    }
}