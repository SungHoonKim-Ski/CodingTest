import java.util.*;
import java.io.*;


public class Main
{
    static int N, M;
    static int[] arr;

    public static void init() {
        arr = new int[1002];

        int idx = 1;
        for (int i = 1; i < 1001; i++) {
            for (int j = 0; j < i && idx < 1001; j++, idx++) {
                arr[idx] = i;
            }
        }
    }

    public static void input() throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
    }



    public static void pro() {

        int res = 0;
        for (int i = N; i <= M; i++) res += arr[i];
        System.out.println(res);
    }


    public static void main(String args[]) throws Exception
    {
        init();
        input();
        pro();
    }
}