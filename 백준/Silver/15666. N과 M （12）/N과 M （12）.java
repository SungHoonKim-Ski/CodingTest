import java.io.*;
import java.util.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, m;
    static int[] inputArr;
    static boolean[] visit;
    static HashSet<String> resultSet;

    static void input() throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        inputArr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            inputArr[i] = Integer.parseInt(st.nextToken());
        }
    }

    public static void pro() {
        Arrays.sort(inputArr);
        resultSet = new HashSet<>();
        visit = new boolean[n];

        backTrack(0, 0, new int[m]);

        System.out.println(sb);
    }

    static void backTrack(int depth, int idx, int[] elements) {
        if (depth == m) {
            StringBuilder curSb = new StringBuilder();
            for (int element: elements) {
                curSb.append(element).append(' ');
            }
            if (resultSet.add(curSb.toString())) {
                sb.append(curSb).append('\n');
            }
            return;
        }

        for (int i = idx; i < n; i++) {
            elements[depth] = inputArr[i];
            backTrack(depth + 1, i, elements);
        }
    }

    public static void main(String[] args) throws Exception{
        input();
        pro();
    }
}