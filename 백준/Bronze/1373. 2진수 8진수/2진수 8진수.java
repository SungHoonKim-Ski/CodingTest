import java.io.*;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

class Main {


    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static char[] inputChar;
    static int N;

    static void input() throws IOException {
        inputChar = scan.nextLine().toCharArray();
        N = inputChar.length;
    }

    static void pro() {

        Stack<Integer> stack = new Stack<>();
        for (int i = N-1; i >= 0; i--) {
            int num = 0;
            for (int j = 0; j < 3 && i >= 0; j++,i--) {
                if ( inputChar[i] == '1' )
                    num += Math.pow(2, j);
            }
            i++;
            stack.add(num);
        }

        while (!stack.isEmpty()) sb.append(stack.pop());
        System.out.println(sb);
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