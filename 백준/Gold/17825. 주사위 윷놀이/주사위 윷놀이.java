import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static final int MAX = 33, END = 32;

    static int n = 10, maxScore = -1;
    static int[] dices, score;
    static ArrayList<Integer>[] graph;
    static boolean[] visit;

    static void input() throws IOException{
        dices = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) dices[i] = Integer.parseInt(st.nextToken());
    }

    static void pro() {
        score = new int[] {
            0,
            2, 4, 6, 8, 10, // 5
            12, 14, 16, 18, 20, // 10
            22, 24, 26, 28, 30, // 15
            32, 34, 36, 38, 40, // 20
            13, 16, 19, 25, 22,
            24, 28, 27, 26, 30,
            35, 0
        };

        graph = new ArrayList[MAX];
        for (int i = 0; i < MAX; i++) graph[i] = new ArrayList<>();
        for (int i = 0; i < 20; i++) graph[i].add(i + 1);

        graph[5].add(21);
        graph[21].add(22);
        graph[22].add(23);
        graph[23].add(24);

        graph[10].add(25);
        graph[25].add(26);
        graph[26].add(24);

        graph[15].add(27);
        graph[27].add(28);
        graph[28].add(29);
        graph[29].add(24);

        graph[24].add(30);
        graph[30].add(31);
        graph[31].add(20);

        graph[20].add(END);

        visit = new boolean[MAX];
        simulate(0, new int[] {0, 0, 0, 0}, 0);

        System.out.println(maxScore);
    }

    static void simulate(int depth, int[] loc, int curScore) {
        if (depth == 10) {
            maxScore = Math.max(maxScore, curScore);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (loc[i] == END) continue;

            int prev = loc[i];
            int move = dices[depth];
            int next = getNext(loc[i], move);
            if (visit[next]) continue;

            if (prev != 0) visit[prev] = false;
            if (next != END) visit[next] = true;

            loc[i] = next;
            simulate(depth + 1, loc, curScore + score[next]);

            loc[i] = prev;

            if (prev != 0) visit[prev] = true;
            if (next != END) visit[next] = false;
        }
    }

    static int getNext(int start, int moveCnt) {
        if (start == END) return END;

        int next;
        if (graph[start].size() == 1) {
            next = graph[start].get(0);
        } else {
            next = graph[start].get(1);
        }

        if (next == END) return END;
        for (int i = 1; i < moveCnt; i++) {
            next = graph[next].get(0);
            if (next == END) return END;
        }

        return next;
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}