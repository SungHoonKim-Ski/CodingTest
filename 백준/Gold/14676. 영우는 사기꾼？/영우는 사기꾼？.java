import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int N, M, K;
    static ArrayList<Integer>[] adj;
    static int[] indeg;
    static int[] isBuild;
    static Deque<int[]> gameInfo;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        K = scan.nextInt();
        adj = new ArrayList[N + 1];
        indeg = new int[N + 1];
        isBuild = new int[N + 1];
        gameInfo = new LinkedList<>();

        for (int i = 1; i <= N; i++) adj[i] = new ArrayList<>();

        while (M-- > 0) {
            int s = scan.nextInt();
            int e = scan.nextInt();
            adj[s].add(e);
            indeg[e]++;
        }
    }

    static void pro() {

        boolean flag = true;
        while (K-- > 0) {
            int info = scan.nextInt(); 
            int buildings = scan.nextInt();
            if (info == 1) { // build
                if (indeg[buildings] != 0) {
                    flag = false;
                    break;
                }
                if (isBuild[buildings] == 0) {
                    for (int x : adj[buildings]) {
                        indeg[x]--;
                    }    
                }
                isBuild[buildings]++;
            } else { // destroy
                if (isBuild[buildings] == 0) {
                    flag = false;
                    break;
                }
                isBuild[buildings]--;
                if (isBuild[buildings] == 0) {
                    for (int x : adj[buildings]) {
                        indeg[x]++;
                    }
                }
            }
        }

        if (flag) System.out.println("King-God-Emperor");
        else System.out.println("Lier!");
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