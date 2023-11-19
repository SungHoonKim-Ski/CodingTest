import java.io.*;
import java.util.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int score;

    static void input() throws Exception{

        score = Integer.parseInt(br.readLine());
    }

    static void pro() {

        if (score >= 90) {
            sb.append('A');
        } else if (score >= 80) {
            sb.append('B');
        } else if (score >= 70) {
            sb.append('C');
        } else if (score >= 60) {
            sb.append('D');
        } else sb.append('F');
        
        System.out.println(sb);
    }


    public static void main(String[] args) throws Exception{

        input();
        pro();

    }
}

