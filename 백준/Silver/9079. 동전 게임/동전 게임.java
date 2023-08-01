import java.io.*;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static StringTokenizer st;

    static boolean[][] Coins;
    static boolean[] Visit;
    static int Size = 3, HCnt = 0, Max_Depth = 8;
    static int MinCnt = Integer.MAX_VALUE;

    static void input() throws IOException
    {
    	Coins = new boolean[Size][Size];
    	MinCnt = Integer.MAX_VALUE;
    	HCnt = 0;
    	for (int i = 0; i < Size; i++) {
    		st = new StringTokenizer(br.readLine());
    		for (int j = 0; j < Size; j++) {
    			if (st.nextToken().charAt(0) == 'H') {
    				HCnt++;
    				Coins[i][j] = true;
    			} 
    		}
    	}
    	Visit = new boolean[Size * Size];
    }

    static void pro() throws IOException
    {
        dfs(0, 0, HCnt);
        if (MinCnt == Integer.MAX_VALUE) MinCnt = -1;
        System.out.println(MinCnt);
    }
    
    static void dfs(int depth, int curIdx, int hCnt) {
    	
    	if (hCnt == Max_Depth + 1 || hCnt == 0) {
    		MinCnt = Math.min(depth, MinCnt);
    		return;
    	}
    	if (depth == Max_Depth)	return;
    	
    	
    	for (int i = 0; i < Max_Depth; i++) {
			if (Visit[i]) continue;
			Visit[i] = true;
			
			switch (i) {
			case 0:
			case 1:
			case 2:
				hCnt += reverse_ver(i);
				dfs(depth + 1, i, hCnt);
				hCnt += reverse_ver(i);
				break;
			case 3:
			case 4:
			case 5:
				hCnt += reverse_hor(i - 3);
				dfs(depth + 1, i, hCnt);
				hCnt += reverse_hor(i - 3);
				break;
			case 6:
				hCnt += reverse_asc();
				dfs(depth + 1, i, hCnt);
				hCnt += reverse_asc();
			case 7:
				hCnt += reverse_desc();
				dfs(depth + 1, i, hCnt);
				hCnt += reverse_desc();
				break;
			default:
				System.out.println("error");
				break;
			}
			
			Visit[i] = false; 
		}
    	
    }
    
    public static int reverse_ver(int y) { 
		
    	int changeHCnt = 0;
    	for (int x = 0; x < Size; x++) {
    		if (Coins[y][x]) changeHCnt--;
    		else changeHCnt++;
    		Coins[y][x] = !Coins[y][x];
    	}
    	return changeHCnt;
	}
    
    public static int reverse_hor(int x) {
    	int changeHCnt = 0;
    	for (int y = 0; y < Size; y++) {
    		if (Coins[y][x]) changeHCnt--;
    		else changeHCnt++;
    		Coins[y][x] = !Coins[y][x];
    	}
    	return changeHCnt;
	}
    
    public static int reverse_asc() {
    	int changeHCnt = 0;
    	for (int i = 0; i < Size; i++) {
    		if (Coins[i][i]) changeHCnt--;
    		else changeHCnt++;
    		Coins[i][i] = !Coins[i][i];
    	}
    	return changeHCnt;
	}
    
    public static int reverse_desc() {
    	int changeHCnt = 0;
    	for (int i = 0; i < Size; i++) {
    		if (Coins[i][Size - i - 1]) changeHCnt--;
    		else changeHCnt++;
    		Coins[i][Size - i - 1] = !Coins[i][Size - i - 1];
    	}
    	return changeHCnt;
	}
    
    
    public static void main(String[] args) throws IOException{
    	int N = Integer.parseInt(br.readLine());
    	while(N -- > 0) {
    		input();
            pro();
    	}
	}
    
}