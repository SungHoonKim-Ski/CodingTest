import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
 
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int[] Value, Kcal;
    static boolean Visit[];
    static int L, N, MaxValue = 0;;
    
     
    public static void input() throws IOException {
         
    	st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());
    	L = Integer.parseInt(st.nextToken());
    	
    	Value = new int[N];
    	Visit = new boolean[N];
    	Kcal = new int[N];
    	MaxValue = 0;
    	for (int i = 0; i < N; i++) {
    		st = new StringTokenizer(br.readLine());
    		Value[i] = Integer.parseInt(st.nextToken());
    		Kcal[i] = Integer.parseInt(st.nextToken());
    	}
        
    }
     
    public static void pro(int tc) {
        
    	dfs(0, 0, 0);
        sb.append(String.format("#%d %d\n", tc, MaxValue));
    }
    
    public static void dfs(int depth, int kcal, int value) {
    	
    	if (kcal > L) return;
    	MaxValue = Math.max(value,  MaxValue);
    	if (depth == N) return;
    	
    	
		dfs(depth + 1, kcal + Kcal[depth] , value + Value[depth]);
		dfs(depth + 1, kcal , value);
    }
    
    public static void main(String[] args) throws Exception {
         
//        br = new BufferedReader(new InputStreamReader(new FileInputStream("res/input.txt")));
        br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
         
        for (int tc = 1; tc <= T; tc++) {
            input();
            pro(tc);
        }
        System.out.println(sb);
    }
 
}