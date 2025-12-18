import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static char[] str;
    static int q;
    static int[][] prefix;

    public static void main(String[] args) throws IOException {
        str = (" "+ br.readLine()).toCharArray();

        prefix = new int[str.length][3];

        for (int i = 1; i < str.length; i++) {
            for (int j = 0; j < 3; j++) {
                prefix[i][j] = prefix[i - 1][j];
            }

            if (str[i] == 'C') prefix[i][0]++;
            else if (str[i] == 'O') prefix[i][1]++;
            else if (str[i] == 'W') prefix[i][2]++;
        }

        q = Integer.parseInt(br.readLine());
        while (q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            int c = (prefix[e][0] - prefix[s - 1][0]) % 2;
            int o = (prefix[e][1] - prefix[s - 1][1]) % 2;
            int w = (prefix[e][2] - prefix[s - 1][2]) % 2;
            
            if (c == 0 && o == 1 && w == 1) sb.append('Y');
            else if (c == 1 && o == 0 && w == 0) sb.append('Y');
            else sb.append('N');
        }

        System.out.println(sb);
    }
}