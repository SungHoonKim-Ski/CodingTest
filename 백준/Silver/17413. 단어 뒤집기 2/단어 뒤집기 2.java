import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static char[] inputArr;

    static void input() { 
        inputArr = scan.nextLine().toCharArray();
    }

    static void pro() {
        Stack<Character> inputStack = new Stack<>();
        boolean isOpened = false;
        for (int i = 0; i < inputArr.length; i++) {
            if (inputArr[i] == '<') {
                while (!inputStack.empty()) sb.append(inputStack.pop());
                isOpened = true;
            } else if (inputArr[i] == '>') {
                isOpened = false;
                sb.append('>');
                continue;
            }

            if (isOpened || inputArr[i] == ' ') {
                while (!inputStack.empty()) sb.append(inputStack.pop());
                sb.append(inputArr[i]);
            }
            else inputStack.add(inputArr[i]);
        }
        while (!inputStack.empty()) sb.append(inputStack.pop());

        System.out.println(sb);
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