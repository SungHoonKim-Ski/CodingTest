import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer sb = new StringBuffer();
    static StringTokenizer st;
    static int sum, count;
    static int[] prices;

    static void input() throws IOException{

        sum = Integer.parseInt(br.readLine());
        count = Integer.parseInt(br.readLine());

        prices = new int[count];

        for (int i = 0; i < count; i++) {
            st = new StringTokenizer(br.readLine());
            prices[i] = Integer.parseInt(st.nextToken());
            prices[i] *= Integer.parseInt(st.nextToken());
        }

    }

    static void pro(){

        int tmpSum = 0;
        for (int i = 0; i < count; i++) {
            tmpSum += prices[i];
        }
        if (tmpSum == sum) System.out.println("Yes");
        else System.out.println("No");

    }

    public static void main(String[] args) throws IOException{
        input();
        pro();

    }

}