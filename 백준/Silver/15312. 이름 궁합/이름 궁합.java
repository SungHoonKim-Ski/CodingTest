import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer sb = new StringBuffer();
    static StringTokenizer st;
    static final int[] alphaNum = {3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1};
    static int[] a, b;
    static void input() throws IOException{

        char[] aCharArr = br.readLine().toCharArray();
        a = new int[aCharArr.length];
        for (int i = 0; i < aCharArr.length; i++) a[i] = alphaNum[aCharArr[i] - 'A'];

        char[] bCharArr = br.readLine().toCharArray();
        b = new int[bCharArr.length];
        for (int i = 0; i < bCharArr.length; i++) b[i] = alphaNum[bCharArr[i] - 'A'];
    }

    static void pro() {

        int[] ab = new int[a.length + b.length];

        for (int i = 0; i < a.length; i++) {
            ab[i * 2] = a[i];
            ab[i * 2+ 1] = b[i];
        }

        while (ab.length != 2) {
            int[] nextAB = new int[ab.length - 1];
            for (int i = 0; i < ab.length - 1; i++) {
                nextAB[i] = (ab[i] + ab[i + 1]) % 10;
            }
            ab = nextAB;
        }
        sb.append(ab[0]).append(ab[1]);
        System.out.println(sb);
    }
    public static void main(String[] args) throws IOException{
        input();
        pro();

    }

}
