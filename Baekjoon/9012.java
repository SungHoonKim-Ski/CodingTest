import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        int count = Integer.parseInt(input);

        for(; count >0; count--) {
            input = br.readLine();
            char[] inputChar = input.toCharArray();

            int openCount = 0;
            boolean openFlag = false;

            boolean isVPS = false;

            if (inputChar[0] == '(') {

                for (int i = 0; i < inputChar.length; i++) {
                    if (inputChar[i] == '(') {
                        openCount++;
                    }else if (inputChar[i] == ')') {
                        openCount--;
                    }
                    if (openCount < 0) {
                        break;
                    }
                }
                if (openCount == 0) {
                    isVPS = true;
                }
            }

            if (isVPS) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        br.close();
        return;
    }
}

