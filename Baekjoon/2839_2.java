import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());

        int res = 0;
        
        while(input % 5 != 0){
            input -= 3;
            res++;
        }
        
        if(input < 0){
            res = -1;
        }else{
            res += input/5;
        }

        System.out.println(res);
        
        
        return;
    }

}
