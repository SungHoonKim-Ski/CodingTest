import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int a, b, c;
    static HashMap<Integer, Long> map;

    static void input() throws Exception {
        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
    }

    public static void pro() {
        map = new HashMap<>();
        System.out.println(recur(b) % c);
    }

    static long recur(int cur) {
        if (cur == 0) return 1;
        if (cur == 1) return a;
        if (map.containsKey(cur)) return map.get(cur);

        long cal = recur(cur / 2) * recur(cur / 2);
        if (cur % 2 == 1) {
            cal %= c;
            cal *= a;
        }

        cal %= c;
        map.put(cur, cal);

        return cal;
    }

    public static void main(String[] args) throws Exception {
        input();
        pro();
    }
}