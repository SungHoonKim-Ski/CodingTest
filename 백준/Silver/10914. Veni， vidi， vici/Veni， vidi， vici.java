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

        int n = Integer.parseInt(br.readLine());
        String[] inputArr = br.readLine().split(" ");
        for(int i=0; i< inputArr.length; i++){
            char[] encodeText = inputArr[i].toCharArray();
            for(int j=0; j<encodeText.length/2; j++){
                int a = j*2;
                sb.append(decode(encodeText[a], encodeText[a+1], n));
            }
            sb.append(" ");
        }
        System.out.println(sb);
    }

    private static char decode(char inputY, char inputZ, int n){
        int y = inputY - 97;
        int z = inputZ - 97;
        int cal = (y + z - n);
        if(cal < 0){
            cal += 26;
        }else{
            cal %= 26;
        }

        return (char)(cal + 97);
    }

}