import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
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
	static int[] inputNum = new int[8];
	static Deque<Integer> queue;
	
	static void input() throws IOException
	{
		queue = new LinkedList<Integer>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < inputNum.length; i++) {
			inputNum[i] = Integer.parseInt(st.nextToken());
		}
	}
	
	static void pro(int tc) {
		
		
		for (int i = 0; i < inputNum.length; i++) {
			queue.add(inputNum[i]);
		}
		
		int num = 1;
		while (true) {
			
			int element = queue.poll();
			element -= num;
			if (element <= 0) {
				queue.add(0);
				break;
			}
			queue.add(element);
			num++;
			if (num > 5) num = 1;
		}
		
		sb.append(String.format("#%d ", tc));
		
		while (!queue.isEmpty()) {
			sb.append(queue.poll()).append(' ');
		}
		sb.append('\n');
	}
	
	
	public static void main(String args[]) throws Exception
	{
		
		//br = new BufferedReader(new FileReader(new File("res/input.txt")));
		br = new BufferedReader(new InputStreamReader(System.in));
		String s;
		while (true) {
			s = br.readLine();
			if (s == null || s.isEmpty()) break;
			input();
			pro(Integer.parseInt(s));
		}
//		for(int test_case = 1; test_case <= T; test_case++)
//		{
//			input();
//			pro(test_case);
//		}
		System.out.println(sb);
	}
}