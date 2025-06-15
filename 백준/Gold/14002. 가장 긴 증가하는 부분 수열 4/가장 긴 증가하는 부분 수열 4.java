import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n;
    static int[] sequence;
    static int[] dp;
    static int[] prev;

    static void input() throws Exception {
        n = Integer.parseInt(br.readLine());
        sequence = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }
    }

    public static void pro() {
        dp = new int[n + 1];
        prev = new int[n + 1];
        for (int i = 1; i <= n; i++) prev[i] = i;

        int max = 0, index = 0;

        for (int i = 1; i <= n; i++) {
            int cur = sequence[i];
            dp[i] = 1;

            for (int j = 0; j < i; j++) {
                if (sequence[j] >= cur) continue;
                if (dp[i] <= dp[j]) {
                    prev[i] = j;
                    dp[i] = dp[j] + 1;
                }
            }
            if (dp[i] > max) {
                max = dp[i];
                index = i;
            }
        }

        sb.append(max).append('\n');

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.add(sequence[index]);
        while (prev[index] != index) {
            index = prev[index];
            stack.add(sequence[index]);
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pollLast()).append(' ');
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception{
        input();
        pro();
    }
}