import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer sb = new StringBuffer();
    static StringTokenizer st;

    static int n;
    static long b;

    static long[][] matrix;

    static void input() throws IOException{

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        b = Long.parseLong(st.nextToken());

        matrix = new long[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken()) % 1000;
            }
        }
    }

    static void pro(){

        long[][] resMatrix = divide(matrix, b);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(resMatrix[i][j]).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    static long[][] divide(long[][] origin, long exp) {

        if (exp == 1) return origin;

        long[][] divMatrix = divide(origin, exp / 2);

        divMatrix = mulMatrix(divMatrix, divMatrix);

        if (exp % 2 == 1) {
            divMatrix = mulMatrix(divMatrix, origin);
        }
        return divMatrix;
    }

    static long[][] mulMatrix(long[][] matrix1, long[][] matrix2) {

        long[][] resMatrix = new long[n][n];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix2[0].length; j++) {
                for (int k = 0; k < matrix1[0].length; k++) {
                    resMatrix[i][j] += matrix1[i][k] * matrix2[k][j];
                }
                resMatrix[i][j] %= 1000;
            }
        }
        return resMatrix;
    }



    public static void main(String[] args) throws IOException{
        input();
        pro();
    }

}