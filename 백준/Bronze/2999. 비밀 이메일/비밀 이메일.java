import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] inputChar = br.readLine().toCharArray();
        int N = (int)Math.sqrt(inputChar.length);

        int R = 1;
        int C = inputChar.length; // R <= C

        for (int i = 1; i <= N; i++) {
            if (inputChar.length % i == 0 && i <= inputChar.length / i) {
                R = i;
                C = inputChar.length / i;
            }
        }

        char[][] matrix = new char[R][C];

        int x = 0;
        for (int i=0; i<C; i++) {
            for (int j=0; j<R; j++, x++) {
                matrix[j][i] = inputChar[x];
            }
        }
        StringBuffer sb = new StringBuffer();

        for (int i=0; i<R; i++) {
            for (int j=0; j<C; j++, x++) {
                sb.append(matrix[i][j]);
            }
        }
        System.out.println(sb);
    }
}
