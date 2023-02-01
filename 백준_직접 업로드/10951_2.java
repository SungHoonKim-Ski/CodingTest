import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String args[]) throws IOException { // BufferedReader 사용

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;

        while((input = br.readLine()) != null){
            String []split = input.split(" ");
            System.out.println(Integer.parseInt(split[0]) + Integer.parseInt(split[1]));
        }

        return;
    }
}
