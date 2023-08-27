import java.util.*;
import java.io.*;

public class Main {
	
	static StringTokenizer st;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuffer sb = new StringBuffer();
	
	static int n, m, d, maxKillCnt = 0, enemyCnt = 0, cloneEnemyCnt = 0;;
	
	static boolean[][] isKilled;
	static boolean[] visit;
	static int[][] startBoard, cloneBoard;
	
	static Pos[] archers;
	
	static final int[] dy = {0, 1, -1, 0};
	static final int[] dx = {-1, 0, 0, 1};
	
	static void input() throws IOException{
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		
		startBoard = new int[n][m];
		cloneBoard = new int[n][m];
		visit = new boolean[m];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				startBoard[i][j] = Integer.parseInt(st.nextToken());
				if (startBoard[i][j] == 1) enemyCnt++;
			}
		}
		
		archers = new Pos[3];
	}
	
	static void pro() {
		dfs(0);
		System.out.println(maxKillCnt);
	}
	
	static void dfs(int depth) {
		
		if (depth == 3) {
			cloneBoard();
			simulation();
			return;
		}
		
		for (int j = 0; j < m; j++) {
			if (visit[j]) continue;
			archers[depth] = new Pos(n, j);
			visit[j] = true;
			dfs(depth + 1);
			visit[j] = false;
		}
	}
	
	static void cloneBoard() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				cloneBoard[i][j] = startBoard[i][j];
			}
		}
	}
	
	static void simulation() {
		
		int curKillCnt = 0;
		cloneEnemyCnt = enemyCnt;
		
		for (int i = 0; i < n; i++) {
			int killCnt = attack();
			cloneEnemyCnt -= killCnt;
			curKillCnt += killCnt;
			cloneEnemyCnt -= move();
			if (cloneEnemyCnt == 0) break;
		}
		maxKillCnt = Math.max(maxKillCnt, curKillCnt);
	}
	
	static int attack() {
		
		isKilled = new boolean[n][m];
		ArrayList<Pos> killLoc = new ArrayList<>();
		int killCnt = 0;
		for (int i = 0; i < archers.length; i++) {
			Pos curArcher = archers[i];
			for (int j = 1; j <= d; j++) {
				Pos killedPos = searchArround(curArcher, d);
				if (killedPos == null) continue;
				if (!isKilled[killedPos.y][killedPos.x]) {
					killLoc.add(killedPos);
					isKilled[killedPos.y][killedPos.x] = true;
					killCnt++;
				}
				break;
			}
		}
		
		for (Pos killed : killLoc) {
			cloneBoard[killed.y][killed.x] = 0;
		}
		
		return killCnt;
		
	}
	
	static Pos searchArround(Pos curPos, int depth) {
		
		ArrayList<Pos> enemyList = new ArrayList<>();
		
		Queue<Pos> que = new ArrayDeque<>();
		boolean[][] isChecked = new boolean[n][m];
		
		que.add(new Pos(curPos.y, curPos.x, 0));
		
		while (!que.isEmpty()) {
			
			Pos cur = que.poll();
				
			for (int i = 0; i < 4; i++) {
				int ny = cur.y + dy[i];
				int nx = cur.x + dx[i];
				if (isNotPossible(ny, nx)) continue;
				if (isChecked[ny][nx]) continue;
				Pos nPos = new Pos(ny, nx, cur.dist + 1);	
				isChecked[ny][nx] = true;
				if (cloneBoard[ny][nx] == 1) {
					enemyList.add(nPos);
				}
				if (nPos.dist == depth) continue;
				que.add(nPos);
			}
			if (enemyList.size() != 0) break;
		}
		
		if (enemyList.size() != 0) {
			Collections.sort(enemyList);
			return enemyList.get(0);
		} else return null;
	}
	
	static int move() {
		
		int exitEnemyCnt = 0;
		for (int x = 0; x < m; x++) {
			if (cloneBoard[n - 1][x] == 1) exitEnemyCnt++;
			cloneBoard[n - 1][x] = 0;
		}
		
		for (int i = n - 2; i >= 0; i--) {
			for (int j = 0; j < m; j++) {
				cloneBoard[i + 1][j] = cloneBoard[i][j]; 
			}
		}
		
		for (int x = 0; x < m; x++) {
			cloneBoard[0][x] = 0;
		}
		
		return exitEnemyCnt;
	}
	
	static boolean isNotPossible(int y, int x) {
		if (y >= n || x >= m || y < 0 || x < 0) return true;
		return false;
	}
	
	static class Pos implements Comparable<Pos>{
		
		int y, x, dist;
		
		Pos(int y, int x) {
			this.y = y;
			this.x = x;
		}
		
		Pos(int y, int x, int dist) {
			this.y = y;
			this.x = x;
			this.dist = dist;
		}
		
		@Override
		public int compareTo(Pos o) {
			if (this.dist != o.dist) return o.dist - this.dist; 
			if (this.x != o.x) return this.x - o.x;
			else return 0;
		}
	}

	public static void main(String[] args) throws IOException{
		input();
		pro();
	}

}
