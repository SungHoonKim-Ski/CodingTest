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

        String[] inputSplit = br.readLine().split(" ");
        int count = Integer.parseInt(inputSplit[0]);
        int rewordCount = Integer.parseInt(inputSplit[1]);

        int[] users = new int[count];
        String[] usersSplit = br.readLine().split(" ");
        for(int i=0; i<count; i++){
            users[i] = Integer.parseInt(usersSplit[i]);
        }

        Arrays.sort(users);
        System.out.println(users[count - rewordCount]);

        br.close();
        sb.setLength(0);
    }

}