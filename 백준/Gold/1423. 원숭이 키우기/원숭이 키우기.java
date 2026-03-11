import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int n, d, size;
    static long sum;

    static int[] cnt;
    static long[] power;

    static ArrayList<Integer> list;

    static long[][] dp;

    static void input() throws IOException {
        n = Integer.parseInt(br.readLine());

        cnt = new int[n];
        power = new long[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            cnt[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            power[i] = Integer.parseInt(st.nextToken());
            sum += cnt[i] * power[i];
        }

        d = Integer.parseInt(br.readLine());
    }

    static void pro() {
        list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int max = Math.min(cnt[i], d);
            for (int j = 0; j < max; j++) {
                list.add(i);
            }
        }

        size = list.size();
        dp = new long[size][d + 1];
        for (int i = 0; i < size; i++) {
            Arrays.fill(dp[i], -1);
        }

        System.out.println(sum + recur(0, d));
    }

    static long recur(int depth, int remain) {
        if (depth == size) return 0;
        if (dp[depth][remain] != -1) return dp[depth][remain];

        long res = recur(depth + 1, remain);

        int level = list.get(depth);
        for (int i = level + 1; i < n; i++) {
            int cost = i - level;

            if (cost > remain) break;
            long p = power[i] - power[level];

            res = Math.max(res, p + recur(depth + 1, remain - cost));
        }

        return dp[depth][remain] = res;
    }


    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}