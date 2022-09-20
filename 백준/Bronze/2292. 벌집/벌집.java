import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;


public class Main {

    //    private static Scanner sc = new Scanner(System.in);

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuffer sb = new StringBuffer();


        int input = Integer.parseInt(br.readLine());
        if(input == 1){
            System.out.println(1);
            return;
        }

        int i = 2;
        int moveCount = 1;
        while (true){
            for(int j=0; j <moveCount * 6; j++, i++){
                if(i == input){
                    System.out.println(moveCount+1);
                    return;
                }
            }
            moveCount++;
        }
    }

}