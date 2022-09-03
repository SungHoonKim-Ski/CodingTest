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

        String[] inputArr = br.readLine().split(" ");
        int n = Integer.parseInt(inputArr[0]);
        int m = Integer.parseInt(inputArr[1]);

        int[] cards = new int[n];
        inputArr = br.readLine().split(" ");
        for(int i=0; i<n; i++){
            cards[i] = Integer.parseInt(inputArr[i]);
        }

        int max = 0;
        for(int i=0; i<n-2; i++){
            for(int j=i+1; j<n-1; j++){
                for(int k=j+1; k<n; k++){
                    int sum = cards[i] + cards[j] + cards[k];
                    if(max < sum && sum <= m){
                        max = sum;
                    }
                }
            }
        }
        System.out.println(max);
    }

}