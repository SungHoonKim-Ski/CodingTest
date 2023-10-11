import java.util.*;
import java.io.*;

public class Main {

    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer sb = new StringBuffer();

    static Gear[] gears;
    static int query;

    public static void input() throws IOException{
        gears = new Gear[5];
        for (int i = 1; i < 5; i++) {
            gears[i] = new Gear();
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < 8; j++) { // 0 = True = N, 1 = False = S
                gears[i].magnet.add(input[j] == '0');
            }
        }
        query = Integer.parseInt(br.readLine());
    }
    public static void pro() throws IOException {

        while (query-- > 0) {
            st = new StringTokenizer(br.readLine());
            int magnetIdx = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            // dir == 1 asc
            // dir == -1 desc

            int[] rotateDir = new int[gears.length];
            rotateDir[magnetIdx] = dir;

            int left = magnetIdx;

            // 0 = True = N, 1 = False = S
            while (left - 1 != 0) {
                boolean isN = gears[left].magnet.get(6);
                if (isN != gears[left - 1].magnet.get(2)) {
                    rotateDir[left - 1] = -rotateDir[left];
                    left--;
                } else break;
            }

            int right = magnetIdx;
            while (right + 1 != gears.length) {
                boolean isN = gears[right].magnet.get(2);
                if (isN != gears[right + 1].magnet.get(6)) {
                    rotateDir[right + 1] = -rotateDir[right];
                    right++;
                } else break;
            }

            for (int i = 1; i < gears.length; i++) {
                if (rotateDir[i] == 0) continue;
                if (rotateDir[i] == 1) {
                    gears[i].rotate_asc();
                } else {
                    gears[i].rotate_desc();
                }
            }
        }

        int score = 0;
        for (int i = 1; i < gears.length; i++) {
            if (!gears[i].magnet.get(0)) {
                score += 1 << (i - 1);
            }
        }
        System.out.println(score);
    }

    static class Gear{
        LinkedList<Boolean> magnet;
        Gear() {
            magnet = new LinkedList<>();
        }
        void rotate_asc() {
            magnet.addFirst(magnet.removeLast());
        }

        void rotate_desc() {
            magnet.addLast(magnet.removeFirst());
        }
    }

    public static void main(String[] args) throws IOException{
        input();
        pro();
    }

}
