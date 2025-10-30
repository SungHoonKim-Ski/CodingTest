import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n;
    static char[][] map;
    static int[] head, heart;

    static int[] dx = {0, 0, 1, 1, 1};
    static int[] dy = {-1, 1, 0, 0, 0};

    static void input() throws IOException{
        n = Integer.parseInt(br.readLine());

        map = new char[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            char[] str = br.readLine().toCharArray();
            for (int j = 1; j <= n; j++) {
                map[i][j] = str[j - 1];
            }
        }
    }

    static void pro() {
        head = findHead();
        heart = new int[] {head[0] + 1, head[1]};

        sb.append(heart[0]).append(' ').append(heart[1]).append('\n');

        sb.append(checkSize(0)).append(' ');
        sb.append(checkSize(1)).append(' ');

        int hip = checkSize(2);
        sb.append(hip).append(' ');

        heart[0] = heart[0] + hip;
        heart[1] = heart[1] - 1;
        sb.append(checkSize(3)).append(' ');

        heart[1] = heart[1] + 2;
        sb.append(checkSize(4));

        System.out.println(sb);
    }

    static int checkSize(int idx) {
        int count = 0;
        for (int i = 1; i < n; i++) {
            int nx = heart[0] + (dx[idx] * i);
            int ny = heart[1] + (dy[idx] * i);

            if (nx < 1 || nx > n || ny < 1 || ny > n || map[nx][ny] != '*') return count;
            count++;
        }
        return count;
    }

    static int[] findHead() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (map[i][j] == '*') return new int[] {i, j};
            }
        }
        return new int[] {-1, -1};
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}