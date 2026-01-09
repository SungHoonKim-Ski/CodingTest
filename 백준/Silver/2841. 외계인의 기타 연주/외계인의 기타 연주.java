import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int n, p;
    static TreeSet<Integer>[] set;

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());
    }

    static void pro() throws IOException {
        set = new TreeSet[7];
        for (int i = 1; i < 7; i++) set[i] = new TreeSet<>();

        int cnt = 0;
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if (set[x].add(y)) {
                cnt++;
            }

            while (set[x].last() != y) {
                set[x].pollLast();
                cnt++;
            }
        }

        System.out.println(cnt);
    }


    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
