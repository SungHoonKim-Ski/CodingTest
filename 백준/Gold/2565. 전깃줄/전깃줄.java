import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n;
    static Line[] lines;
    static int[] bArr, dp;

    static class Line {
        int a, b;
        Line(int a, int b) {
            this.a = a; this.b = b;
        }
    }

    static void input() throws Exception {
        n = Integer.parseInt(br.readLine());

        lines = new Line[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            lines[i] = new Line(a, b);
        }
    }

    public static void pro() {
        Arrays.sort(lines, ((o1, o2) -> o1.a - o2.a));

        bArr = new int[n];
        for (int i = 0; i < n; i++) {
            bArr[i] = lines[i].b;
        }

        dp = new int[n];
        Arrays.fill(dp, -1);
        
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, recur(i));
        }
        System.out.println(n - max);
    }

    static int recur(int cur) {
        if (dp[cur] != -1) return dp[cur];

        dp[cur] = 1;
        for (int i = 0; i < cur; i++) {
            if (bArr[i] < bArr[cur])
                dp[cur] = Math.max(dp[cur], recur(i) + 1);
        }
        return dp[cur];
    }


    public static void main(String[] args) throws Exception{
        input();
        pro();
    }
}