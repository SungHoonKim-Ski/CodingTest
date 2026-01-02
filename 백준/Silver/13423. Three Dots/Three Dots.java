import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static final int SALT = 500_000_000;
    static int n;
    static int[] arr;

    static void input() throws IOException {
        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void pro() {
        List<Integer> list = new ArrayList<>();
        TreeSet<Integer> set = new TreeSet<>();
        for (int x : arr) {
            list.add(x + SALT);
            set.add(x + SALT);
        }

        Collections.sort(list);
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int x = list.get(i);
                int y = list.get(j);

                int z = 2 * y - x;
                if (set.contains(z)) {
                    cnt++;
                }
            }
        }

        sb.append(cnt).append('\n');
    }

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            input();
            pro();
        }
        System.out.println(sb);
    }
}