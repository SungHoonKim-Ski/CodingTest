import java.math.BigInteger;
import java.util.*;
import java.io.*;


public class Main
{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer sb = new StringBuffer();
    static StringTokenizer st;

//    static int[][] Origin;
//    static int[][][] dpMatrix;
    static char[] inputChar;


    public static void input() throws Exception
    {

//        Origin = new int[][]{{1, 1}, {0, 1}};
//
//        int initNum = 1, i = N;
//        dpMatrix = new int[61][2][2]; // 2^60 = max
//        dpMatrix[0] = new int[][]{{1, 1}, {0, 1}};
        inputChar = br.readLine().toCharArray();
    }

    static void pro() throws Exception
    {
//        boolean isEvenNum = true;
//
//        if (N % 2 == 1) {
//            isEvenNum = false;
//        }
//
//
//        int i = 1;
//        while (i )
        int cnt = 0;
        for (int i = 0; i < inputChar.length; i++) {
            switch (inputChar[i]) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                case 'A':
                case 'E':
                case 'I':
                case 'O':
                case 'U':
                    cnt++;
                    break;
            }
        }
        sb.append(cnt).append('\n');

    }

    static void mulMatrix(int[][] origin, int[][] mulMatrix) {

    }

    public static void main(String[] args) throws Exception
    {
        while (true) {
            input();
            if (inputChar[0] != '#') {
                pro();
            } else break;
        }
        System.out.println(sb);
    }
}