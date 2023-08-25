import java.util.*;
import java.io.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuffer sb = new StringBuffer();
	static StringTokenizer st;
	
	static boolean[] isNotPrime = new boolean[3001];
	static int[] cows;
	static int n, m;
	
	static HashSet<Integer> primeCowMap;
	// 무게의 합이 소수인 소를 저장
	
	public static void input() throws IOException{
		
		for (int i = 2; i < isNotPrime.length; i++) {
			if (isNotPrime[i]) continue;
			for (int j = i * 2; j < isNotPrime.length; j += i) {
				isNotPrime[j] = true;
			}
		}
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		cows = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			cows[i] = Integer.parseInt(st.nextToken());
		}
		
		primeCowMap = new HashSet<>();
	}
	
	public static void pro() {
		
		selectCow(0, 0, 0);
		ArrayList<Integer> cowList = new ArrayList<>(primeCowMap);
		// 정렬을 위한 선언
		if (cowList.size() == 0) sb.append("-1");
		else {
			Collections.sort(cowList);
			for (int cow : cowList) {
				sb.append(cow).append('\n');
			}	
		}
		System.out.println(sb);
	}

	public static void selectCow(int depth, int idx, int sumWeight) {
		
		if (depth == m) {
			if (!isNotPrime[sumWeight]) primeCowMap.add(sumWeight);
			return;
		}
		
		for (int i = idx; i < n; i++) {
			selectCow(depth + 1, i + 1, sumWeight + cows[i]);
		}
		
	}
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		input();
		pro();
	}

}
