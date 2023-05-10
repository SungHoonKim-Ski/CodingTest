import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution {

	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int[] BreadArr;
	static int N, M, K;
	
	public static void input() throws IOException {
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		BreadArr = new int[N];
		for (int i = 0; i < N; i++) {
			BreadArr[i] = Integer.parseInt(st.nextToken());
		}
	}
	
	public static void pro(int tc) {
		
		boolean res = true;
		
		Arrays.sort(BreadArr);
		int curTime = 0;
		int curBreadCnt = 0;
		
		for (int i = 0; i < N; i++) {
			
			if (curBreadCnt > 0) {
				curBreadCnt--;
				continue;
			}
			
			if (curTime < BreadArr[i]) {
				int time = (BreadArr[i] - curTime) / M;
				curTime += time * M;
				curBreadCnt += time * K;
			}
			
			if (curBreadCnt > 0) {
				curBreadCnt--;
				continue;
			} else {
				res = false;
				break;
			}
		}
		
		sb.append(String.format("#%d ", tc));
		if (res) sb.append("Possible");
		else sb.append("Impossible");
		sb.append('\n');
	}
	
	
	
	
	public static void main(String[] args) throws Exception {
		
		//br = new BufferedReader(new InputStreamReader(new FileInputStream("res/input.txt")));
		br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			input();
			pro(tc);
		}
		System.out.println(sb);
	}

}
