import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static char[] inputCharArr;
    static void input(){
        inputCharArr = scan.nextLine().toCharArray();
    }

    static void pro() {

        boolean isCorrect = true;

        for (int i = 0; i < inputCharArr.length; i++) {
            if (i == inputCharArr.length - 1) {
                isCorrect = false;
                break;
            }
            switch (inputCharArr[i]) {
                case 'p':
                    if (inputCharArr[i + 1] == 'i') i++;
                    else isCorrect = false;
                    break;
                case 'k':
                    if (inputCharArr[i + 1] == 'a') i++;
                    else isCorrect = false;
                    break;
                case 'c':
                    if (i + 2 != inputCharArr.length) {
                        if (inputCharArr[i + 1] == 'h' && inputCharArr[i + 2] == 'u') i += 2;
                        else isCorrect = false;
                    }
                    else isCorrect = false;
                    break;
                default:
                    isCorrect = false;
                    break;
            }
            if (!isCorrect) break;
        }


        if (isCorrect) sb.append("YES");
        else sb.append("NO");
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