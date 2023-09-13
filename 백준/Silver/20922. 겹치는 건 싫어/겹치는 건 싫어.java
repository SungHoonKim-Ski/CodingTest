import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuffer sb = new StringBuffer();
	static StringTokenizer st;
	
	static int n, k;
	static int[] arr;
	static int[] countArr;
	
	static void input() throws IOException{
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
		countArr = new int[100_001];
		// 20_001
	}
	
	static void pro() {
		
		int start, end;
		start = end = 0;
		int maxLen = 1;
		countArr[arr[end]]++;
		
		while (++end != n) {
			while (countArr[arr[end]] + 1 == k + 1) {
				countArr[arr[start]]--;
				start++;
			}
			countArr[arr[end]]++;
			maxLen = Math.max(maxLen, end - start + 1);
			
		}
		System.out.println(maxLen);
		
	}
	
	
	public static void main(String[] args) throws IOException{
		input();
		pro();
		
	}

}
