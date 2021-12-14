import java.util.Scanner;

public class Main {

    public static void main(String args[]) throws Exception{ // Q.1110

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int inputNum = Integer.parseInt(br.readLine());
        if(inputNum > 99){
            return;
        }

        int cycleCount = 0;
        int curNum = inputNum;
        int num1;
        int num10;
        do{
            cycleCount++;

            num1 = curNum % 10;
            num10 = curNum / 10;
            curNum = (10 * num1) + (num1 + num10) % 10;

        }while (curNum != inputNum);
        System.out.println(cycleCount);
        return;
    }
}
