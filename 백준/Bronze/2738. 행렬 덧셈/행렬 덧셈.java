import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer sb = new StringBuffer();
    static StringTokenizer st;
    static int n, m;

    static int[][][] matrix;

    static void input() throws IOException{
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        matrix = new int[2][n][m];

        for (int k = 0; k < 2; k++) {
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++) {
                    matrix[k][i][j] = Integer.parseInt(st.nextToken());
                }
            }
        }
    }

    static void pro(){

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(matrix[0][i][j] + matrix[1][i][j]).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);

    }

    public static void main(String[] args) throws IOException{

        input();
        pro();

    }

}