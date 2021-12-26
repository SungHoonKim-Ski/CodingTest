import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputStr = br.readLine().split(" ");

        // 1 <= down < up <= target

        int up = Integer.parseInt(inputStr[0]);
        int down = Integer.parseInt(inputStr[1]);
        int target = Integer.parseInt(inputStr[2]);

        int res  = (target - down) / (up - down);

        if((target - down)%(up - down) != 0){
            ++res;
        }

        System.out.println(res);
        return;
    }

}
