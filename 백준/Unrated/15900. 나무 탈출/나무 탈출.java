import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int n, cnt = 0;
    static ArrayList<Integer>[] child;

    static void input() {

        n = scan.nextInt();
        child = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) child[i] = new ArrayList<>();

        for (int i = 1; i < n; i++) {

            int v1 = scan.nextInt();
            int v2 = scan.nextInt();
            child[v1].add(v2);
            child[v2].add(v1);
        }

    }

    static void dfs(int x, int parent, int depth) {

        if (child[x].size() == 1 && child[x].get(0) == parent) {
            cnt += depth;
            return;
        }

        for (int y: child[x]) {
            if (y == parent) continue;
            dfs(y, x, depth + 1);
        }
    }

    static void pro() {
        dfs(1, -1, 0);
        if (cnt % 2 == 0) System.out.println("No");
        else System.out.println("Yes");
    }

    public static void main(String[] args) {
        input();
        pro();
    }


    static class FastReader {
        // BufferedReader의 빠른 속도,
        // + Scanner의 타입별 입력값을 받는 기능을 혼합
        // (자바 내부에 구현된 Scanner는 속도가 느림)
        // 다른분의 코드를 참고한 코드
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