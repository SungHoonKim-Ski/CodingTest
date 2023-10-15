import java.util.*;
import java.io.*;

public class Main {

    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer sb = new StringBuffer();

    public static void input() throws IOException{
        st = new StringTokenizer(br.readLine());
    }
    public static void pro() throws IOException {
        int sum = 0;
        while (st.hasMoreTokens()) {
            int i = Integer.parseInt(st.nextToken());
            sum += i * i;
        }
        System.out.println(sum % 10);

    }
    
    public static void main(String[] args) throws IOException{
        input();
        pro();
    }

}
