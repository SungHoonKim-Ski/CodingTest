import java.io.*;
import java.util.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int a, MAX = 80;
    static long b;

    static long[] fibo;
    static HashSet<Long>[] map;

    static void input() throws Exception {
        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Long.parseLong(st.nextToken());
    }

    public static void init() {
        fibo = new long[MAX];
        fibo[0] = fibo[1] = fibo[2] = 1;
        for (int i = 3; i < MAX; i++) {
            fibo[i] = fibo[i - 1] + fibo[i - 2];
        }

        map = new HashSet[4];
        map[1] = new HashSet<>();
        map[2] = new HashSet<>();
        map[3] = new HashSet<>();

        for (int i = 1; i < fibo.length; i++) {
            map[1].add(fibo[i]);
        }

        for (int i = 1; i < fibo.length; i++) {
            for (int j = 1; j < fibo.length; j++) {
                map[2].add(fibo[i] + fibo[j]);
            }
        }

        for (int i = 1; i < fibo.length; i++) {
            for (int j = 1; j < fibo.length; j++) {
                for (int k = 1; k < fibo.length; k++) {
                    map[3].add(fibo[i] + fibo[j] + fibo[k]);
                }
            }
        }
    }

    public static void pro() {
        if (map[a].contains(b)) System.out.println("YES");
        else System.out.println("NO");
    }

    public static void main(String[] args) throws Exception{
        init();
        int tc = Integer.parseInt(br.readLine());
        while (tc -- > 0) {
            input();
            pro();
        }
    }
}
