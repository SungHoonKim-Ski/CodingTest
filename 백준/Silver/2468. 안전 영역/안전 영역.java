
import java.util.*;
import java.io.*;


public class Main
{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    static int n, maxHeight, maxCnt = 1;
    static int[][] inputArr;
    static boolean[][] visit;
    
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};
    
    public static class Pos{
    	int y, x;
    	public Pos(int y, int x) {
    		this.y = y;
    		this.x = x;
		}
    }
    
    
    public static void input() throws IOException {

    	n = Integer.parseInt(br.readLine());
    	inputArr = new int[n][n];
    	for (int i = 0; i < n; i++) {
    		st = new StringTokenizer(br.readLine());
    		for (int j = 0; j < n; j++) {
    			inputArr[i][j] = Integer.parseInt(st.nextToken());
    			maxHeight = Math.max(maxHeight, inputArr[i][j]);
    		}
		}
    }
    


    public static void pro() {
    	
    	for (int i = 1; i <= maxHeight; i++) {
    		maxCnt = Math.max(maxCnt, calArea(i));
    	}
    	System.out.println(maxCnt);
    }
    
    public static int calArea(int rainHeight) {

    	visit = new boolean[n][n];
    	

    	int vaildAreaCnt = 0;
    	for (int i = 0; i < n; i++) {
    		for (int j = 0; j < n; j++) {
    			if (visit[i][j]) continue;
    			if (inputArr[i][j] - rainHeight > 0) {
    				vaildAreaCnt++;
    				dfs(new Pos(i, j), rainHeight);
    			}
    		}
    	}
    	return vaildAreaCnt;
    }
    
    public static void dfs(Pos pos, int rainHeight) {
    	
    	visit[pos.y][pos.x] = true;
    	Queue<Pos> que = new LinkedList<>();

		que.add(pos);

		while (!que.isEmpty()) {
			Pos cur = que.poll();
    		for (int d = 0; d < 4; d++) {
    			int ny = cur.y + dy[d];
    			int nx = cur.x + dx[d];
    			if (!vaild(ny, nx)) continue;
    			if (visit[ny][nx]) continue;
    			if (inputArr[ny][nx] - rainHeight <= 0) continue;
    			visit[ny][nx] = true;
    			que.add(new Pos(ny, nx));
    		}
			
		}
    }
    
    public static boolean vaild(int y, int x) {
    	if (y == n || y == -1 || x == n || x == -1) return false;
    	return true;
    }
    
    public static void main(String args[]) throws IOException
    {
        input();
        pro();
        
    }
}