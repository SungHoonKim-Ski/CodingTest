import java.util.*;
import java.io.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuffer sb = new StringBuffer();
	static StringTokenizer st;
	
	static int n;
	static int[] oddNum; // 홀
	static int[] evenNum; // 짝
//	static final int[] dy = {-1, -1, -1};
//	static final int[] dx = {-1, 0, 1};
	static int printCase;
	
	public static void input() throws IOException{
		
		n = Integer.parseInt(br.readLine());
		evenNum = new int[n / 2];
		if (n % 2 == 0) oddNum = new int[n / 2];
		else oddNum = new int[n / 2 + 1];
		
		printCase = n % 6;
	}
	
	public static void addOdd() {
		
		switch (printCase) {
		
		case 2:
			oddNum[0] = 3;
			oddNum[1] = 1;
			oddNum[oddNum.length - 1] = 5;
			for (int i = 2, j = 7; i < oddNum.length - 1; i++, j += 2) {
				oddNum[i] = j;
			}
			break;
		case 3:
			oddNum[oddNum.length - 2] = 1;
			oddNum[oddNum.length - 1] = 3;
			for (int i = 0, j = 5; i < oddNum.length - 2; i++, j += 2) {
				oddNum[i] = j;
			}
			break;
		default:
			for (int i = 1; i <= oddNum.length; i++) {
				oddNum[i - 1] = i * 2 - 1;
			}
			break;
		}
		
	}
	
	public static void addEven() {
		
		switch (printCase) {
		
		case 3:
			evenNum[evenNum.length - 1] = 2;
			for (int i = 0, j = 4; i < evenNum.length - 1; i++, j += 2) {
				evenNum[i] = j;
			}
			break;
		default:
			for (int i = 1; i <= evenNum.length; i++) {
				evenNum[i - 1] = i * 2;
			}
			break;
		}
		
	}
	
	public static void printQueen() {
		
		for (int i = 0; i < evenNum.length; i++) {
			sb.append(evenNum[i]).append('\n');
		}
		for (int i = 0; i < oddNum.length; i++) {
			sb.append(oddNum[i]).append('\n');
		}
	}
	
	public static void pro() {
		addEven();
		addOdd();
		printQueen();
		System.out.println(sb);
	}

	
	public static void main(String[] args) throws IOException{

		input();
		pro();
	}

}
