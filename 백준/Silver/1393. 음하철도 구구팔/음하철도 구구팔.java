import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int[] goal, start, dist;
    static final int ADD = 200, MAX = ADD + 100, MIN = ADD - 100;

    /**
     *
     * 1. 증가하는 값의 최대공약수를 구함
     * 2. 증가량을 최대공약수로 나눔
     * 3. 시작점으로부터 증가량을 더해가며, 거리를 구하고, 범위를 벗어나면 끝
     *
     */
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        goal = new int[] {Integer.parseInt(st.nextToken()) + ADD, Integer.parseInt(st.nextToken()) + ADD};

        st = new StringTokenizer(br.readLine());
        start = new int[] {Integer.parseInt(st.nextToken()) + ADD, Integer.parseInt(st.nextToken()) + ADD};
        dist = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};

        if (dist[0] == 0 && dist[1] == 0) {
            sb.append(start[0] - ADD).append(' ').append(start[1] - ADD);
            System.out.println(sb);
            return;
        }

        int gcd = 1;
        for (int i = MAX; i >= 1; i--) {
            if (dist[0] % i == 0 && dist[1] % i == 0) {
                gcd = i;
                break;
            }
        }

        dist[0] /= gcd; dist[1] /= gcd;
        int minDist = Integer.MAX_VALUE;
        int[] minLoc = new int[] {-1, -1};
        while (check(start[0], start[1])) {
            int curDist = calDist(start[0], start[1]);
            if (curDist < minDist) {
                minDist = curDist;
                minLoc = new int[] {start[0], start[1]};
            }

            start[0] += dist[0];
            start[1] += dist[1];
        }

        sb.append(minLoc[0] - ADD).append(' ').append(minLoc[1] - ADD);
        System.out.println(sb);
    }

    static int calDist(int x, int y) {
        int dx = goal[0] - x;
        int dy = goal[1] - y;

        return dx * dx + dy * dy;
    }

    static boolean check(int x, int y) {
        if (x > MAX || x < MIN || y > MAX || y < MIN) return false;
        return true;
    }
}