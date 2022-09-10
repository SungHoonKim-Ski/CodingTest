import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    //    private static Scanner sc = new Scanner(System.in);

    static int[] zeroCountArr;
    static int[] oneCountArr;
    static int[] fibonacciArr;
    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int count = Integer.parseInt(br.readLine());

        zeroCountArr = new int[41];
        oneCountArr = new int[41];
        fibonacciArr = new int[41];

        for(int i=0; i<=40; i++){
            Fibonacci(i);
        }

        for(int i=0; i<count; i++){
            int input = Integer.parseInt(br.readLine());
            sb.append(zeroCountArr[input] + " " + oneCountArr[input] + "\n");
        }

        sb.setLength(sb.length()-1);
        System.out.println(sb);
    }
    static void Fibonacci(int n) {
        if (n == 0) {
            zeroCountArr[0] = 1;
            fibonacciArr[0] = 0;
        } else if (n == 1) {
            oneCountArr[1] = 1;
            fibonacciArr[1] = 1;
        } else {
            fibonacciArr[n] =  fibonacciArr[n-1] + fibonacciArr[n-2];
            oneCountArr[n] =  oneCountArr[n-1] + oneCountArr[n-2];
            zeroCountArr[n] =  zeroCountArr[n-1] + zeroCountArr[n-2];
        }
    }

}