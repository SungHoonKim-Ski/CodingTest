import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer sb = new StringBuffer();

    static int n;
    static void input() throws IOException{
        n = Integer.parseInt(br.readLine());
    }

    static void pro() throws IOException{
        System.out.println(n - 543);
    }

    public static void main(String[] args) throws IOException{
        input();
        pro();

    }

}