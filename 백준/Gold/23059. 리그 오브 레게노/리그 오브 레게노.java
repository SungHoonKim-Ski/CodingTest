import java.io.*;
import java.util.*;

public class Main {

    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static HashMap<String, Integer> nameMap;
    static HashMap<Integer, String> idxMap;
    static ArrayList<Integer>[] graph;
    static int[] indeg;
    static int n, m, idx;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        m = n * 2;

        nameMap = new HashMap<>();
        idxMap = new HashMap<>();
        graph = new ArrayList[m + 1];
        for (int i = 0; i <= m; i++) graph[i] = new ArrayList<>();

        indeg = new int[m + 1];
        idx = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            String a = st.nextToken();
            String b = st.nextToken();

            int x, y;

            if (nameMap.containsKey(a)) x = nameMap.get(a);
            else {
                x = idx;
                nameMap.put(a, x);
                idx++;
            }

            if (nameMap.containsKey(b)) y = nameMap.get(b);
            else {
                y = idx;
                nameMap.put(b, y);
                idx++;
            }

            idxMap.put(x, a);
            idxMap.put(y, b);

            indeg[y]++;
            graph[x].add(y);
        }
        PriorityQueue<String> pq = new PriorityQueue<>();
        Queue<Integer> que = new ArrayDeque<>();

        int cnt = 0;
        for (int i = 0; i < idx; i++) {
            if (indeg[i] == 0) {
                pq.add(idxMap.get(i));
                cnt++;
            }
        }

        while (true) {
            if (pq.isEmpty()) break;

            while(!pq.isEmpty()) {
                que.add(nameMap.get(pq.poll()));
            }

            while (!que.isEmpty()) {
                int cur = que.poll();
                sb.append(idxMap.get(cur)).append('\n');

                for (int nxt : graph[cur]) {
                    indeg[nxt]--;
                    if (indeg[nxt] == 0) {
                        cnt++;
                        pq.add(idxMap.get(nxt));
                    }
                }
            }
        }

        if (idx == cnt) System.out.println(sb);
        else System.out.println(-1);
    }
}