import java.util.*;
import java.io.*;


public class Main
{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer sb = new StringBuffer();
    static StringTokenizer st;

    static char[] A, B;
    static int Y, X;

    public static void input() throws Exception
    {
        st = new StringTokenizer(br.readLine());
        A = st.nextToken().toCharArray();
        B = st.nextToken().toCharArray();
        Y = A.length;
        X = B.length;
    }

    static void pro()
    {
        int y = -1, x = -1;
        boolean find = false;
        for (int i = 0; i < Y; i++) {
            for (int j = 0; j < X; j++) {
                if (A[i] == B[j]) {
                    y = i;
                    x = j;
                    find = true;
                    break;
                }
            }
            if (find) break;
        }
        for (int j = 0; j < X; j++) {
            for (int i = 0; i < Y; i++) {
                if (j == x) sb.append(A[i]);
                else if (i == y) sb.append(B[j]);
                else sb.append('.');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception
    {
        input();
        pro();
    }
}
