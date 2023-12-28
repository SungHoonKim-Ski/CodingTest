import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer sb = new StringBuffer();
    static StringTokenizer st;

    static int a;
    static void input() throws IOException{
        a = Integer.parseInt(br.readLine());
    }

    static void pro(){
        System.out.println(a - 1946);
    }

    public static void main(String[] args) throws IOException{
        input();
        pro();

    }

}