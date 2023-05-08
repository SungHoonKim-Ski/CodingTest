import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution
{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//	static BufferedReader br;
	static StringTokenizer st;
	static StringBuffer sb = new StringBuffer();
	static char[] inputNum;
	static int swapCnt, numLength, res;
	
	static void input() throws IOException
	{
		st = new StringTokenizer(br.readLine());
		inputNum = st.nextToken().toCharArray();;
		numLength = inputNum.length;
		swapCnt = Integer.parseInt(st.nextToken());
	}
	
	static void pro(int tc) {
		
		res = 0;
		swapCnt = swapCnt > numLength ? numLength : swapCnt;
		dfs(0, 0);
		sb.append(String.format("#%d %d", tc, res));
		System.out.println(sb);
		sb.setLength(0);
	}
	
	static void dfs(int idx, int depth) {
		
		if (depth == swapCnt) {
			res = Math.max(res, Integer.parseInt(String.valueOf(inputNum)));
			return;
		}
		
		for (int i = idx; i < numLength - 1; i++) {
			for (int j = i + 1; j < numLength; j++) {
				swap(i, j);
				dfs(i, depth + 1);
				swap(j, i);
			}
		}
		
		
	}
	
	static void swap(int idx1, int idx2) {
		char tmp = inputNum[idx1];
		inputNum[idx1] = inputNum[idx2];
		inputNum[idx2] = tmp;
	}
	
	public static void main(String args[]) throws Exception
	{
		
		//br = new BufferedReader(new FileReader(new File("res/input.txt")));
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++)
		{
			input();
			pro(test_case);
		}
		System.out.println(sb);

	}
}