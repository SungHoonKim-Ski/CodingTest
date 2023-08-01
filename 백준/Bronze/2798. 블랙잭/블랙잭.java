import java.io.*;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static StringTokenizer st;

    static int N, M, Max = -1;
    static int[] InputArr;

    static boolean[] Visit;


    static void input() throws IOException
    {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        InputArr = new int[N];
        for (int i = 0; i < N; i++) InputArr[i] = Integer.parseInt(st.nextToken());

        Visit = new boolean[N];
    }

    static void pro() throws IOException
    {
    	
    	for (int i = 0; i < N - 2; i++) {
    		for (int j = i + 1; j < N - 1; j++) {
    			for (int k = j + 1; k < N; k++) {
    				int sum = InputArr[i] + InputArr[j] + InputArr[k];
    				if (sum <= M) Max = Math.max(Max, sum);
    			}
    		}
    	}
    	
        System.out.println(Max);
    }


    public static void main(String[] args) throws Exception{
        input();
        pro();

    }

}