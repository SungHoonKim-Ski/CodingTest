import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Stack;
import java.util.StringTokenizer;

class Main {


    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N;
    static int[][] inputArr;

    static void input() throws IOException {

        N = scan.nextInt();
        inputArr = new int[N][5];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 5; j++) {
                inputArr[i][j] = scan.nextInt();
            }
        }

    }

    static void pro() {

        int[] banCnt = new int[N];
        for (int x = 0; x < N; x++) {
            boolean[] isSameBan = new boolean[N];
            for (int j = 0; j < 5; j++) {
                int xBan = inputArr[x][j];
                for (int i = 0; i < N; i++) {
                    if (x == i) continue;
                    if (isSameBan[i]) continue;
                    if (xBan == inputArr[i][j]) {
                        isSameBan[i] = true;
                    }
                }
            }
            for (int i = 0; i < N; i++) {
                if (isSameBan[i]) banCnt[i]++;
            }
        }

        int max = -1, maxNum = 0;
        for (int i = 0; i < N; i++) {
            if (max < banCnt[i]) {
                max = banCnt[i];
                maxNum = i;
            }
        }

        System.out.println(maxNum + 1);
    }

    public static void main(String[] args) throws Exception {

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