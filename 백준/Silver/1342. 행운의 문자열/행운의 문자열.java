    import java.io.*;
    import java.util.*;


    public class Main {

        static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        static StringBuilder sb = new StringBuilder();
        static StringTokenizer st;

        static char[] str;
        static int n, count;
        static boolean[] visit;

        static void input() throws Exception {
            str = br.readLine().toCharArray();
            n = str.length;
        }

        public static void pro() {
            Arrays.sort(str);
            visit = new boolean[n];

            char[] cur = new char[n + 1];
            backTrack(0, cur);

            System.out.println(count);
        }

        static void backTrack(int depth, char[] cur) {
            if (depth == n) {
                count++;
                return;
            }

            char prev = ' ';
            for (int i = 0; i < n; i++) {
                if (visit[i]) continue;
                if (depth != 0 && cur[depth - 1] == str[i]) continue;
                if (prev == str[i]) continue;
                prev = str[i];
                visit[i] = true;
                cur[depth] = str[i];
                backTrack(depth + 1, cur);
                visit[i] = false;
            }
        }

        public static void main(String[] args) throws Exception{
            input();
            pro();
        }
    }