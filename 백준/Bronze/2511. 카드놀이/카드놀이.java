import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer sb = new StringBuffer();
    static StringTokenizer st;

    static int[] a, b;


    static void input() throws IOException{
        a = new int[10];
        b = new int[10];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < a.length; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < b.length; i++) b[i] = Integer.parseInt(st.nextToken());
    }

    static void pro() {
        int aScore, bScore, recentWin;
        recentWin = aScore = bScore = 0;

        for (int i = 0; i < a.length; i++) {
            if (a[i] > b[i]) {
                aScore += 3;
                recentWin = 1;
                continue;
            }
            if (b[i] > a[i]) {
                bScore += 3;
                recentWin = -1;
                continue;
            }
            aScore++;
            bScore++;
        }

        sb.append(aScore).append(' ').append(bScore).append('\n');

        if (aScore == bScore) {
            if (recentWin == 0) sb.append('D');
            else sb.append(recentWin == 1 ? 'A' : 'B');
        } else {
            if (aScore > bScore) sb.append('A');
            else sb.append('B');
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException{
        input();
        pro();

    }

}
