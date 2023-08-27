
import java.util.*;
import java.io.*;

public class Main {
	
	static StringTokenizer st;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuffer sb = new StringBuffer();
	
	static int N;
	
	static int[] T, P, dp;
	
	static void input() throws IOException{
		
		N = Integer.parseInt(br.readLine());
		T = new int[N + 1];
		P = new int[N + 1];
		dp = new int[N + 1];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}
		
	}
	
	static void pro() {
		
		for (int i = 0; i < N; i++) {
			dp[i + 1] = Math.max(dp[i], dp[i + 1]);
//			System.out.println(dp[i]);
			if (T[i] + i > N) continue;
			dp[T[i] + i] = Math.max(dp[T[i] + i], dp[i] + P[i]);
		}
//		System.out.println();
		System.out.println(dp[N]);
	}
	

	public static void main(String[] args) throws IOException{
		input();
		pro();
	}

}
