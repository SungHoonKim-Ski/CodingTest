import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N = -1;
    static LinkedList<String> InputList;
    static LinkedList<String> UpperInputList;

    static void input()
    {
//        StringTokenizer st = new StringTokenizer(scan.nextLine());
//        N = scan.nextInt();
        N = scan.nextInt();
        if (N == 0) return;

        UpperInputList = new LinkedList<>();
        InputList = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            String s = scan.nextLine();
            InputList.add(s);
            UpperInputList.add(s.toUpperCase());
        }
    }

    static void pro() {

        Collections.sort(UpperInputList);

        for (String s: InputList) {

            if (s.toUpperCase().equals(UpperInputList.get(0))) {
                System.out.println(s);
                break;
            }
        }
    }



    public static void main(String[] args){


        while (true) {
            input();
            if (N == 0) break;
            pro();
        }

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