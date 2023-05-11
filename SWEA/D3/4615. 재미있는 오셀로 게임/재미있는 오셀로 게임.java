import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static BufferedReader br;
	static StringBuffer sb = new StringBuffer();
	static StringTokenizer st;
	static int N, M;
	static int[][] board;
	
	static int[] dy = {0, 1, 0, -1, 1, -1, 1, -1};
	static int[] dx = {1, 0, -1, 0, 1, 1, -1, -1};
	
	static int[] colorCnt;
	
	static void input() throws IOException {
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[N + 1][N + 1];
	}
	
	static void init() {
		int x = N / 2; 
		board[x][x] = 2; // W
		board[x + 1][x + 1] = 2; // W
		board[x + 1][x] = 1; // B
		board[x][x + 1] = 1; // B
	}
	
	
	static boolean existColor(int y, int x, int dy, int dx, int color) {
		
		boolean res = false;
		int ny = y;
		int nx = x;
		
		while(true) {
			ny += dy;
			nx += dx;
			if (ny <= 0 || nx <= 0 || ny > N || nx > N) break;

			if (board[ny][nx] == (3 - color)) continue;
			
			if (board[ny][nx] == 0) break;
			if (board[ny][nx] == color) {
				res = true;
				break;
			}
		}
		return res;
	}
	
	static void change(int y, int x, int dy, int dx, int color) {
		
		int ny = y;
		int nx = x;
		while(true) {
			ny += dy;
			nx += dx;
			if (ny <= 0 || nx <= 0 || ny > N || nx > N) {
				break;
			}
			if (board[ny][nx] == (3 - color)) {
				board[ny][nx] = color;
			} else break;
		}
	}
	
	static void countColor() {
		
		colorCnt = new int[3];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				colorCnt[board[i][j]]++;
			}
		}
	}
	
	static void pro(int tc) throws Exception{
		
		init();
		while(M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int color = Integer.parseInt(st.nextToken());
			board[y][x] = color;
//			print();
			for (int i = 0; i < 8; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				if (ny <= 0 || nx <= 0 || ny > N || nx > N) continue;
				if (board[ny][nx] == color) continue;
				if (existColor(y, x, dy[i], dx[i], color)) {
					change(y, x, dy[i], dx[i], color);
				}
			}
//			print();
		}
		countColor();
		sb.append(String.format("#%d %d %d \n", tc, colorCnt[1], colorCnt[2]));
	}
	
	static void print() {
		sb.setLength(0);
		for (int i = 0; i <= N; i++) {
			for (int j = 0; j <= N; j++) {
				sb.append(board[i][j]);
			}
			sb.append('\n');
		}
		System.out.println(sb);
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
