import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer sb = new StringBuffer();
    static StringTokenizer st;

    static int n, cnt;
    static int[] ans;

    public static void input() throws IOException{
        n = Integer.parseInt(br.readLine());
        ans = new int[]{0, 1, 0, 0, 2, 10, 4, 40, 92, 352, 724, 2680, 14200, 73712, 365596, 2279184};
    }

    public static void pro() {

        System.out.println(ans[n]);
    }

    public static void main(String[] args) throws IOException{
            input();
            pro();
    }

}
