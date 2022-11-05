import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int inputNum = (Integer.parseInt(br.readLine()));
        countHansu(inputNum);
        return;
    }
    static void countHansu(int num) {
        int countHansu = 0;
        if(num < 100){
            countHansu = num;
        }else{
            countHansu = 99;
            for(int i=100; i<=num; i++){ // strnum.length = 3 (1000 제외)
                String strNum = String.valueOf(i);
                if((strNum.charAt(1) - strNum.charAt(0)) == (strNum.charAt(2)  - strNum.charAt(1))){
                    countHansu++;
                }
            }

        }
        System.out.println(countHansu);
        return;
    }
}
