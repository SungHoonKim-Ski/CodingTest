import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer sb = new StringBuffer();
    static StringTokenizer st;
    static int n, maxNum, minNum;
    static int[] operatorArr = new int[4];
    static int[] inputArr;

    static void input() throws IOException{

        maxNum = Integer.MIN_VALUE;
        minNum = Integer.MAX_VALUE;

        n = Integer.parseInt(br.readLine());
        inputArr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) inputArr[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) operatorArr[i] = Integer.parseInt(st.nextToken());
    }
    static void pro() {

        dfs(1, inputArr[0]); // 초기값 설정 필요
        sb.append(maxNum).append('\n').append(minNum);
        System.out.println(sb);
    }

    static void dfs(int depth, int calNum) {

        // startIdx는 동일한 연산 반복을 피하기 위해 사용

        if (depth == n) {
            maxNum = Math.max(maxNum, calNum);
            minNum = Math.min(minNum, calNum);
            return;
        }

        for (int j = 0; j < operatorArr.length; j++) {
            if (operatorArr[j] == 0) continue;
            operatorArr[j]--;
            switch (j) {
                case 0:
                    dfs(depth + 1, calNum + inputArr[depth]);
                    break;
                case 1:
                    dfs(depth + 1, calNum - inputArr[depth]);
                    break;
                case 2:
                    dfs(depth + 1, calNum * inputArr[depth]);
                    break;
                case 3:
                    dfs(depth + 1, calNum / inputArr[depth]);
                    break;
                default:
                    break;
            }
            operatorArr[j]++;
        }

    }

    public static void main(String[] args) throws IOException{

        input();
        pro();
    }

}