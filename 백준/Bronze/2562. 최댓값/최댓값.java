import java.util.*;
import java.io.*;
import java.math.*;


public class Main
{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer sb = new StringBuffer();
    static StringTokenizer st;
    static int N, M;

        
    public static void main(String args[]) throws IOException
    {
//        input();
//        pro();
        int[] input = new int[9];
        int maxNumIdx = -1;
        int max = -1;
        for (int i = 0; i < 9; i++) {
            input[i] = Integer.parseInt(br.readLine());
            if (max < input[i]) {
                max = input[i];
                maxNumIdx = i;
            }
        }
        System.out.println(max);
        System.out.println(maxNumIdx + 1);
    }
}