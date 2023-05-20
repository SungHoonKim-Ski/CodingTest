import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution {

	static BufferedReader br;
	static StringBuffer sb = new StringBuffer();
	static StringTokenizer st;
	
	static int N, Cnt;
	static int[] queenLoc;
	
	static void input() throws IOException {
		Cnt = 0;
		N = Integer.parseInt(br.readLine());
		queenLoc = new int[N + 1];
	}
	
	static void pro(int tc) throws Exception{
		
		dfs(1);
		sb.append(String.format("#%d %d\n", tc, Cnt));
	}
	
	static void dfs (int depth) {
		
		if (depth == N + 1) {
			Cnt++;
			return;
		}
		
		for (int i = 1; i <= N; i++) {
            boolean possible = true;
            for (int j = 1; j < depth; j++){
                if (attackable(depth, i, j, queenLoc[j])){
                    possible = false;
                    break;
                }
            }
            if (possible) {
                queenLoc[depth] = i;
                dfs(depth + 1);
                queenLoc[depth] = 0;
            }
        }
		
	}
	
	static boolean attackable(int x1, int y1, int x2, int y2) {
        if (y1 == y2) return true;
        if (x1 + y1 == x2 + y2) return true;
        if (x1 - y1 == x2 - y2) return true;
        return false;
    }
	
	public static void main(String[] args) throws Exception{
		
		br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new InputStreamReader(new FileInputStream("res/input.txt")));
		int T = Integer.parseInt(br.readLine());
//		int T = 10;
		for(int tc = 1; tc <= T; tc++) {
			input();
			pro(tc);
		}
        System.out.println(sb);
		
	}

}
