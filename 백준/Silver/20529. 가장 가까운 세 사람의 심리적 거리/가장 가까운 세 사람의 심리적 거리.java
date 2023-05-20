import java.io.*;
import java.util.StringTokenizer;

class Main {


    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, minDis = 16;
    static int[] mbti;

    static void input() throws IOException {

        N = scan.nextInt();
        minDis = 16;
        st = new StringTokenizer(scan.nextLine());
        mbti = new int[N];

        for (int i = 0; i < N; i++) {

            char[] mbtiChar = st.nextToken().toCharArray();

            if (mbtiChar[0] == 'E') {
                mbti[i] = 1;
            }
//            else { // I
//                mbti[i] = 2;
//            }
            if (mbtiChar[1] == 'S') {
                mbti[i] += 2;
            }
//            else { // N
//                mbti[i] += 20;
//            }
            if (mbtiChar[2] == 'T') {
                mbti[i] += 4;
            }
//            else { // F
//                mbti[i] += 200;
//            }
            if (mbtiChar[3] == 'J') {
                mbti[i] += 8;
            }
//            else { // P
//                mbti[i] += 2000;
//            }
        }
    }

    static void pro(){

        if (N < 33) {
            for (int i = 0; i < N - 2; i++) {
                for (int j = i + 1; j < N - 1; j++) {
                    for (int k = j + 1; k < N; k++) {
                        minDis = Math.min(minDis, calDis(mbti[i], mbti[j], mbti[k]));
                    }
                }
            }
        } else minDis = 0;
        System.out.printf("%d\n", minDis);
    }

    static int calDis (int i, int j, int k) {

        int disSum = 0;

//        int dis = Math.abs(i - j);
        int dis = i ^ j;
        for (; dis != 0; dis >>= 1) {
            disSum += dis % 2;
        }
        
//        dis = Math.abs(j - k);
        dis = j ^ k;
        for (; dis != 0; dis >>= 1) {
            disSum += dis % 2;
        }
        
//        dis = Math.abs(i - k);
        dis = i ^ k;
        for (; dis != 0; dis >>= 1) {
            disSum += dis % 2;
        }

        return disSum;
    }

    public static void main(String[] args) throws Exception {

        int T = scan.nextInt();
        while (T-- > 0) {
            input();
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