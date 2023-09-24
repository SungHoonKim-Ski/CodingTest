import java.util.*;
import java.io.*;

public class Solution {

	static BufferedReader br;
	static StringBuffer sb = new StringBuffer();
	static StringTokenizer st;
	
	static int n, b, minDiff;
	
	static int[] nArr;
	
	static boolean[] visit;
	
	
	public static void input() throws Exception{
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		nArr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) nArr[i] = Integer.parseInt(st.nextToken());
		visit = new boolean[n];
		minDiff = Integer.MAX_VALUE;
	}
	
	public static void pro(int tc) {
		backtrack(0, 0, 0);
		sb.append(String.format("#%d %d\n", tc, minDiff - b));
	}
	
	public static void backtrack(int depth, int idx, int sum) {
		
		
		if (sum > minDiff) return;
		if (sum >= b) {
			minDiff = Math.min(minDiff, sum);
			return;
		}
		if (depth == n) return;
		
		for (int i = idx; i < n; i++) {
			backtrack(depth + 1, i + 1, sum + nArr[i]);
		}
		
	}
	
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("res/input.txt"));
		br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			input();
			pro(tc);
		}
		System.out.println(sb);
	}

}
