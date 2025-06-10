import java.io.*;
import java.util.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, m;
    static ArrayList<Integer>[] graph;

    static void input() throws Exception {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[b].add(a);
        }
    }

    public static void pro() {
        int max = 0;
        ArrayList<Integer> nums = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            int hackCnt = bfs(i);
            if (max < hackCnt) {
                max = hackCnt;
                nums.clear();
                nums.add(i);
                continue;
            }

            if (max == hackCnt) nums.add(i);
        }

        Collections.sort(nums);
        for (int num: nums) {
            sb.append(num).append(' ');
        }
        System.out.println(sb);
    }

    private static int bfs(int start) {
        boolean[] visit = new boolean[n + 1];

        Queue<Integer> que = new ArrayDeque<>();
        que.add(start);
        visit[start] = true;
        int count = -1;

        while (!que.isEmpty()) {
            int cur = que.poll();
            count++;

            for (int next: graph[cur]) {
                if (visit[next]) continue;
                visit[next] = true;
                que.add(next);
            }
        }

        return count;
    }

    public static void main(String[] args) throws Exception{
        input();
        pro();
    }
}