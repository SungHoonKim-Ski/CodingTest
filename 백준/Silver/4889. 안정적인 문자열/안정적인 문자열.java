import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static char[] str;

    static void input() throws IOException{
        str = br.readLine().toCharArray();
    }

    static void pro(int tc) {
        int open = 0, close = 0, change = 0;
        for (char c : str) {
            if (c == '{') {
                open++;
            } else {
                if (open == 0) {
                    if (close == 0) {
                        close++;
                    } else {
                        close--;
                        change++;
                    }
                }
                else open--;
            }
        }

        change += (open + 1) / 2 + close;

        sb.append(String.format("%d. %d\n", tc, change));
    }

    public static void main(String[] args) throws IOException {
        int tc = 1;
        while (true) {
            input();
            if (str[0] == '-') break;
            pro(tc++);
        }
        System.out.println(sb);
    }
}