import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer sb = new StringBuffer();
    static StringTokenizer st;
    static int r1, s;

    static void input() throws IOException{
        st = new StringTokenizer(br.readLine());
        r1 = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
    }

    static void pro(){
        System.out.println(2 * s - r1);

    }

    public static void main(String[] args) throws IOException{
        input();
        pro();

    }

}