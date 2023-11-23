import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer sb = new StringBuffer();
    static StringTokenizer st;
    static int l, p;
    static int[] news;

    static void input() throws IOException{
        st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());

        news = new int[5];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 5; i++) news[i] = Integer.parseInt(st.nextToken());

    }

    static void pro(){

        int sum = l * p;
        for (int i = 0; i < 5; i++) {
            sb.append(news[i] - sum).append(' ');
        }
        System.out.println(sb);

    }

    public static void main(String[] args) throws IOException{
        input();
        pro();

    }

}