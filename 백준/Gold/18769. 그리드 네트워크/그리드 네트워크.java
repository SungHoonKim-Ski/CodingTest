import java.io.*;
import java.util.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static final int INF = Integer.MAX_VALUE;
    static final int[] dy = {0, 1, 0, -1};
    static final int[] dx = {1, 0, -1, 0};

    static class Weight{

//        Point[][] nextPoint;
        int[] nextWeight;
        Weight() {
//            nextPoint = new Point[2][2];
            nextWeight = new int[4];
        }
    }

    static class Point{
        int y, x;
        Point(int _y, int _x) {
            y = _y; x = _x;
        }
    }
    static class Info{
        Point next;
        int dist;

        Info(Point _next, int _dist) {
            next = _next; dist = _dist;
        }
    }

    static int r, c;

    static Weight[][] weights;
    static void input() throws Exception{

        st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        weights = new Weight[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                weights[i][j] = new Weight();
            }
        }

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < c; j++) {
                // 우, 하, 좌, 상
                weights[i][j - 1].nextWeight[0] = Integer.parseInt(st.nextToken());
                weights[i][j].nextWeight[2] = weights[i][j - 1].nextWeight[0];
            }
        }

        for (int i = 1; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                // 오, 위, 왼, 아래
                weights[i - 1][j].nextWeight[1] = Integer.parseInt(st.nextToken());
                weights[i][j].nextWeight[3] = weights[i - 1][j].nextWeight[1];
            }
        }
    }

    static void pro() {

        sb.append(prim(new Point(0, 0))).append('\n');
    }

    static int prim(Point startPoint) {

        boolean[][] visit = new boolean[r][c];
        PriorityQueue<Info> pq = new PriorityQueue<>((o1, o2) -> o1.dist - o2.dist);

        pq.add(new Info(startPoint, 0));

        int distSum = 0;

        while (!pq.isEmpty()) {

            Info curInfo = pq.poll();
            Point curPoint = curInfo.next;

            if (visit[curPoint.y][curPoint.x]) continue;

            visit[curPoint.y][curPoint.x] = true;
            distSum += curInfo.dist;
//            System.out.println(cur.idx);

            for (int i = 0; i < 4; i++) {
                // 우 하 좌 상
                int ny = curPoint.y + dy[i];
                int nx = curPoint.x + dx[i];
                if (ny == -1 || nx == -1 || ny == r || nx == c) continue;
                if (weights[curPoint.y][curPoint.x].nextWeight[i] == 0) continue; // 연결이 되지 않았다면
                if (visit[ny][nx]) continue;
                pq.add(new Info(new Point(ny, nx), weights[curPoint.y][curPoint.x].nextWeight[i]));
            }

        }
        return distSum;
    }

    public static void main(String[] args) throws Exception{

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            input();
            pro();
        }
        System.out.println(sb);

    }
}

