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

        char[] inputCharArr = br.readLine().toCharArray();
        int size = inputCharArr.length;

        Arrays.sort(inputCharArr);
        for(int i=size-1; i>=0; i--){
            sb.append(inputCharArr[i]);
        }

        System.out.println(sb);

        br.close();
        sb.setLength(0);
    }

}