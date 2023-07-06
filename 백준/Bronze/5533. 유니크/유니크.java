import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[][] InputScore;
    static void input(){

        N = scan.nextInt();
        InputScore = new int[N][3];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(scan.nextLine());
            for (int j = 0; j < 3; j++) InputScore[i][j] = Integer.parseInt(st.nextToken());
        }
    }

    static void pro() {

        int[] sumScore = new int[N];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < N; j++) { // curScore;
                boolean flag = true;
                for (int k = 0; k < N; k++) { // compareScore;
                    if (j == k) continue;
                    if (InputScore[j][i] == InputScore[k][i]) {
                        flag = false;
                        break;
                    }
                }
                if (flag) sumScore[j] += InputScore[j][i];
            }
        }

        for (int i = 0; i < N; i++) sb.append(sumScore[i]).append('\n');
        System.out.println(sb);

    }

    public static void main(String[] args) throws IOException {
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