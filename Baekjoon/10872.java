import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

    public static void main(String args[])throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        System.out.println(printFact(n));
    }

    private static int printFact(int n){

        if(n <= 1){
            return 1;
        }else{
            return n * printFact(n-1);
        }
    }
}