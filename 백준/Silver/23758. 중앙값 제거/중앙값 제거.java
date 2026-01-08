import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int n;
    static ArrayList<Integer> list;
    static int[] pow;

    static void input() throws IOException {
        n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) list.add(Integer.parseInt(st.nextToken()));
    }

    static void pro() {
        pow = new int[31];
        pow[0] = 1;
        for (int i = 1; i < 31; i++) {
            pow[i] = pow[i - 1] * 2;
        }

        Collections.sort(list);

        if (list.get(0) == 0) {
            System.out.println(0);
            return;
        }

        long sum = 0;
        int m = (n + 1) / 2;
        for (int i = 0; i < m; i++) {
            int cur = list.get(i);

            for (int j = 0; j < 31; j++) {
                if (cur < pow[j]) {
                    sum += (j - 1);
                    break;
                }
            }
        }
        System.out.println(sum + 1);
    }


    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
