import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    //    private static Scanner sc = new Scanner(System.in);
    private static BufferedReader br;
    private static StringBuffer sb;

    public static void main(String args[]) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuffer();

        int count = Integer.parseInt(br.readLine());
        int[] prefixSum = new int[10001];
        for(int i=0; i<count; i++){
            prefixSum[Integer.parseInt(br.readLine())]++;
        }

        for(int i=0; i< prefixSum.length; i++){
            while (prefixSum[i] > 0){
                prefixSum[i]--;
                sb.append(i);
                sb.append("\n");
            }
        }
        sb.setLength(sb.length()-1);
        System.out.println(sb);

        br.close();
        sb.setLength(0);
    }

}