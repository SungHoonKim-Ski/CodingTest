import java.util.*;
import java.io.*;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuffer sb = new StringBuffer();
	static StringTokenizer st;
	static int MAX_VALUE = 1001;
	static int[][] graph = new int[MAX_VALUE][MAX_VALUE];
	static int N, X, Y, Xp, Yp;
	
	static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		Y = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		Yp = Integer.parseInt(st.nextToken());
		Xp = Integer.parseInt(st.nextToken());
	}
	
	static void pro(int idx) {
		for (int y = 0; y < Yp; y++) {
			for (int x = 0; x < Xp; x++) {
				graph[y + Y][x + X] = idx;
			}
		}
	}
	
	static void calRes() {
		
		int[] cnt = new int[N + 1];
		
		for (int y = 0; y < MAX_VALUE; y++) {
			for (int x = 0; x < MAX_VALUE; x++) {
				cnt[graph[y][x]]++;
			}
		}
		
		for (int i = 1; i <= N; i++) {
			sb.append(cnt[i]).append('\n');
		}
	}
	
	
	public static void main(String[] args) throws Exception{
		N = Integer.parseInt(br.readLine());
		for (int i = 1; i <= N; i++) {
			input();
			pro(i);
		}
		calRes();
		System.out.println(sb);
	}

}
