import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String count;

        while(!(count = br.readLine()).equals("0")){
            int countToInt = Integer.parseInt(count);
            int[] input = new int[countToInt];
            int[] calInput = new int[countToInt];

            for(int i=0; i<countToInt; i++){
                input[i] = Integer.parseInt(br.readLine());
            }
            calInput[0] = input[0];

            for(int i=1; i<countToInt; i++){
                calInput[i] = Math.max(input[i], input[i] + calInput[i - 1]);
            }

            int max_sum = input[0];
            for(int i=0; i<countToInt; i++){
                if(calInput[i] > max_sum){
                    max_sum = calInput[i];
                }
            }
            System.out.println(max_sum);
        }

        return;
    }
}

