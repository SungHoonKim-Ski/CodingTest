import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static HashSet<Integer> inputSet;
    static void input()
    {
        StringTokenizer st = new StringTokenizer(scan.nextLine());
        inputSet = new HashSet<>();
        while (true) {
            int i = Integer.parseInt(st.nextToken());
            if (i == 0) break;
            inputSet.add(i);
            if (i == -1) break;
        }
    }

    static void pro() {

        int cnt = 0;
        for (int i : inputSet) {
            if (inputSet.contains(i * 2)) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    public static void main(String[] args){

        while (true){
            input();
            if (inputSet.contains(-1)) break;
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