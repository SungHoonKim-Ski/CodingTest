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
	
	public static int findMin(int biggerThan, int startIdx) {
		
		if (startIdx == charN.length - 1) return Integer.parseInt(String.valueOf(charN));
		int min = 9, minIdx = -1;
		
		for (int i = charN.length - 1; i >= startIdx ; i--) {
			int val = charN[i] - '0';
			if (val < biggerThan) continue;
			if (min > val) {
				min = val;
				minIdx = i;
			}
		}
		if (minIdx == -1) return Integer.parseInt(String.valueOf(charN));
		if (minIdx == startIdx) return findMin(min, startIdx + 1);
		
		int swapIdx = -1;
		for (int i = startIdx; i < charN.length; i++) {
			int val = charN[i] - '0';
			if (val == min) continue;
			else {
				swapIdx = i;
				break;
			}
		}
		if (swapIdx == -1) return Integer.parseInt(String.valueOf(charN));
		return swap(minIdx, swapIdx);
	}
	
	public static int findMax(int smallerThan, int startIdx) {
		
		if (startIdx == charN.length - 1) return Integer.parseInt(String.valueOf(charN));
		int max = -1, maxIdx = -1;
		
		for (int i = charN.length - 1; i >= startIdx ; i--) {
			int val = charN[i] - '0';
			if (val >= smallerThan) continue;
			if (max < val) {
				max = val;
				maxIdx = i;
			}
		}
		if (maxIdx == -1) return Integer.parseInt(String.valueOf(charN));
		if (maxIdx == startIdx) return findMax(max, startIdx + 1);
		
		int swapIdx = -1;
		for (int i = startIdx; i < charN.length; i++) {
			int val = charN[i] - '0';
			if (val == max) continue;
			else {
				swapIdx = i;
				break;
			}
		}
		if (swapIdx == -1) return Integer.parseInt(String.valueOf(charN));
		
		return swap(maxIdx, swapIdx);
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
