import java.io.*;
import java.util.*;

public class Main {

	
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static StringTokenizer st;

    static int R, C;
    
    static boolean[][] Board;
    
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};
    
 
    static void input() throws IOException
    {
    	st = new StringTokenizer(br.readLine());
    	R = Integer.parseInt(st.nextToken());
    	C = Integer.parseInt(st.nextToken());
    	Board = new boolean[R + 2][C + 2];
    	
    	for (int i = 1; i <= R; i++) {
			char[] c = br.readLine().toCharArray();
			for (int j = 1; j <= C; j++) {
				if (c[j - 1] == 'X') Board[i][j] = true;
			}
		}
    	
    }

    static void pro() throws IOException
    {
    	
    	LinkedList<int[]> removeList = new LinkedList<>();
    	for (int r = 1; r <= R; r++) {
			for (int c = 1; c <= C; c++) {
				if (!checkArount(r, c)) removeList.add(new int[] {r, c});
			}
		}
    	
    	for (int[] remove: removeList) {
    		Board[remove[0]][remove[1]] = false;
    	}
    	
    	int[] leftTop = getLeftTop();
    	int[] rightBottom = getRightBottom();
    	
    	for (int r = leftTop[0]; r <= rightBottom[0]; r++) {
    		for (int c = leftTop[1]; c <= rightBottom[1]; c++) {
    			if(Board[r][c]) sb.append('X');
    			else sb.append('.');
    		}
    		sb.append('\n');
    	}
    	
    	
       System.out.println(sb);
    }
    
    static boolean checkArount(int r, int c) {
    	
    	int cnt = 0;
    	for (int i = 0; i < 4; i++) {
			int nr = r + dy[i];
			int nc = c + dx[i];
			if (!Board[nr][nc]) {
				cnt++;
			}
		}
    	if (cnt > 2) return false;
    	return true;
    }
    
    static int[] getLeftTop() {
    	
    	int[] res = new int[2];
    	
    	for (int r = 1; r <= R; r++) {
    		boolean isChecked = false;
    		for (int c = 1; c <= C; c++) {
    			if (Board[r][c]) isChecked = true;
    		}
    		if (isChecked) {
    			res[0] = r;
    			break;
    		}
    	}
    	
    	for (int c = 1; c <= C; c++) {
    		boolean isChecked = false;
    		for (int r = 1; r <= R; r++) {
    			if (Board[r][c]) isChecked = true;
    		}
    		if (isChecked) {
    			res[1] = c;
    			break;
    		}
    	}
    	return res;
    }
    
    static int[] getRightBottom() {
    	int[] res = new int[2];
    	
    	for (int r = R; r != 0; r--) {
    		boolean isChecked = false;
    		for (int c = C; c != 0; c--) {
    			if (Board[r][c]) isChecked = true;
    		}
    		if (isChecked) {
    			res[0] = r;
    			break;
    		}
    	}
    	
    	for (int c = C; c != 0; c--) {
    		boolean isChecked = false;
    		for (int r = R; r != 0; r--) {
    			if (Board[r][c]) isChecked = true;
    		}
    		if (isChecked) {
    			res[1] = c;
    			break;
    		}
    	}
    	return res;
    }
    
    public static void main(String[] args) throws IOException{
		input();
        pro();
	}
    
}