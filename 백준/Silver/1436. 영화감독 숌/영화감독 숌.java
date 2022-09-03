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
        int[] endNumArr=  new int[10001];

        int i=666;
        int index = 1;

        while (index < 10001){
            if(String.valueOf(i).contains("666")){
                endNumArr[index] = i;
                index++;
            }
            i++;
        }

        int count = Integer.parseInt(br.readLine());
        System.out.println(endNumArr[count]);
    }

}