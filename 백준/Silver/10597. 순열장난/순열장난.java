import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer sb = new StringBuffer();
    static StringTokenizer st;
    static char[] inputCharArr;
    static HashSet<Integer> inputSet;
    static int inputLength;
    static boolean isPrint;
    static void input() throws IOException{

        inputCharArr = br.readLine().toCharArray();
        inputLength = inputCharArr.length;

    }
    static void pro() {

        inputSet = new HashSet<>();
        if (inputLength < 11) { // 9까지 나온 경우
            for (int i = 0; i < inputLength; i++) {
                sb.append(inputCharArr[i]).append(' '); // 백트래킹 필요 x
            }
            System.out.println(sb);
        } else {
            int realNum = 5 + inputLength / 2;
            for (int i = 1; i <= realNum; i++) inputSet.add(i);
            isPrint = false;
            dfs(0, 0, new int[realNum]);
        } // 결국 글자 수는 10 이하에서는 길이만큼이 나온 글자 수이고,
        // ex. 9인 경우 input의 legnth이 9
        // 10 이상인 경우 2자리로 들어오므로 해당 부분 처리를 하면
        // 길이에 따른 전체 수열들의 요소를 찾을 수 있음

    }

    static void dfs(int depth, int length, int[] elements) {
        // depth는 깊이, length는 입력 요소에서 현재 가리키고 있는 위치
        // elements는 백트래킹으로 현재 가지고 있는 배열

        if (isPrint) return; // 경우의 수가 많을 수도 있지만, 출력은 한 번만 해야 함
        if (length >= inputLength) {
            for (int element : elements) sb.append(element).append(' ');

            System.out.println(sb);
            isPrint = true;
            return;
        }
        if (inputCharArr[length] == '0') return; // 예외처리

        int oneNumber = inputCharArr[length] - '0'; // 입력값은 한자리 또는 두자리가 가능
        if (inputSet.contains(oneNumber)) { // 한자리 숫자의 경우
            elements[depth] = oneNumber;
            inputSet.remove(oneNumber);
            dfs(depth + 1, length + 1, elements);
            inputSet.add(oneNumber);
        }
        if (length > inputLength - 2) return;// 두 자리를 받아올 수 있는지 확인

        int twoNumber = (inputCharArr[length] - '0') * 10 + inputCharArr[length + 1] - '0';
        if (inputSet.contains(twoNumber)) { // 두자리 숫자의 경우
            elements[depth] = twoNumber;
            inputSet.remove(twoNumber);
            dfs(depth + 1, length + 2, elements);
            inputSet.add(twoNumber);
        }
    }
    public static void main(String[] args) throws IOException{
        input();
        pro();
    }

}