import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static int[] input_val;
    static int[] prev_val;

    static void input() {

        N = scan.nextInt();
        M = scan.nextInt();
        input_val = new int[N];
        prev_val = new int[M];
        for (int i = 0; i < N; i++) input_val[i] = scan.nextInt();
    }

    static void pro() {
        Arrays.sort(input_val);
        recur_func(0, 0);
        System.out.println(sb);
    }

    static void recur_func(int depth, int idx) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(prev_val[i]).append(' ');
            }
            sb.append('\n');
        }else {
            for (int i = idx; i < N; i++){
                prev_val[depth] = input_val[i];
                recur_func(depth + 1, i);
            }
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
