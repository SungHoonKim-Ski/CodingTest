import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    //    private static Scanner sc = new Scanner(System.in);


    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        String input;
        while(true){
            input = br.readLine();
            if(input.equals("0")){
                break;
            }
            boolean res = true;
            int length = input.length();

            char[] inputChar = input.toCharArray();
            for(int i=0; i<length/2; i++){
                if(inputChar[i] != inputChar[length-1-i]){
                    res = false;
                    break;
                }
            }

            if(res){
                sb.append("yes");
            }else{
                sb.append("no");
            }
            sb.append("\n");
        }
        sb.setLength(sb.length()-1);
        System.out.println(sb);
    }

}