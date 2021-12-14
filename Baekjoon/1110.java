import java.util.Scanner;

public class Main {

    public static void main(String args[]) throws Exception{ // Q.1110

        Scanner sc = new Scanner(System.in);
        int inputNum = sc.nextInt();
        if(inputNum > 99){
            return;
        }

        int cycleCount = 0;
        int curNum = inputNum;
        do{
            ++cycleCount;

            if(curNum < 10){
                curNum *= 11;
            }else{
                int num1 = curNum % 10;
                int num10 = curNum / 10;
                curNum = (10 * num1) + (num1 + num10) % 10;
            }
        }while (curNum != inputNum);
        System.out.println(cycleCount);
        return;
    }
}
