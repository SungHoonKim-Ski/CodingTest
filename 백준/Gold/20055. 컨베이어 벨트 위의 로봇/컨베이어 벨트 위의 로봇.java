import java.io.*;
import java.util.*;

public class Main {

	static StringTokenizer st;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static int[] belt;
	static boolean[] isRobot;
	static int n, k, step;
	
	static void input() throws IOException{
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		belt = new int[2 * n + 1];
		isRobot = new boolean[belt.length];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < belt.length; i++) {
			belt[i] = Integer.parseInt(st.nextToken());
		}
	}
	
	static void pro() {
		
		while (k > 0) {
			step++;
			rotate();
			move();
			add();
//			System.out.println(Arrays.toString(belt));
//			System.out.println(Arrays.toString(isRobot));
		}
		System.out.println(step);
	}
	
	static void rotate() {
		
		boolean[] tmpIsRobot = new boolean[isRobot.length];
		int[] tmpBelt = new int[belt.length];
		
		tmpBelt[1] = belt[2 * n];
		tmpIsRobot[1] = isRobot[2 * n];
		
		for (int i = 2; i < isRobot.length; i++) {
			tmpIsRobot[i] = isRobot[i - 1];
			tmpBelt[i] = belt[i - 1];
		}
		
		belt = tmpBelt;
		isRobot = tmpIsRobot;
		isRobot[n] = false;
	}
	
	static void move() {
		
		if (belt[n] > 0 && isRobot[n - 1]) {
			belt[n]--;
			isRobot[n - 1] = false;
			if (belt[n] == 0) k--;
		}
		
		for (int i = n - 2; i != 0; i--) {
			if (belt[i + 1] == 0) continue;
			if (!isRobot[i]) continue;
			if (isRobot[i + 1]) continue;
			
			belt[i + 1]--;
			
			if (belt[i + 1] == 0) k--;
			
			isRobot[i + 1] = true;
			isRobot[i] = false;
		}
	}
	
	static void add() {
		if (belt[1] != 0) {
			belt[1]--;
			if (belt[1] == 0) k--;
			isRobot[1] = true;
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		input();
		pro();
	}

}
