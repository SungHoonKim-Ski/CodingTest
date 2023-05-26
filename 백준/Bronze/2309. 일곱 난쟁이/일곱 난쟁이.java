import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {


    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int[] inputArr;
    static int N = 9, res;
    static boolean[] visit;
    static boolean flag;

    static void input() throws IOException {
        inputArr = new int[N];
        visit = new boolean[N];
        for (int i = 0; i < N; i++) inputArr[i] = scan.nextInt();
    }

    static void pro(){
        Arrays.sort(inputArr);
        DFS(0, new int[7], 0);
    }

    static void DFS(int depth, int[] input, int sum) {

        if (flag) return;
        if (sum > 100) return;
        if (depth == 7) {
            if (sum == 100) {
                flag = true;
                for (int i = 0; i < input.length; i++) System.out.println(input[i]);
            }
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visit[i]) {
                visit[i] = true;
                input[depth] = inputArr[i];
                DFS(depth + 1, input, sum + inputArr[i]);
                visit[i] = false;
            }
        }


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