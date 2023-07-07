import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[][] Scores;
    static int[] ScoreSum;
    static void input(){

        N = scan.nextInt();
        Scores = new int[3][3];
        ScoreSum = new int[3];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(scan.nextLine());
            for (int j = 0; j < 3; j++) {
                int score = Integer.parseInt(st.nextToken());
                Scores[j][score - 1]++;
                ScoreSum[j] += score;
            }
        }
    }

    static void pro() {

        int maxScore = calMaxScore();
        int maxScoreCnt = maxScoreCnt(maxScore);

        if (maxScoreCnt == 1) sb.append(findMaxScoreIdx(maxScore)).append(' ').append(maxScore);
        else {

            int maxIdx = findMaxScoreIdx(maxScore);
            boolean isSame = false;
            for (int i = 0; i < 2; i++) {
                if (ScoreSum[i] != maxScore) continue;
                for (int j = i + 1; j < 3; j++) {
                    if (ScoreSum[j] != maxScore) continue;
                    maxIdx = compareScore(i, j);
                    if (maxIdx == -1) {
                        isSame = true;
                    }else isSame = false;
                }
                if (isSame) break;
            }
            if (isSame) sb.append(0).append(' ').append(maxScore);
            else sb.append(maxIdx + 1).append(' ').append(maxScore);
        }
        System.out.println(sb);

    }

    static int compareScore(int idx1, int idx2) {
        for (int i = 2; i >= 0; i--) {
            if (Scores[idx1][i] == Scores[idx2][i]) continue;
            if (Scores[idx1][i] > Scores[idx2][i]) return idx1;
            else return idx2;
        }
        return -1;
    }
    static int calMaxScore() {
        int max = 0;
        for (int i = 0; i < 3; i++) {
            max = Math.max(ScoreSum[i], max);
        }
        return max;
    }

    static int maxScoreCnt(int maxScore) {

        int cnt = 0;
        for (int i = 0; i < 3; i++) {
            if (maxScore == ScoreSum[i]) cnt++;
        }
        return cnt;
    }

    static int findMaxScoreIdx(int maxScore) {

        int idx = -1;
        for (int i = 0; i < 3; i++) {
            if (maxScore == ScoreSum[i]) {
                idx = i + 1;
            }
        }
        return idx;
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }


    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}