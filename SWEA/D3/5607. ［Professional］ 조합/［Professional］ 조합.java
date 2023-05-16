import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution {

	static BufferedReader br;
	static StringBuffer sb = new StringBuffer();
	static StringTokenizer st;
	

	static long N, R;
	static long mod = 1234567891;
	
	static void input() throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Long.parseLong(st.nextToken());
		R = Long.parseLong(st.nextToken());
		
	}
	
	public static long factorial(long N) {
		
		long fac = 1L;
		while(N > 1) {
			fac = (fac * N) % mod;
			N--;
		}
		return fac;
	}
	
	static void pro(int tc) throws Exception{
		
		
		long numer = factorial(N);
		long denom = factorial(R) * factorial(N - R) % mod;	
		sb.append(String.format("#%d %d\n", tc, numer * pow(denom, mod - 2) % mod));
	}
	
	public static long pow(long base, long expo) {
	    long result = 1;    
	    
	    while (expo > 0) {
	    	
	        if (expo % 2 == 1) {
	            result *= base;
	            result %= mod;
	        }
	        base = (base * base) % mod;
	        expo /= 2;
	    }
	    return result;
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
