
import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static char[] charArr;

    static void input() {
        charArr = scan.nextLine().toCharArray();
    }

//    static void dfs(int x) {
//
//        vertex_cnt++;
//        edge_cnt += adj[x].size();
//        visit[x] = true;
//        for (int y: adj[x]) {
//            if (visit[y]) continue;
//            dfs(y);
//        }
//    }

    static boolean pro() {

        Stack<Character> stack = new Stack<>();

        for (char c: charArr) {
            if (c == '.') break;
            if (c == '['  || c == ']' || c == '(' || c == ')') {
                if (c == '[') {
                    stack.push(c);
                }else if (c == ']') {
                    if (stack.size() == 0) return false;
                    if (stack.pop()  != '[') return false;
                }else if (c == '(') {
                    stack.push(c);
                }else {
                    if (stack.size() == 0) return false;
                    if (stack.pop()  != '(') return false;
                }
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {

        input();
        while (charArr[0] != '.') {
            if (pro()) {
                sb.append("yes");
            } else {
                sb.append("no");
            }
            sb.append('\n');
            input();
        }

        System.out.print(sb);
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