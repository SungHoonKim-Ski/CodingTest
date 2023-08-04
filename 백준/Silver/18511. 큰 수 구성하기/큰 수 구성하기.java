import java.io.*;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static StringTokenizer st;
    static int N, K, NLen, Max = -1;
    static int[] Elements;
    static void input() throws IOException
    {
        st = new StringTokenizer(br.readLine());
        sb.append(st.nextToken());
        N = Integer.parseInt(sb.toString());
        K = Integer.parseInt(st.nextToken());
        NLen = sb.length();

        Elements = new int[K];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) Elements[i] = Integer.parseInt(st.nextToken());
    }

    static void pro() throws IOException
    {

        sb.setLength(0); // 초기화
        for (int i = 0; i < K; i++) {
            sb.append(Elements[i]);
            dfs(0);
            sb.setLength(sb.length() - 1);
        }
        System.out.println(Max);
    }

    static void dfs(int depth) {

        if (depth == NLen) return;
        int num = Integer.parseInt(sb.toString());
        if (num > N) return;

        Max = Math.max(Max, num);
        for (int i = 0; i < K; i++) {
            sb.append(Elements[i]);
            dfs(depth + 1);
            sb.setLength(sb.length() - 1);
        }
    }

    public static void main(String[] args) throws Exception{
        input();
        pro();

    }

}