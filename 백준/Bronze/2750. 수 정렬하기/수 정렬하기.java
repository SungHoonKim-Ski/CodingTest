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
        int[] sortArr = new int[count];
        for(int i=0; i<count; i++){
            sortArr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(sortArr);
        for(int i=0; i<count; i++){
            System.out.println(sortArr[i]);
        }
    }

}