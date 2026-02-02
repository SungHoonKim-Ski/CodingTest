import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int n, sum;

    static void input() throws IOException {
        n = Integer.parseInt(br.readLine());
    }

    static void pro() {
        System.out.println(recur(0));
    }

    static int recur(int cur) {
        if (cur > n) return 0;
        if (cur == n) return 1;

        int sum = recur(cur + 2) * 3;

        for (int i = cur + 4; i <= n; i += 2) {
            sum += recur(i) * 2;
        }

        return sum;
    }


    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
