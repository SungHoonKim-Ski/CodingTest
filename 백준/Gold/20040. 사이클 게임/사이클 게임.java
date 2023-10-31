import java.io.*;
import java.util.*;

public class Main {

	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static int n, m;
	
	static int[] parent;
	
	static void input() throws IOException {
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		parent = new int[n];
	}
	
	static void pro() throws IOException{
		
		for (int i = 0; i < n; i++) parent[i] = i;
		
		
		int count = 0;
		
		boolean isCycle = false;
		while (m-- > 0) {
			count++;
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			if (!union(s, e)) {
				isCycle = true;
				break;
			}
		}
		
		if (isCycle) System.out.println(count);
		else System.out.println(0);
	

	}
	
	static int find(int a) {
		if (a == parent[a]) return a;
		return parent[a] = find(parent[a]);
	}
	
	static boolean union(int a, int b) {
		
		int aParent = find(a);
		int bParent = find(b);
		
		if (aParent == bParent) return false;
		parent[aParent] = bParent;
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
}
