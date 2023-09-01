import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer sb = new StringBuffer();
    static StringBuffer setSb = new StringBuffer();
    static StringTokenizer st;

    static int n, m;

    static int[] inputIntArr;
    static boolean[] visit;


    public static void input() throws IOException{

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        inputIntArr = new int[n];
        visit = new boolean[n];
        for (int i = 1 ; i <= n; i++) inputIntArr[i - 1] = i;
    }

    public static void pro() {

        backtracking(0, new int[m]);
        System.out.println(sb);

    }

    public static void backtracking(int depth, int[] elements) {

        if (depth == m) {
            for (int i = 0; i < m; i++) {
                sb.append(elements[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = 0; i < n; i++) {
        	if (visit[i]) continue;
        	visit[i] = true;
            elements[depth] = inputIntArr[i];
            backtracking(depth + 1, elements);
            visit[i] = false;
        }
    }



    public static void main(String[] args) throws IOException{
        input();
        pro();
    }

}
