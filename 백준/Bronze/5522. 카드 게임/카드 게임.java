import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer sb = new StringBuffer();
    static StringTokenizer st;

    static int sum;
    static void input() throws IOException{
        
        for (int i = 0; i < 5; i++) {
            sum += Integer.parseInt(br.readLine());
        }
    }

    static void pro() throws IOException {
        System.out.println(sum);
    }

    public static void main(String[] args) throws IOException{
        input();
        pro();
    }

}