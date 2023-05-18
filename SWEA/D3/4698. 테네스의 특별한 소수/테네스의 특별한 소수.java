import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static BufferedReader br;
	static StringBuffer sb = new StringBuffer();
	static StringTokenizer st;
	
	static int D, A, B;
	static int Max = 1000000;
	static boolean[] isNotDecimal;

	
	static void init() {

		isNotDecimal = new boolean[Max + 1];
		isNotDecimal[0] = true;
		isNotDecimal[1] = true;
		for (int i = 2; i <= Max; i++) {
			if (isNotDecimal[i]) continue;
			for (int j = i + i; j <= Max; j += i) {
				isNotDecimal[j] = true;
			}
		}
	}
	static void input() throws IOException {
		st = new StringTokenizer(br.readLine());
		D = Integer.parseInt(st.nextToken());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
	}
	
	static void pro(int tc) throws Exception{
		
		int res = 0;
		for (int i = A; i <= B; i++) {
			if (isNotDecimal[i]) continue;
			int n = i;
			int mod;
			while(n != 0) {
				mod = n % 10;
				n /= 10;
				if (mod == D) {
					res++;
					break;
				}
			}
			
		}
		
		sb.append(String.format("#%d %d\n", tc, res));
	}
	
	public static void main(String[] args) throws Exception{
		
		br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new InputStreamReader(new FileInputStream("res/input.txt")));
		int T = Integer.parseInt(br.readLine());
		init();
		for(int tc = 1; tc <= T; tc++) {
			input();
			pro(tc);
		}
        System.out.println(sb);
		
	}

}
