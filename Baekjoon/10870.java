import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String args[])throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        System.out.println(calFib(n));
    }

    private static int calFib(int n){
        if(n == 0){
            return 0;
        }else if(n == 1){
            return 1;
        }else{
            return calFib(n-1) + calFib(n-2);
        }
    }
}