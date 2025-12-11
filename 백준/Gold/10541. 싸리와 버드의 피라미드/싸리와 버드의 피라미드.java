import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int n, k;
    static char[] str;
    static int[][] prefix;

    public static void main(String[] args) throws IOException {
        Long.parseLong(br.readLine());

        str = br.readLine().toCharArray();
        n = str.length;
        k = Integer.parseInt(br.readLine());

        prefix = new int['Z' - 'A' + 1][n + 1];
        for (int i = 'A'; i <= 'Z'; i++) {
            for (int j = 1; j <= n; j++) {
                prefix[i - 'A'][j] = prefix[i - 'A'][j - 1];

                if (str[j - 1] == i) prefix[i - 'A'][j]++;
            }
        }

        while (k-- > 0) {
            st = new StringTokenizer(br.readLine());

            long a = Long.parseLong(st.nextToken());
            char c = st.nextToken().charAt(0);

            long cnt = a / n;
            long len = a % n;

            long idx = 0;
            if (a % 2 == 0) idx = ((a / 2) % n) * ((a - 1) % n);
            else idx = (((a - 1) / 2) % n) * (a % n);

            idx %= n;

            long res = 0;

            res += cnt * prefix[c - 'A'][n];
            if(idx + len <= n) res += prefix[c - 'A'][(int)(idx + len)] - prefix[c - 'A'][(int)idx];
            else res += prefix[c - 'A'][n] - prefix[c - 'A'][(int)idx] + prefix[c - 'A'][(int)(len - (n - idx))];

            sb.append(res).append('\n');
        }

        System.out.println(sb);
    }
}