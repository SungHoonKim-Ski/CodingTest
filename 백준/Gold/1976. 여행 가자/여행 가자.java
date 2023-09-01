import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer sb = new StringBuffer();
    static StringTokenizer st;

    static ArrayList<Integer>[] graph;
    static int[] path;
    static int n;
	static int m;
	
	static boolean[] visit;
    
    public static void input() throws IOException{

    	n = Integer.parseInt(br.readLine());
    	m = Integer.parseInt(br.readLine());
    	
    	visit = new boolean[n + 1];
    	graph = new ArrayList[n + 1];
    	for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();
    	
    	for (int i = 1; i <= n; i++) {
    		st = new StringTokenizer(br.readLine());
    		for (int j = 1; j <= n; j++) {
        		char c = st.nextToken().charAt(0);
        		if (c == '1') {
        			graph[i].add(j);
        		}        		
    		}
		}
    	path = new int[m];
    	st = new StringTokenizer(br.readLine());
    	int cnt = 0;
    	while(st.hasMoreTokens()) {
    		path[cnt++] = Integer.parseInt(st.nextToken());
    	}
    }

    public static void pro() {

    	int start = path[0];
    	bfs(start);
    	boolean possible = true;
    	for (int point : path) {
    		if (!visit[point]) {
    			possible = false;
    			break;
    		}
    	}
    	System.out.println(possible ? "YES" : "NO");
    }

    public static void bfs(int start) {
    	
    	Deque<Integer> que = new ArrayDeque<>();
    	que.add(start);
    	visit[start] = true;
    	
    	while(!que.isEmpty()) {
    		
    		int cur = que.poll();
    		for (int next : graph[cur]) {
    			if (visit[next]) continue;
    			que.add(next);
    			visit[next] = true;
    			
    		}
    		
    		
    	}
    	
    	
    }

    public static void main(String[] args) throws IOException{
        input();
        pro();
    }

}
