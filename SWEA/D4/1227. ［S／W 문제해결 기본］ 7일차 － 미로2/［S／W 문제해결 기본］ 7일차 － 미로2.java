import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution {

	static BufferedReader br;
	static StringBuffer sb = new StringBuffer();
	static StringTokenizer st;
	

	static int N = 100;
	static boolean[][] board;
	static boolean[][] visit;
	static int[] startIdx;
	static int[] endIdx;
	
	static int[] dy = {0, 1, 0, -1};
	static int[] dx = {1, 0, -1, 0};
	
	static void input() throws IOException {
		
		board = new boolean[N][N];
		visit = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			char[] inputChar = br.readLine().toCharArray();
			for(int j = 0; j < N; j++) {
				if (inputChar[j] == '0') {
					board[i][j] = true;
					continue;
				}
				if(inputChar[j] == '1') {
					visit[i][j] = true;
					continue;
				}
				if(inputChar[j] == '2') { // start
					board[i][j] = true;
					startIdx = new int[] {i, j};
					continue;
				}
				if(inputChar[j] == '3') { // end
					endIdx = new int[] {i, j, 0};
					board[i][j] = true;
				}
				
			}
		}
	}
	
	static void pro(int tc) throws Exception{
		
		boolean res = false;
		Deque<int[]> que = new LinkedList<>();
		que.add(endIdx);
		visit[endIdx[0]][endIdx[1]] = true;
		
		while(!que.isEmpty()) { // bfs
			
			int[] curIdx = que.poll(); // int[3] = y, x, move
			if (curIdx[0] == startIdx[0] && curIdx[1] == startIdx[1]) {
				res = true;
				break;
			}
			
			for (int i = 0; i < 4; i++) {
				int ny = curIdx[0] + dy[i];
				int nx = curIdx[1] + dx[i];
				
				if (ny == -1 || nx == -1 || ny == N || nx == N) continue;
				if (visit[ny][nx]) continue;
				
				visit[ny][nx] = true;
				que.add(new int[] {ny, nx, curIdx[2] + 1});
				
			}
		}
		sb.append(String.format("#%d %d\n", tc, res? 1 : 0));
	}
	
	public static void main(String[] args) throws Exception{
		
		br = new BufferedReader(new InputStreamReader(System.in));
		//br = new BufferedReader(new InputStreamReader(new FileInputStream("res/input.txt")));
		
		int T = 10;
		for(int tc = 1; tc <= T; tc++) {
			int i = Integer.parseInt(br.readLine());
			input();
			pro(i);
		}
        System.out.println(sb);
		
	}

}
