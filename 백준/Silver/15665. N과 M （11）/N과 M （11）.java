import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer sb = new StringBuffer();
    static StringBuffer setSb = new StringBuffer();
    static StringTokenizer st;

    static int n, m;

    static int[] inputIntArr;

    static HashSet<String> permutationSet;

    public static void input() throws IOException{

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        inputIntArr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i =0 ; i < n; i++) inputIntArr[i] = Integer.parseInt(st.nextToken());
        permutationSet = new HashSet<>();
    }

    public static void pro() {

        Arrays.sort(inputIntArr);
        backtracking(0, new int[m]);
        System.out.println(sb);

    }

    public static void backtracking(int depth, int[] elements) {

        if (depth == m) {
            setSb.setLength(0);
            for (int i = 0; i < m; i++) setSb.append(elements[i]).append('-');
            if (permutationSet.add(setSb.toString())) {
                for (int i = 0; i < m; i++) sb.append(elements[i]).append(' ');
                sb.append('\n');
            }
            return;
        }

        for (int i = 0; i < n; i++) {
            elements[depth] = inputIntArr[i];
            backtracking(depth + 1, elements);
        }
    }



    public static void main(String[] args) throws IOException{
        input();
        pro();
    }

}
