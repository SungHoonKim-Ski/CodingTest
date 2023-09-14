import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuffer sb = new StringBuffer();
	static StringTokenizer st;
	
	static int n, m, res;
	static int[] aArr;
	
	static void input() throws IOException{
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		aArr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) aArr[i] = Integer.parseInt(st.nextToken());
	}
	
	static void pro() {
		
		int start, end;
		start = end = 0;
		int size = 0;
		
		while (end != n) {
			
			size += aArr[end];
			if (size > m) {
				while (size > m) {
					size -= aArr[start];
					start++;
				}
			}
			res = Math.max(res,  size);
			end++;
		}
		System.out.println(res);
		
	}
	
	
	public static void main(String[] args) throws IOException{
		input();
		pro();
		
	}

}
