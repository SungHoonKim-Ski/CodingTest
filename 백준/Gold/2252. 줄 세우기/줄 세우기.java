import java.util.*;
import java.io.*;

public class Main {

    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static ArrayList<Integer>[] graph;
    static int n, m;
    static int[] indeg;

    static void input() throws IOException {

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        indeg = new int[n + 1];
        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());

            int low = Integer.parseInt(st.nextToken());
            int high = Integer.parseInt(st.nextToken());

            graph[low].add(high);
            indeg[high]++;
        }
    }

    static void toplogic() {

        Deque<Integer> que = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            if (indeg[i] == 0) que.add(i);
        }

        while (!que.isEmpty()) {
            int low = que.poll();
            sb.append(low).append(' ');

            for (int high : graph[low]) {
                if (indeg[high] == 0) continue;
                indeg[high]--;
                if (indeg[high] == 0) que.add(high);
            }
        }
        System.out.println(sb);
    }

    static void pro(){
        toplogic();
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}