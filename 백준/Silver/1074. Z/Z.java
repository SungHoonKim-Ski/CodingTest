import java.io.*;
import java.nio.Buffer;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, R, C;
    static int cnt = 0;
    static boolean flag = false;

    static void input() throws IOException{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
    }

    static void pro() {
        int n = (int)Math.pow(2, N);
        divide(R, C, n);
        System.out.println(cnt);
    }

    static void divide(int startY, int startX, int size) {

        if (size == 1) return;
        if (startY < size / 2 && startX < size / 2) {
            divide(startY, startX, size / 2);
        }
        else if (startY < size / 2 && startX >= size / 2) {
            cnt += size * size / 4;
            divide(startY, startX - size / 2, size / 2);
        }
        else if (startY >= size / 2 && startX < size / 2) {
            cnt += (size * size / 4) * 2;
            divide(startY - size / 2, startX, size / 2);
        }
        else {
            cnt += (size * size / 4) * 3;
            divide(startY - size / 2, startX - size / 2, size / 2);
        }

    }


    public static void main(String[] args) throws IOException{
        input();
        pro();
    }
}