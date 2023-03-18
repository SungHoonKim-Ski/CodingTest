import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int p, w;
    static char[][] charArr;
    static int time = 0;

    static HashSet<Integer>[] alphaSet = new HashSet[26];
    static int[] originAlpha = new int[26];

    static void input() {
        p = scan.nextInt();
        w = scan.nextInt();
        String[] str = scan.nextLine().split(" ");
        charArr = new char[str.length][];
        for (int i = 0 ; i < str.length; i++) {
            charArr[i] = str[i].toCharArray();
        }
        for (int i = 0; i < 26; i++) {
            alphaSet[i] = new HashSet<>();
            int from = -1, to = -1;
            switch (i) {
                case 0:
                case 1:
                case 2:
                    from = 0;
                    to = 2;
                    originAlpha[i] = 1;
                    break;
                case 3:
                case 4:
                case 5:
                    from = 3;
                    to = 5;
                    originAlpha[i] = -2;
                    break;
                case 6:
                case 7:
                case 8:
                    from = 6;
                    to = 8;
                    originAlpha[i] = -5;
                    break;
                case 9:
                case 10:
                case 11:
                    from = 9;
                    to = 11;
                    originAlpha[i] = -8;
                    break;
                case 12:
                case 13:
                case 14:
                    from = 12;
                    to = 14;
                    originAlpha[i] = -11;
                    break;
                case 15:
                case 16:
                case 17:
                case 18:
                    from = 15;
                    to = 18;
                    originAlpha[i] = -14;
                    break;
                case 19:
                case 20:
                case 21:
                    from = 19;
                    to = 21;
                    originAlpha[i] = -18;
                    break;
                case 22:
                case 23:
                case 24:
                case 25:
                    from = 22;
                    to = 25;
                    originAlpha[i] = -21;
            }
            for (int j = from; j <= to; j++) {
                alphaSet[i].add(j);
            }
        }
    }

    static void pro() {
        time += (charArr.length - 1) * p;
        for (int i = 0; i < charArr.length; i++) {
            for (int j = 0; j < charArr[i].length; j++) {
                char curC = charArr[i][j];
                int curAscii = curC - 'A';
                time += (curAscii + originAlpha[curAscii]) * p;
                if (j == 0) continue;
                char prevC = charArr[i][j-1];
                int prevAscii = prevC - 'A';
                if (alphaSet[curAscii].contains(prevAscii)) {
                    time += w;
                }
            }
        }
        System.out.println(time);
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
