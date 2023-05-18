import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static BufferedReader br;
	static StringBuffer sb = new StringBuffer();
	static StringTokenizer st;
	
	static char[] charN;
	
	static void input() throws IOException {
		charN = br.readLine().toCharArray();
	}
	
	static void pro(int tc) throws Exception{
		
		int min = Integer.parseInt(String.valueOf(charN)), max = min;
		
		for (int i = 0; i < charN.length - 1; i++) {
			for (int j = i + 1; j < charN.length; j++) {
				max = Math.max(max, swap(i, j));
				if (i == 0 && charN[j] == '0') continue;
				min = Math.min(min, swap(i, j));
			}
		}
		
		
		sb.append(String.format("#%d %d %d\n", tc, min, max));
	}
	
	public static int swap(int idx1, int idx2) {
	    
		char[] clone = charN.clone();
		char tmp = clone[idx1];
		clone[idx1] = clone[idx2];
		clone[idx2] = tmp;
		
		return Integer.parseInt(String.valueOf(clone));
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
