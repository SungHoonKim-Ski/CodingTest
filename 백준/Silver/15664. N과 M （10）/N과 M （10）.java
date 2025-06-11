import java.io.*;
import java.util.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, m;
    static int[] inputArr;
    static boolean[] visit;
    static TreeSet<String> resultSet;

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
        resultSet = new TreeSet<>(
                (o1, o2) -> {
                    String[] o1Arr = o1.split(" ");
                    String[] o2Arr = o2.split(" ");

                    for (int i = 0; i < o1Arr.length; i++) {
                        if (o1Arr[i].equals(o2Arr[i])) continue;
                        int curO1 = Integer.parseInt(o1Arr[i]);
                        int curO2 = Integer.parseInt(o2Arr[i]);

                        return curO1 - curO2;
                    }
                    return 0;
                });
        visit = new boolean[n];

        backTrack(0, 0, new int[m]);

        for (String result: resultSet) {
            sb.append(result).append('\n');
        }
        System.out.println(sb);
    }

    static void backTrack(int depth, int idx, int[] elements) {
        if (depth == m) {
            for (int element: elements) {
                sb.append(element).append(' ');
            }
            resultSet.add(sb.toString());
            sb.setLength(0);
            return;
        }

        for (int i = idx; i < n; i++) {
            if (visit[i]) continue;
            visit[i] = true;
            elements[depth] = inputArr[i];
            backTrack(depth + 1, i, elements);
            visit[i] = false;
        }
    }

    public static void main(String[] args) throws Exception{
        input();
        pro();
    }
}