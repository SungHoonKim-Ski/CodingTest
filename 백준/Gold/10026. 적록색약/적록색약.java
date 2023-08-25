import java.util.*;
import java.io.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuffer sb = new StringBuffer();
	static StringTokenizer st;
	
	static int n, cnt, cntRG;
	
	static char[][] inputCharArr;
	static char[][] inputCharArrRG;
	
	static boolean[][] visit;
	static boolean[][] visitRG;
	
	static final int[] dy = {0, -1, 0, 1};
	static final int[] dx = {1, 0, -1, 0};
	
	static Queue<Pos> queue;
	
	// 무게의 합이 소수인 소를 저장
	
	public static void input() throws IOException{
		
		n = Integer.parseInt(br.readLine());
		visit = new boolean[n][n];
		visitRG = new boolean[n][n];
		
		inputCharArr = new char[n][n];
		inputCharArrRG = new char[n][n];
		
		for (int i = 0; i < n; i++) {
			inputCharArr[i] = br.readLine().toCharArray();
			for (int j = 0; j < n; j++) {
				inputCharArrRG[i][j] = inputCharArr[i][j];
				if (inputCharArrRG[i][j] == 'R') inputCharArrRG[i][j] = 'G';
			}
		}
		
		queue = new ArrayDeque<>();
	}
	
	public static void pro() {
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				
				if (!visit[i][j]) {
					Pos pos = new Pos(i, j, inputCharArr[i][j]);
					bfs(pos, inputCharArr, visit);
					cnt++;
				}
				if (!visitRG[i][j]) {
					Pos pos = new Pos(i, j, inputCharArrRG[i][j]);
					bfs(pos, inputCharArrRG, visitRG);
					cntRG++;
				}
			}
		}
		sb.append(cnt).append(' ').append(cntRG);
		System.out.println(sb);
	}

	public static void bfs(Pos pos, char[][] board, boolean[][] curVisit) {
		
		
		queue.add(pos);
		curVisit[pos.y][pos.x] = true;
		
		while (!queue.isEmpty()) {

			Pos cur = queue.poll();
			
			for (int i = 0; i < 4; i++) {
				int ny = cur.y + dy[i];
				int nx = cur.x + dx[i];
				
				if (notVaild(ny, nx)) continue;
				if (curVisit[ny][nx]) continue;
				if (board[ny][nx] != cur.color) continue;
				curVisit[ny][nx] = true;
				queue.add(new Pos(ny, nx, board[ny][nx]));
			}
		}
	}
	
	public static boolean notVaild(int y, int x) {
		
		return (y == -1 || x == -1 || y == n || x == n);
	}
	
	public static class Pos{
		
		int y, x;
		char color;
		public Pos(int y, int x, char color) {
			this.y = y;
			this.x = x;
			this.color = color;
		}
	}
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		input();
		pro();
	}

}
