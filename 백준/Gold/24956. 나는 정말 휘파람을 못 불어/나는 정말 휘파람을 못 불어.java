import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static final int MOD = 1_000_000_007;

    static int n;
    static int[] two, suffix, prefix;
    static char[] str;

    static void input() throws IOException{
        n = Integer.parseInt(br.readLine());
        str = sb.append('#').append(br.readLine()).append('#').toString().toCharArray();
    }

    static void pro() {
        two = new int[n + 1];
        suffix = new int[n + 2];
        prefix = new int[n + 2];

        two[0] = 1;
        for (int i = 1; i <= n; i++) {
            two[i] = (2 * two[i - 1]) % MOD;
        }

        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1];
            if (str[i] == 'W') prefix[i]++;
        }

        for (int i = n; i >= 0; i--) {
            suffix[i] = suffix[i + 1];
            if (str[i] == 'E') suffix[i]++;
        }

        long ans = 0;
        for (int i = 1; i <= n; i++) {
            if (str[i] == 'H') {
                long plus = prefix[i - 1] * ((two[suffix[i + 1]] - 1 - suffix[i + 1] + 2L * MOD) % MOD);
                ans += plus;
                ans %= MOD;
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}