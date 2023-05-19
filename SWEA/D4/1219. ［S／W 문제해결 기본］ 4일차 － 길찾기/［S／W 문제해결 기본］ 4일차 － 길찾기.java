import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution {

	static BufferedReader br;
	static StringBuffer sb = new StringBuffer();
	static StringTokenizer st;
	
	static int Start = 0, End = 99;
	
	static ArrayList<Integer>[] graph;
	static boolean[] visit;
	
	static void input() throws IOException {
		
		graph = new ArrayList[100];
		visit = new boolean[100];
		
		for (int i = 0; i < 100; i++) graph[i] = new ArrayList<>();
		
		st = new StringTokenizer(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		while (st.hasMoreTokens()) {
			graph[Integer.parseInt(st.nextToken())].add(Integer.parseInt(st.nextToken()));
		}
	}
	
	static void pro(int tc) throws Exception{
		
		boolean res = false;
		
		Deque<Integer> que = new LinkedList<>();
		que.add(Start);
		visit[Start] = true;
		
		while(!que.isEmpty()) {
			
			int cur = que.poll();
			if (cur == End) {
				res = true;
				break;
			}
			for (int i: graph[cur]) {
				if (visit[i]) continue;
				visit[i] = true; 
				que.add(i);
			}
		}
		
		
		
		sb.append(String.format("#%d %d\n", tc, res ? 1 : 0));
	}
	
	public static void main(String[] args) throws Exception{
		
		br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new InputStreamReader(new FileInputStream("res/input.txt")));
//		int T = Integer.parseInt(br.readLine());
		int T = 10;
		for(int tc = 1; tc <= T; tc++) {
			input();
			pro(tc);
		}
        System.out.println(sb);
		
	}

}
