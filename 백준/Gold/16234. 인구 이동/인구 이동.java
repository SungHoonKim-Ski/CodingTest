
import java.util.*;
import java.io.*;

public class Main {
	
	static StringTokenizer st;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuffer sb = new StringBuffer();
	
	static int N, L, R, time;
	
	static int[][] board;
	static boolean[][] visit;
	
	static boolean isMove;
	
	static Deque<Pos> que;
	static Deque<Pos> visitQue;
	
	static int[] dy = {0, 1, 0, -1};
	static int[] dx = {1, 0, -1, 0};
	
	static void input() throws IOException{
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		board = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		que = new LinkedList<>();
		visitQue = new LinkedList<>();
	}
	
	static void pro() {
		
		
		while (true) {
			isMove = false;
			visit = new boolean[N][N];
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visit[i][j]) {
						bfs(new Pos(i, j, board[i][j]));
					}
				}
			}
			if (isMove) time++;
			else break;
		}
		
		System.out.println(time);
	}
	
	static void bfs(Pos pos) {
		
		visit[pos.y][pos.x] = true; 
		que.add(pos);
		int sumPeople = 0;
		
		while(!que.isEmpty()) {
			
			Pos cur = que.poll();
			sumPeople += cur.people;
			for (int i = 0; i < 4; i++) {
				int ny = cur.y + dy[i];
				int nx = cur.x + dx[i];
				if (!isPossible(ny, nx)) continue;
				if (visit[ny][nx]) continue;
				int dif = Math.abs(cur.people - board[ny][nx]); 
				if (dif < L) continue;
				if (dif > R) continue;
				visit[ny][nx] = true;
				isMove = true;
				que.add(new Pos(ny, nx, board[ny][nx]));
			}
			visitQue.add(cur);
		}
		int avg = sumPeople / visitQue.size();
		
		while(!visitQue.isEmpty()) {
			Pos cur = visitQue.poll();
			board[cur.y][cur.x] = avg;
		}
	}
	
	static boolean isPossible(int y, int x) {
		if (y == -1 || x == -1 || y == N || x == N) return false;
		return true;
	}
	
	
	static class Pos{
		
		int y, x, people;
		public Pos(int y, int x, int people) {
			this.y = y;
			this.x = x;
			this.people = people;
		}
	}

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		input();
		pro();
	}

}
