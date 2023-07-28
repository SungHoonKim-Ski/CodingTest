import java.io.*;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static StringTokenizer st;

    static char[][] InputCharArr;
    static int Y, X;



    static void input() throws IOException
    {
        st = new StringTokenizer(br.readLine());
        Y = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        InputCharArr = new char[Y][X];
        for (int i = 0; i < Y; i++) InputCharArr[i] = br.readLine().toCharArray();
    }

    static void pro()
    {
        for (int y = Y - 1; y >= 0; y--) {
            for (int x = 0; x < X; x++) sb.append(InputCharArr[y][x]);
            sb.append('\n');
        }
    }


    public static void main(String[] args) throws Exception{

        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            input();
            pro();
        }
        System.out.println(sb);
    }

}