import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());

        int maxVal = input/3;
        int minVal = input/5;

        int res = Integer.MAX_VALUE;

        for(int i=0; i<=maxVal; i++){
            for(int j=0; j<=minVal; j++){
                if((i * 3 + j * 5) == input){
                    if(res > (i + j)){
                        res = i + j;
                    }
                }
            }
        }

        if(res == Integer.MAX_VALUE){
            System.out.println(-1);
        }else{
            System.out.println(res);
        }
        return;
    }

}
