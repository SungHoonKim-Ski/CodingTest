import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static void pro() {
        String str = scan.nextLine();
        char prev = 't';
        boolean prevIsOperator = false;
        for (int i = 0; i < str.length(); i++) {
            char cur = str.charAt(i);
            switch (cur) {
                case '<':
                case '>':
                case '(':
                case ')':
                    if (prev != ' ' && i != 0) sb.append(' ');
                    sb.append(cur);
                    prev = cur;
                    prevIsOperator = true;
                    break;
                case '&':
                case '|':
                    if (prev != ' ' && i != 0) sb.append(' ');
                    sb.append(cur);
                    sb.append(cur);
                    i++;
                    prev = cur;
                    prevIsOperator = true;
                    break;
                case ' ':
                    if (prev == ' ') continue;
                    sb.append(cur);
                    prev = cur;
                    prevIsOperator = true;
                    break;
                default:
                    if (prevIsOperator) {
                        if (prev != ' ') sb.append(' ');
                    }
                    prevIsOperator = false;
                    prev = cur;
                    sb.append(cur);
            }
        }
        System.out.println(sb);
    }

    public static void main(String[] args) {
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
