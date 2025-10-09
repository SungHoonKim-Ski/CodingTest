import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n, start, maxSum;
    static ArrayList<Integer>[] graph;
    static int[] cost;

    static void input() throws IOException{
        n = Integer.parseInt(br.readLine());

        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();

        cost = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) cost[i] = Integer.parseInt(st.nextToken());

        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x].add(y);
            graph[y].add(x);
        }
    }

    static void pro() {
        start = 1;
        dfs(-1, start, cost[start]);

        int end = start;
        maxSum = 0;
        dfs(-1, start, cost[start]);

        sb.append(maxSum).append(' ').append(Math.min(start, end));
        System.out.println(sb);
    }

    static void dfs(int prev, int cur, int sum) {
        if (sum > maxSum) {
            start = cur;
            maxSum = sum;
        } else if (sum == maxSum) {
            start = Math.min(cur, start);
        }

        for (int next : graph[cur]) {
            if (next == prev) continue;
            dfs(cur, next, sum + cost[next]);
        }
    }


    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}