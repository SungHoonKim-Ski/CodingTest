import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int a, b;
    static final int MAX = 100_000_000;

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
    }

    static void pro() {
        boolean[] notPrime = new boolean[MAX + 1];

        for (int i = 2; i * i <= MAX; i++) {
            if (notPrime[i]) continue;
            for (int j = i + i; j <= MAX; j += i) {
                notPrime[j] = true;
            }
        }

        for (int i = a; i <= b; i++) {
            if (!notPrime[i] && check(i))
                sb.append(i).append('\n');
        }
        sb.append(-1);
        System.out.println(sb);
    }

    static boolean check(int x) {
        char[] str = String.valueOf(x).toCharArray();
        int n = str.length;

        for (int i = 0; i < n / 2; i++) {
            if (str[i] != str[n - 1 - i]) return false;
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}