import java.io.*;
import java.util.*;

public class Main {

	
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static StringTokenizer st;

    static int R, C;
    
    static boolean[][] Board;
 
    static void input() throws IOException
    {
    	st = new StringTokenizer(br.readLine());
    	R = Integer.parseInt(st.nextToken());
    	C = Integer.parseInt(st.nextToken());
    	Board = new boolean[R][C];
    	for (int i = 0; i < R; i++) {
    		st = new StringTokenizer(br.readLine());
    		for (int j = 0; j < C; j++) {
    			if (st.nextToken().charAt(0) == '1') {
    				Board[i][j] = true; 
    			}
    		}
    	}
    }

    static void pro() throws IOException
    {
    	int cnt = 0;
    	for (int r = 0; r < R; r++) {
    		for (int c = 0; c < C; c++) {
    			if (Board[r][c]) cnt += checkCnt(r, c);
    		}
    	}
    	sb.append(cnt).append('\n');
    }
    
    static int checkCnt(int r, int c) {
    	
    	int cnt = 0;
    	for (int i = r; i < R; i++) {
    		if (!Board[i][c]) cnt++;
    	}
    	return cnt;
    }
    
    public static void main(String[] args) throws IOException{
    	int N = Integer.parseInt(br.readLine());
    	while (N-- > 0) {
    		input();
            pro();
		}
    	System.out.println(sb);
	}
    
}