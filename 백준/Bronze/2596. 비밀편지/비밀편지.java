import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;

    static String[] InputString;

    static void input()
    {
//        StringTokenizer st = new StringTokenizer(scan.nextLine());
//        N = scan.nextInt();
        N = scan.nextInt();
        InputString = new String[N];
        char[] inputChar = scan.nextLine().toCharArray();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 6; j++) {
                sb.append(inputChar[i * 6 + j]);
            }
            InputString[i] = sb.toString();
            sb.setLength(0);
        }
    }

    static void pro() {

        boolean isValid = false;
        String[] alpha = {"000000", "001111", "010011", "011100","100110",
                "101001", "110101", "111010"};
        for (int i = 0; i < N; i++) {
            isValid = true;
            switch (InputString[i]) {
                case "000000":
                    sb.append('A');
                    break;
                case "001111":
                    sb.append('B');
                    break;
                case "010011":
                    sb.append('C');
                    break;
                case "011100":
                    sb.append('D');
                    break;
                case "100110":
                    sb.append('E');
                    break;
                case "101001":
                    sb.append('F');
                    break;
                case "110101":
                    sb.append('G');
                    break;
                case "111010":
                    sb.append('H');
                    break;
                default:
                    isValid = false;
                    String curStr = InputString[i];
                    int[] notSameCnt = new int[8];
                    for (int j = 0; j < 6; j++) {
                        char curChar = curStr.charAt(j);
                        for (int k = 0; k < 8; k++) {
                            char compareChar = alpha[k].charAt(j);
                            if (compareChar != curChar) notSameCnt[k]++;
                        }
                    }

                    for (int j = 0; j < 8; j++) {
                        if (notSameCnt[j] <= 1) {
                            sb.append((char)(j + 'A'));
                            isValid = true;
                            break;
                        }
                    }
                    if (!isValid) System.out.println(i + 1);
            }
            if (!isValid) break;
        }
        if (isValid) System.out.println(sb);
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