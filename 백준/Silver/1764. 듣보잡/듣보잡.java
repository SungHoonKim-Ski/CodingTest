import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static String[] A;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        A = new String[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = scan.nextLine();
        }
    }

    static boolean bin_search(int[] A, int L, int R, int X) {

        while (L <= R) {
            int mid = (L + R) / 2;
            if (A[mid] == X) return true;
            if (A[mid] <= X)
                L = mid + 1;
            else{
                R = mid - 1;
            }
        }
        return false;
    }

    static boolean bin_search(String[] A, int L,int R, String X){
        while (L <= R){
            int mid = (L + R) / 2;
            if (A[mid].equals(X))
                return true;

            if (A[mid].compareTo(X) < 0)
                L = mid + 1;
            else
                R = mid - 1;
        }
        return false;
    }
    static void pro() {

        Arrays.sort(A, 1, N + 1);
        int res = 0;
        String[] resStr = new String[M];
        for (int i = 1; i <= M; i++) {
            String input = scan.nextLine();
            if(bin_search(A, 1, N, input)) {
                resStr[++res] = input;
            }
        }
        Arrays.sort(resStr, 1, res + 1);
        System.out.println(res);
        for (int i = 1; i <= res; i++) sb.append(resStr[i]).append('\n');
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