import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {

	static BufferedReader br;
	static StringBuffer sb = new StringBuffer();
	static StringTokenizer st;
	
	static HashSet<Integer> queCardsSet;
	static boolean[] inVisit;
	static int[] queCards = new int[9];
	static int[] inCards = new int[9];
	static int cal = 0;
	static int Win, Draw;
	static int wholeGameCnt = 362880; // 9!
	static int winScore = 85; // 86점부터 전체 점수의 반 이상
	
	static void input() throws IOException {
		st = new StringTokenizer(br.readLine());
		queCardsSet = new HashSet<>();
		for (int i = 0; i < 9; i++) {
			queCards[i] = Integer.parseInt(st.nextToken());
			queCardsSet.add(queCards[i]);
		}
	}
	
	static void pro(int tc) throws Exception{
		
		int cnt = 0;
		
		inVisit = new boolean[9];
		
		for (int i = 1; i < 19; i++) {
			if (queCardsSet.contains(i)) continue;
			inCards[cnt++] = i;
		}
		
		Win = 0;
		dfs(0, 0, 0);
		sb.append(String.format("#%d %d %d\n", tc, Win, wholeGameCnt - Draw - Win));
	}
	
	static void dfs(int depth, int queScore, int inScore) {

		if (depth == 9) {
			if (queScore > inScore) Win++;
			return;
		}
		
		if (inScore > winScore) return;
		if (queScore > winScore) {
			
			int round = 1;
			int factorial = 9 - depth;
			while (factorial > 1) { // (9 - depth)!
				round *= factorial;
				factorial--;
			}
			Win += round;
			return;
		}
		
		for (int i = 0; i < 9; i++) {
			if (inVisit[i]) continue;
			
			int curSum = queCards[depth] + inCards[i];
			int curQueScore = queScore;
			int curInScore = inScore;
			if (queCards[depth] > inCards[i]) curQueScore += curSum;
			else curInScore += curSum;
			
			inVisit[i] = true;
			dfs (depth + 1, curQueScore, curInScore);
			inVisit[i] = false;
			
		}
		
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
