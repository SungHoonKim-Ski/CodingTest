import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static int[] indeg, T_done, T;
    static ArrayList<Integer>[] adj;

    static void input() {
    	
    	N = scan.nextInt();
    	M = scan.nextInt();
        /* TODO */
    	indeg = new int[N + 1];
    	T_done = new int[N + 1];
    	T = new int[N + 1];
    	adj = new ArrayList[N + 1];
    	
    	for	(int i = 1; i <= N; i++) T[i] = scan.nextInt(); 
    	for (int i = 1; i <= N; i++) adj[i] = new ArrayList<>();   
    	for (int i = 0; i < M; i++) {
    		int s = scan.nextInt();
    		int e = scan.nextInt();
    		adj[s].add(e);
    		indeg[e]++;
    	}
    }

    static void pro() {
        Deque<Integer> queue = new LinkedList<>();
        // 제일 앞에 "정렬될 수 있는" 정점 찾기
        for (int i = 1; i <= N; i++) 
        	if (indeg[i] == 0) {
        		queue.add(i);
        		T_done[i] = T[i]; 
        	}
        /* TODO */
        while (!queue.isEmpty()) {
        	int x = queue.poll();
        	for (int y : adj[x]) {
        		indeg[y]--;
    			T_done[y] = Math.max(T_done[y], T_done[x] + T[y]); 
        		if (indeg[y]== 0) queue.add(y);
        	}
        }
        // 위상 정렬 순서대로 T_done 계산을 함께 해주기
        int res = scan.nextInt();
        System.out.println(T_done[res]);
        /* TODO */
    }

    public static void main(String[] args) {
        int tc = scan.nextInt();
        while (tc > 0) {
            tc--;
            input();
            pro();
        }
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