import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static BufferedReader br;
	static StringBuffer sb = new StringBuffer();
	static StringTokenizer st;
	
	static int[] dp,inputArr;
	static int N;
	
	
	static void input() throws IOException {
		
		N = Integer.parseInt(br.readLine());
		dp = new int[N];
		inputArr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) inputArr[i] = Integer.parseInt(st.nextToken());
	}
	
	static void pro(int tc) throws Exception{
		
		int max = 1;
		for (int i = 0; i < N; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (inputArr[j] < inputArr[i]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			max = Math.max(max, dp[i]);
		}

		sb.append(String.format("#%d %d\n", tc, max));
	}
	
	public static void main(String[] args) throws Exception{
		
		br = new BufferedReader(new InputStreamReader(System.in));
		//br = new BufferedReader(new InputStreamReader(new FileInputStream("res/input.txt")));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			input();
			pro(tc);
		}
        System.out.println(sb);
		
	}

}
