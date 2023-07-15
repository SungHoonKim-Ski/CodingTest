import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static char[] Anum, Bnum;

    static void input()
    {
//        StringTokenizer st = new StringTokenizer(scan.nextLine());
//        N = scan.nextInt();
        Anum = scan.nextLine().toCharArray();
        Bnum = scan.nextLine().toCharArray();
    }

    static void pro() {

        char[] mixNum = new char[Anum.length + Bnum.length];
        for (int i = 0, j = 0; i < mixNum.length; i+=2, j++) mixNum[i] = Anum[j];
        for (int i = 1, j = 0; i < mixNum.length; i+=2, j++) mixNum[i] = Bnum[j];

        while (mixNum.length != 2) {
            char[] tmpNum = new char[mixNum.length - 1];
            for (int i = 0; i < tmpNum.length; i++) {
                tmpNum[i] = (char) (mixNum[i] - '0' + mixNum[i + 1]);
                if (tmpNum[i] > '9') tmpNum[i] -= 10;
            }
            mixNum = tmpNum;
        }
        sb.append(mixNum[0]).append(mixNum[1]);
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