import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

//    private static Scanner sc = new Scanner(System.in);
    private static BufferedReader br;
    private static StringBuffer sb;
    private static int count = 0;
    public static void main(String args[]) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuffer();

        int n = Integer.parseInt(br.readLine());
        hanoiTop(n, 1, 3, 2);

        System.out.println(count);
        System.out.println(sb);
    }

    private static void hanoiTop(int n, int from, int to, int stay){
        count++;
        if(n == 1){
            sb.append(from + " " + to + "\n");
            return;
        }
        hanoiTop(n-1, from, stay, to);
        sb.append(from + " " + to + "\n");
        hanoiTop(n-1, stay, to, from);
    }


}