import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution
{

//	static Scanner scanner;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuffer sb = new StringBuffer();
	static int[] heights;
	static int buildingCnt;
	
	static void input() throws IOException
	{
		buildingCnt = Integer.parseInt(br.readLine()); 
		heights = new int[buildingCnt];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < buildingCnt; i++) {
			int height = Integer.parseInt(st.nextToken());
			heights[i] = height;  
		}
	}
	
	static void pro(int tc) {

		int[] leftMaxHeightBuildings = new int[buildingCnt];
		int[] rightMaxHeightBuildings = new int[buildingCnt];
		
		for (int i = 2; i < buildingCnt - 2; i++) {
			leftMaxHeightBuildings[i] = Math.max(heights[i - 1], heights[i - 2]);
			rightMaxHeightBuildings[i] = Math.max(heights[i + 1], heights[i + 2]); 
		}
		
		int res = 0;
		for (int i = 2; i < buildingCnt - 2; i++) {
			int compare = Math.max(leftMaxHeightBuildings[i], rightMaxHeightBuildings[i]);
			if (heights[i] > compare) {
				res += heights[i] - compare; 
			}
			
		}
		
		sb.append('#').append(tc).append(' ').append(res).append('\n');
	}
	
	
	
	public static void main(String args[]) throws Exception
	{
		
//		System.setIn(new FileInputStream("res/input.txt"));
//		scanner = new Scanner(System.in);
		int T = 10;
		for(int test_case = 1; test_case <= T; test_case++)
		{
			input();
			pro(test_case);
		}
		System.out.println(sb);

	}
}