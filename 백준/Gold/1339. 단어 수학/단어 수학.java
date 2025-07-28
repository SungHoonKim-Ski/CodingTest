import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n;
    static int[] weight;
    static char[][] words;

    static void input() throws Exception {
        n = Integer.parseInt(br.readLine());

        words = new char[n][];
        for (int i = 0; i < n; i++) {
            words[i] = br.readLine().toCharArray();
        }
    }

    public static void pro() {
        int[] weights = new int['Z' - 'A' + 1];

        for (int i = 0; i < n; i++) {
            int len = words[i].length;
            for (int j = 0; j < len; j++) {
                weights[words[i][j] - 'A'] += Math.pow(10, len - j - 1);
            }
        }

        Arrays.sort(weights);
        int res = 0;
        int curNum = 9;
        for (int i = 'Z' - 'A'; i >= 0; i--) {
            if (weights[i] == 0) break;
            res += weights[i] * curNum;
            curNum--;
        }
        System.out.println(res);
    }

    public static void main(String[] args) throws Exception {
        input();
        pro();
    }
}