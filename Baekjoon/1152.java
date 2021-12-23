import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputStr = br.readLine().trim().split(" ");
        if(inputStr.length > 1){
            System.out.println(inputStr.length);
        }else{
            if(inputStr[0].isEmpty()){
                System.out.println(0);
            }else{
                System.out.println(1);
            }
        }

        return;
    }

}
