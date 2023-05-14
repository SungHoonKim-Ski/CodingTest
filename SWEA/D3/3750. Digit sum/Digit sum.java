import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static BufferedReader br;
	static StringBuffer sb = new StringBuffer();
	static StringTokenizer st;
	
	static char[] N;
	static int intN;
	
	
	static void input() throws IOException {
		N = br.readLine().toCharArray();
		intN = 0;
	}
	
	static void pro(int tc) throws Exception{
		
		if (N.length == 1) {
			intN = N[0] - '0';
		} else {
			for (int i = 0; i < N.length; i++) intN += N[i] - '0';
			
			while (intN > 9) {
				
				int n = intN;
				int res = 0;
				while (n != 0) {
					res += n % 10;
					n /= 10;
				}
				intN = res;
			}
	
		}
		sb.append(String.format("#%d %d\n", tc, intN));
	}
	
	public static void main(String[] args) throws Exception{
		
		br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new InputStreamReader(new FileInputStream("res/input.txt")));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			input();
			pro(tc);
		}
        System.out.println(sb);
		
	}

}
