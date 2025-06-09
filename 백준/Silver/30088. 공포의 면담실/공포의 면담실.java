import java.io.*;
import java.util.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n;
    static int[] prefixSum;

    static void input() throws Exception {
        n = Integer.parseInt(br.readLine());
        prefixSum = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            for (int j = 0; j < x; j++) {
                prefixSum[i] += Integer.parseInt(st.nextToken());
            }
        }
    }

    public static void pro() {
        Arrays.sort(prefixSum);
        int result = prefixSum[0];
        
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + prefixSum[i];
            result += prefixSum[i];
        }
        
        System.out.println(result);
    }

    public static void main(String[] args) throws Exception{
        input();
        pro();
    }
}