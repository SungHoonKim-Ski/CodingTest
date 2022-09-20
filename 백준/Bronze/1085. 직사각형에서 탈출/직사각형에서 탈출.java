import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int x = Integer.parseInt(input[0]);
        int y = Integer.parseInt(input[1]);

        int w = Integer.parseInt(input[2]);
        int h = Integer.parseInt(input[3]);

        System.out.print(Math.min(Math.min(x, y), Math.min(w-x, h-y)));
    }

}