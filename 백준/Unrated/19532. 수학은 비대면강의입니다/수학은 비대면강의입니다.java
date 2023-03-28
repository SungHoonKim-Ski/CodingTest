import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int[] inputInt;
    static boolean[][] arr;
    static boolean[] visit;

    static int[] dy = new int[]{0, 1, 0, -1};
    static int[] dx = new int[]{1, 0, -1, 0};

    static void input() {

        inputInt = new int[6];
        for (int i = 0; i < 6; i++) {
            inputInt[i] = scan.nextInt();
        }
    }

    static void pro() {


        int x = (inputInt[2] * inputInt[4] - inputInt[1] * inputInt[5]) / (inputInt[0] * inputInt[4] - inputInt[1] * inputInt[3]);
        int y = (inputInt[2] * inputInt[3] - inputInt[0] * inputInt[5]) / (inputInt[1] * inputInt[3] - inputInt[0] * inputInt[4]);

        sb.append(x).append(' ').append(y);
        System.out.println(sb);
    }

    public static void main(String[] args) {

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