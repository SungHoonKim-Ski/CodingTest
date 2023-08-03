import java.io.*;
import java.util.*;

public class Main {

	static class Location{
    	int y, x;
    	public Location(int y, int x) {
			this.y = y;
			this.x = x;
		}
    }
    
	
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static StringTokenizer st;

    static int N, K, L, MoveCnt;
    
    static int[][] board;
    
    static Location curLoc = new Location(0, 0);
    static Location curDir = new Location(0, 1);
    
    static Deque<int[]> SnakeDeque;
    
    static LinkedList<Integer> ChangeList;
  
    static void input() throws IOException
    {
    	N = Integer.parseInt(br.readLine());
    	K = Integer.parseInt(br.readLine());
    	
    	board = new int[N][N];
    	board[0][0] = -1;
    	SnakeDeque = new ArrayDeque<>();
    	SnakeDeque.add(new int[] {0,0});
    	while (K-- > 0) {
    		st = new StringTokenizer(br.readLine());
    		int appleY = Integer.parseInt(st.nextToken()) - 1;
    		int appleX = Integer.parseInt(st.nextToken()) - 1;
    		board[appleY][appleX] = 1;
    	}
    	
    	L = Integer.parseInt(br.readLine());
    	ChangeList = new LinkedList<>();
    	while (L-- > 0) {
    		st = new StringTokenizer(br.readLine());
    		int move = Integer.parseInt(st.nextToken());
    		char c = st.nextToken().charAt(0);
    		if (c == 'L') move = -move;
    		ChangeList.add(move);
    	}
    	ChangeList.add(N);
    	
    }

    static void pro() throws IOException
    {
    	
        while (!ChangeList.isEmpty()) {
        	if (!move(ChangeList.poll())) break;
        }
        System.out.println(MoveCnt);
    }
    
    static boolean move(int destination) {
    	
    	int absDest = Math.abs(destination);
    	
    	for (int i = MoveCnt; i != absDest; i++) {
//    		print();
    		MoveCnt++;
    		int ny = curLoc.y + curDir.y;
    		int nx = curLoc.x + curDir.x;
    		
    		if (ny == -1 || nx == -1 || ny == -1 || nx == -1 || ny == N || nx == N || board[ny][nx] == -1) {
    			return false;
    		}
    		
    		
    		
    		if (board[ny][nx] != 1) {
    			int[] lastSnake = SnakeDeque.pollLast();
    			board[lastSnake[0]][lastSnake[1]] = 0;
    		}
    		board[ny][nx] = -1; 
    		SnakeDeque.addFirst(new int[] {ny, nx});
    		curLoc.y = ny;
    		curLoc.x = nx;
    		
    	}
//    	System.out.println("=====================");
		rotate(destination);
		return true;
    }
    
    static void rotate(int destination) { // - left, + right
    	
    	if (destination < 0) { // 왼쪽으로 회전
    		
    		if (curDir.y == 1) { // 아래로 이동하고 있는 경우
    			curDir.y = 0;
    			curDir.x = 1; // 오른쪽으로 이동하게 변경
    			return;
    		}
    		if (curDir.y == -1) { // 위로 이동하고 있는 경우
    			curDir.y = 0;
    			curDir.x = -1; // 왼쪽으로 이동하게 변경
    			return;
    		}
    		
    		if (curDir.x == 1) { // 오른쪽으로 이동하고 있는 경우
    			curDir.x = 0;
    			curDir.y = -1; // 위로 이동하게 변경
    			return;
    		}
    		
    		if (curDir.x == -1) { // 왼쪽으로 이동하고 있는 경우
    			curDir.x = 0;
    			curDir.y = 1; // 아래로 이동하게 변경
    			return;
    		}
    		
    	} else { // 오른쪽으로 회전
    		
    		if (curDir.y == 1) { // 아래로 이동하고 있는 경우
    			curDir.y = 0;
    			curDir.x = -1; // 오른쪽으로 이동하게 변경
    			return;
    		}
    		if (curDir.y == -1) { // 위로 이동하고 있는 경우
    			curDir.y = 0;
    			curDir.x = 1; // 왼쪽으로 이동하게 변경
    			return;
    		}
    		
    		if (curDir.x == 1) { // 오른쪽으로 이동하고 있는 경우
    			curDir.x = 0;
    			curDir.y = 1; // 위로 이동하게 변경
    			return;
    		}
    		
    		if (curDir.x == -1) { // 왼쪽으로 이동하고 있는 경우
    			curDir.x = 0;
    			curDir.y = -1; // 아래로 이동하게 변경
    			return;
    		}
    	}
    }
 
    static void print() {
    	
    	for (int i = 0; i < N; i++) {
    		for (int j = 0; j < N; j++) System.out.print(String.format("%2d", board[i][j]));
    		System.out.println();
    	}
    	System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
    }
    
    public static void main(String[] args) throws IOException{
		input();
        pro();
	}
    
}