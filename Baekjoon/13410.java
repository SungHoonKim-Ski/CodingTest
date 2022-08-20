import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputNum = br.readLine().split(" ");

        int n = Integer.parseInt(inputNum[0]);
        int k = Integer.parseInt(inputNum[1]);

        int count = n*k;

        int[] mul = new int[count];
        int[] revmul = new int[count];

        for(int i=0; i< k; i++){
            mul[i] = (i+1) * n;
        }

        for(int i=0; i<k; i++){
            revmul[i] = revNum(mul[i]);
            System.out.println(revmul[i]);
        }

        int max = 0;

        for(int i=0; i<k; i++){
            if(revmul[i] > max){
                max = revmul[i];
            }
        }

        System.out.println(max);

    }

    static int revNum(int num){

        if(num < 10){
            return num;
        }

        StringBuffer res = new StringBuffer();

        while(num > 9){
            res.append(num % 10);
            num /= 10;
        }

        res.append(num);
        return Integer.parseInt(res.toString());
    }



}

