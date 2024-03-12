import java.util.*;
import java.io.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int x1, y1, x2, y2, r1, r2;

    static void input() throws IOException{
        st = new StringTokenizer(br.readLine());

        x1 = Integer.parseInt(st.nextToken());
        y1 = Integer.parseInt(st.nextToken());
        r1 = Integer.parseInt(st.nextToken());
        x2 = Integer.parseInt(st.nextToken());
        y2 = Integer.parseInt(st.nextToken());
        r2 = Integer.parseInt(st.nextToken());
    }

    static void pro() {
        int dist = twoPointDist(x1, y1, x2, y2);
        int rDiff = (int)Math.pow(r1 - r2, 2);
        int rPlus = (int)Math.pow(r1 + r2, 2);
        if (dist == 0 && r1 == r2) sb.append(-1).append('\n');
        else if (dist == rDiff) sb.append(1).append('\n'); // 내접
        else if (dist == rPlus) sb.append(1).append('\n'); // 외접
        else if (dist > Math.pow(r1 + r2, 2)) sb.append(0).append('\n'); // 외부에 만나지 않는 두 원
        else if (dist < Math.pow(r2 - r1, 2)) sb.append(0).append('\n'); // 내부에 만나지 않는 두 원
        else sb.append(2).append('\n');
    }

    static int twoPointDist(int x1, int y1, int x2, int y2) {
        return (int)(Math.pow(x1 - x2, 2) +  Math.pow(y1 - y2, 2));
    }

    public static void main(String[] args) throws IOException {

        int tc = Integer.parseInt(br.readLine());
        while ( tc -- > 0 ) {
            input();
            pro();
        }
        System.out.println(sb);
    }



}