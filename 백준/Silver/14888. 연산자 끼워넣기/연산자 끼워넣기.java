import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    static int[] arrA;
    static int[] operatorArr, curUseOperator;
    static int operatorCnt = 0, maxNum = -1000000001, minNum = 1000000001;
    static StringBuffer sb;
    public static void main(String[] args) {

        Scanner sc = new Scanner(new InputStreamReader(System.in));
        int arrCnt = sc.nextInt();
        arrA = new int[arrCnt];
        operatorArr = new int[4];
        curUseOperator = new int[4];
        for (int i = 0; i < arrCnt; i++) arrA[i] = sc.nextInt();
        for (int i = 0; i < 4; i++) {
            operatorArr[i] = sc.nextInt();
            operatorCnt += operatorArr[i];
        }
        recur_func(1, arrA[0]);
        System.out.println(maxNum);
        System.out.println(minNum);
    }
    
    static void recur_func(int depth, int num) {

        if (depth == operatorCnt + 1) {
            maxNum = Math.max(maxNum, num);
            minNum = Math.min(minNum, num);
            return;
        }

        for (int j = 0; j < 4; j++) {
            if (operatorArr[j] > curUseOperator[j]) {
                curUseOperator[j]++;
                switch (j) {
                    case 0:
                        recur_func(depth + 1, num + arrA[depth]);
                        break;
                    case 1:
                        recur_func(depth + 1, num - arrA[depth]);
                        break;
                    case 2:
                        recur_func(depth + 1, num * arrA[depth]);
                        break;
                    case 3:
                        recur_func(depth + 1, num / arrA[depth]);
                }
                curUseOperator[j]--;
            }
        }
    }

}
