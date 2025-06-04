import java.io.*;
import java.util.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, r, q;
    static ArrayList<Integer>[] graph;
    static int[] dp;
    static boolean[] visit;

    static void input() throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();

        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }
    }

    public static void pro() throws IOException {
        dp = new int[n + 1];
        Arrays.fill(dp, -1);

        visit = new boolean[n + 1];
        recur(r);

        while (q-- > 0) {
            sb.append(dp[Integer.parseInt(br.readLine())]).append('\n');
        }
        System.out.println(sb);
    }

    static int recur(int cur) {
        visit[cur] = true;
        if (dp[cur] != -1) return -1;

        dp[cur] = 1;

        for (int next: graph[cur]) {
            if (visit[next]) continue;
            dp[cur] += recur(next);
        }

        return dp[cur];
    }

    public static void main(String[] args) throws Exception{
        input();
        pro();
    }
}