import java.util.*;
import java.io.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuffer sb = new StringBuffer();
	static StringTokenizer st;
	
	static int n, m, time;
	static boolean isMelt;
	static int[][] board;
	static int[][] cheeseCnt;
	static boolean[][] visit;
	
	static final int[] dy = {0, 1, 0, -1};
	static final int[] dx = {1, 0, -1, 0};
	
	static void input() throws IOException{
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		board = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
	
	
	
	static void pro() throws IOException{
		
		isMelt = true;
		while (isMelt) {
			isMelt = false;
			bfs();
			change();
			if (isMelt) time++;
		}
		
		System.out.println(time);
	}
	
	static void bfs() {
		
		cheeseCnt = new int[n][m];
		
		Deque<int[]> que = new ArrayDeque<>();
		visit = new boolean[n][m];
		visit[0][0] = true;
		que.add(new int[] {0, 0});
		
		while(!que.isEmpty()) {
			
			int[] cur = que.poll();
			for (int i = 0; i < 4; i++) {
				
				int ny = cur[0] + dy[i];
				int nx = cur[1] + dx[i];
				if (ny == -1 || nx == -1 || ny == n || nx == m) continue;
				
				if (visit[ny][nx]) {
					if (board[ny][nx] == 1) cheeseCnt[ny][nx]++;
					continue;
				} else {
					visit[ny][nx] = true;
					if (board[ny][nx] == 1) {
						cheeseCnt[ny][nx]++;
					} else {
						que.add(new int[] {ny, nx});
					} 
				}
				
			}
		}
		
	}
	
	static void change() {
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (board[i][j] == 0) continue;
				if (cheeseCnt[i][j] == 0) continue;
				if (cheeseCnt[i][j] > 1) {
					isMelt = true;
					board[i][j] = 0;	
				}
				cheeseCnt[i][j] = 0;
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		input();
		pro();
	}

}
