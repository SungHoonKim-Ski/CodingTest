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
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int x : arr) {
            list.add(x + SALT);
            map.put(x + SALT, map.getOrDefault(x + SALT, 0) + 1);
        }

        Collections.sort(list);
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int x = list.get(i);
                int y = list.get(j);

                int z = 2 * y - x;
                if (map.containsKey(z)) {
//                    System.out.printf("%d %d %d\n", x, y, z);
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