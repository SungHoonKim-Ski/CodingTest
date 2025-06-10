import java.io.*;
import java.util.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, score;
    static int[] answer;

    static void input() throws Exception {
        n = 10;
        answer = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) answer[i] = Integer.parseInt(st.nextToken());
    }

    public static void pro() {
        recur(1, null, 0);
        System.out.println(score);
    }

    public static void recur(int depth, int[] prev, int curScore) {
        if (depth > n) {
            if (curScore >= 5) score++;
            return;
        }

        for (int i = 1; i <= 5; i++) {
            int nextScore = curScore;
            if (answer[depth] == i) nextScore++;

            if (prev == null) {
                recur(depth + 1, new int[] {i, -1}, nextScore);
            } else {
                if (prev[0] == prev[1] && prev[1] == i) continue;
                recur(depth + 1, new int[] {i, prev[0]}, nextScore);
            }
        }
    }

    public static void main(String[] args) throws Exception{
        input();
        pro();
    }
}