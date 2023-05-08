import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution
{
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuffer sb = new StringBuffer();
	static int[] inputNum;
	static int N, Max;
	
	static void input() throws IOException
	{
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		inputNum = new int[N];
		for (int i = 0; i < N; i++) {
			inputNum[i] = -Integer.parseInt(st.nextToken());
		}
	}
	
	static void pro(int tc) {
		
		Max = -1;
		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
				int num = inputNum[i] * inputNum[j];
				if (check(num)) {
					Max = Math.max(Max, num);
				}
			}
		}
		sb.append(String.format("#%d %d\n", tc, Max));
	}
	
	static boolean check(int num) {
		
		int prevNum = 9;
		int curNum;
		
		while (num != 0) {
			curNum = num % 10;
			if (curNum > prevNum) {
				return false;
			}
			num /= 10;
			prevNum = curNum;
		}
		return true;
	}
	
	
	public static void main(String args[]) throws Exception
	{
		
		//br = new BufferedReader(new FileReader(new File("res/input.txt")));
		br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++)
		{
			input();
			pro(test_case);
		}
		System.out.println(sb);
	}
}