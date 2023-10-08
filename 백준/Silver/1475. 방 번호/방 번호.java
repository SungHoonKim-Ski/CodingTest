import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer sb = new StringBuffer();
    static StringTokenizer st;

    static char[] nArr;
    static int[] count;

    static int setCnt;
    static void input() throws Exception {
        nArr = br.readLine().toCharArray();
        count = new int[9];
    }
    static void pro() {
        for (char c : nArr) {
            int i = c - '0';
            if (i == 9) i = 6;
            if (--count[i] < 0) {
                setCnt++;
                for (int j = 0; j < 9; j++) {
                    count[j]++;
                }
                count[6]++;
            }
        }
        System.out.println(setCnt);
    }


    public static void main(String[] args) throws Exception{
        input();
        pro();
    }


}
