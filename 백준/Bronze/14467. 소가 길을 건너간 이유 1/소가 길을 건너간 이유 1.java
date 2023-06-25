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
    static int N, P;


    public static void input() throws Exception
    {

//        Origin = new int[][]{{1, 1}, {0, 1}};
//
//        int initNum = 1, i = N;
//        dpMatrix = new int[61][2][2]; // 2^60 = max
//        dpMatrix[0] = new int[][]{{1, 1}, {0, 1}};
        N = Integer.parseInt(br.readLine());
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

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int loc = Integer.parseInt(st.nextToken());
            if (!hashMap.containsKey(num)) {
                hashMap.put(num, loc);
            } else {
                if (loc != hashMap.get(num)) {
                    cnt++;
                    hashMap.replace(num, loc);
                }
            }
        }
        System.out.println(cnt);
    }

    static void mulMatrix(int[][] origin, int[][] mulMatrix) {

    }

    public static void main(String[] args) throws Exception
    {
        input();
        pro();
//        System.out.println(sb);
    }
}