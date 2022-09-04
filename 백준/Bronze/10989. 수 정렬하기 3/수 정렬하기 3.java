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
        int[] prefixSum = new int[10000001];
        int maxVal = 0;
        for(int i=0; i<count; i++){
            int input = Integer.parseInt(br.readLine());
            prefixSum[input]+= 1;
            if(maxVal < input)
                maxVal = input;
        }

        for(int i=0; i<=maxVal; i++){
            while (prefixSum[i] > 0){
                sb.append(i);
                prefixSum[i] -= 1;
                sb.append("\n");
            }
        }
        sb.setLength(sb.length()-1);
        System.out.println(sb);
    }

}