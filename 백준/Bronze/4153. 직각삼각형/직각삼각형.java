import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    //    private static Scanner sc = new Scanner(System.in);

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        String[] inputSplit;
        while (true){
            inputSplit = br.readLine().split(" ");

            int a = Integer.parseInt(inputSplit[0]);
            int b = Integer.parseInt(inputSplit[1]);
            int c = Integer.parseInt(inputSplit[2]);

            if(a == 0 && b == 0 && c == 0){
                break;
            }
            if(a * a + b * b == c * c){
                sb.append("right");
            }else if (a * a + c * c == b * b){
                sb.append("right");
            }else if (a * a == b * b + c * c){
                sb.append("right");
            }else{
                sb.append("wrong");
            }
            sb.append("\n");
        }
        sb.setLength(sb.length()-1);
        System.out.println(sb);;
    }

}