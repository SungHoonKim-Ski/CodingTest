import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;
    static StringBuffer sb = new StringBuffer();
    static StringTokenizer st;

    static int n, k;
    static int[] inputArr;

    static void input() throws IOException{
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        inputArr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) inputArr[i] = Integer.parseInt(st.nextToken());
    }

    static void pro() {
        Arrays.sort(inputArr);
        System.out.println(inputArr[k - 1]);
    }
    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        input();
        pro();
    }

}
