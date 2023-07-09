import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int cnt = 0;

    static char[] inputCharArr;
    static void input()
    {
        inputCharArr = scan.nextLine().toCharArray();
    }

    static void pro() {

        dfs(0, '.');
        System.out.println(cnt);
    }

    static void dfs(int depth, char prev)
    {
        if (depth == inputCharArr.length) {
            cnt++;
            return;
        }

        if (prev != '.') {
            if (inputCharArr[depth] == inputCharArr[depth - 1]) {
                if (inputCharArr[depth] == 'c') { // num
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == prev) continue;
                        dfs(depth + 1, c);
                    }
                } else { // alpha
                    for (char c = '0'; c <= '9'; c++) {
                        if (c == prev) continue;
                        dfs(depth + 1, c);
                    }
                }
            } else {
                if (inputCharArr[depth] == 'c') { // num
                    for (char c = 'a'; c <= 'z'; c++) {
                        dfs(depth + 1, c);
                    }
                } else { // alpha
                    for (char c = '0'; c <= '9'; c++) {
                        dfs(depth + 1, c);
                    }
                }
            }
        } else {
            if (inputCharArr[depth] == 'c') { // num
                for (char c = 'a'; c <= 'z'; c++) {
                    dfs(depth + 1, c);
                }
            } else { // alpha
                for (char c = '0'; c <= '9'; c++) {
                    dfs(depth + 1, c);
                }
            }
        }
    }

    public static void main(String[] args){
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