import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int m;
//    static ArrayList<Integer>[] adj;
//    static boolean[] visit;
//    static int vertex_cnt, edge_cnt, treeCnt;
//    static int caseCnt = 0;
    static HashSet<Integer> hashSet;

    static void input() {

        m = scan.nextInt();
        hashSet = new HashSet<>();
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

    static void pro() {

        while (m-- > 0) {
            char[] c = scan.next().toCharArray();
            switch (c[0]) {
                case ('a') :
                    if (c[1] == 'd') {
                        hashSet.add(scan.nextInt());
                    }else {
                        for (int i = 1; i < 21; i++) hashSet.add(i);
                    }
                    break;
                case ('r') :
                    hashSet.remove(scan.nextInt());
                    break;
                case ('c') :
                    if (hashSet.contains(scan.nextInt())) sb.append('1');
                    else sb.append('0');
                    sb.append('\n');
                    break;
                case ('t') :
                    int input = scan.nextInt();
                    if (hashSet.contains(input)) hashSet.remove(input);
                    else hashSet.add(input);
                    break;
                case ('e') :
                    hashSet = new HashSet<>();
                    break;
            }
        }
    }

    public static void main(String[] args) {

        input();
        pro();
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