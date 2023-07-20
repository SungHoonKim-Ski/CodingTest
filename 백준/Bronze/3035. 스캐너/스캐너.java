import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int R, C, ZR, ZC;

    static char[][] InputChar;

    static void input()
    {
        R = scan.nextInt();
        C = scan.nextInt();
        ZR = scan.nextInt();
        ZC = scan.nextInt();
        InputChar = new char[R][];
        for (int i = 0; i < R; i++) InputChar[i] = scan.nextLine().toCharArray();

    }

    static void pro() {

        for (int r = 0; r < R; r++) {
            for (int zr = 0; zr < ZR; zr++) {
                    for (int c = 0; c < C; c++) {
                        for (int zc = 0; zc < ZC; zc++) sb.append(InputChar[r][c]);
                    }
                sb.append('\n');
            }
        }
        System.out.println(sb);
    }


    public static void main(String[] args){
        input();
        pro();

    }


    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}