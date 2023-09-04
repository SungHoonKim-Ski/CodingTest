import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer sb = new StringBuffer();
    static StringTokenizer st;
    static int a, b;
    public static void input() throws IOException{

        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
    }

    public static void pro() {

        int cnt = 1;
        while (b > a) {
            if (b % 10 == 1) {
                b /= 10;
            } else if (b % 2 == 1){
                break;
            } else {
                b /= 2;
            }
            cnt++;
        }

        if (a != b) cnt = -1;
        System.out.println(cnt);
    }



    public static void main(String[] args) throws IOException{
        input();
        pro();
    }

}