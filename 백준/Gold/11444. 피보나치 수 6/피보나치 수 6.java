import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer sb = new StringBuffer();
    static StringTokenizer st;
    static long n;
    static final long MOD_VAL = 1_000_000_007;
    static final long[][] one = {{1, 1}, {1, 0}};

    static void input() throws IOException{
        n = Long.parseLong(br.readLine());
    }

    static long[][] mulMatrix(long[][] matrix1, long[][] matrix2) {

        long[][] res = new long[2][2];

        res[0][0] = (matrix1[0][0] * matrix2[0][0] + matrix1[0][1] * matrix2[1][0]) % MOD_VAL;
        res[1][0] = (matrix1[1][0] * matrix2[0][0] + matrix1[1][1] * matrix2[1][0]) % MOD_VAL;
        res[0][1] = (matrix1[0][0] * matrix2[0][1] + matrix1[0][1] * matrix2[1][1]) % MOD_VAL;
        res[1][1] = (matrix1[1][0] * matrix2[0][1] + matrix1[1][1] * matrix2[1][1]) % MOD_VAL;
        return res;
    }

    static long[][] recur(long[][] matrix, long exp) {

        if (exp == 0 || exp == 1) return matrix;

        long[][] div = recur(matrix, exp / 2);

        div = mulMatrix(div, div);

        if (exp % 2 == 1) {
            div = mulMatrix(div, one);
        }
        return div;
    }

    static void pro() throws IOException{
        System.out.println(recur(one, n - 1)[0][0]);
    }

    public static void main(String[] args) throws IOException{
        input();
        pro();
    }

}