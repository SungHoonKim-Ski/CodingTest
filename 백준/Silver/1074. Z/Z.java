import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int N, R, C;
    static int cnt = 0;
    static boolean flag = false;

    static void input() {
        N = scan.nextInt();
        R = scan.nextInt();
        C = scan.nextInt();
    }

    static void pro() {
        int n = (int)Math.pow(2, N);
        divide(R, C, n);
        System.out.println(cnt);
    }

    static void divide(int startY, int startX, int size) {

        if (size == 1) return;
        if (startY < size / 2 && startX < size / 2) {
            divide(startY, startX, size / 2);
        }
        else if (startY < size / 2 && startX >= size / 2) {
            cnt += size * size / 4;
            divide(startY, startX - size / 2, size / 2);
        }
        else if (startY >= size / 2 && startX < size / 2) {
            cnt += (size * size / 4) * 2;
            divide(startY - size / 2, startX, size / 2);
        }
        else {
            cnt += (size * size / 4) * 3;
            divide(startY - size / 2, startX - size / 2, size / 2);
        }

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