import java.io.*;
import java.util.StringTokenizer;

class Solution {


    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br;
    static StringTokenizer st;


    static int N;
    static int[] inputArr;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        inputArr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) inputArr[i] = Integer.parseInt(st.nextToken());
    }

    static void pro(int tc) throws Exception{

        int R = 0, L = 0;
        int sum = 0;
        int max = inputArr[0];

        while(R < N && L < N) {
            sum += inputArr[R];
            max = Math.max(max, sum);

            if(sum < 0) {
                L = ++R;
                sum = 0;
            }else R++;
        }
        sb.append(String.format("#%d %d\n", tc, max));
    }

    public static void main(String[] args) throws Exception{

        br = new BufferedReader(new InputStreamReader(System.in));
//        br = new BufferedReader(new InputStreamReader(new FileInputStream("res/input.txt")));

        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++) {
            input();
            pro(tc);
        }
        System.out.println(sb);

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