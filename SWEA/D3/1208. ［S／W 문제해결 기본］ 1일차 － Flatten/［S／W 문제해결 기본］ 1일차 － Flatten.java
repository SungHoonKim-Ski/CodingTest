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
    static int[] inputArr = new int[100];
    static int N, min = Integer.MAX_VALUE, max = -1;
     
    public static void input() throws IOException {
         
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 100; i++) {
        	inputArr[i] = Integer.parseInt(st.nextToken());
        }
    }
     
    public static void pro(int tc) {
        
    	int res = 0;
    	
    	Arrays.sort(inputArr);
    	while (N-- > 0) {
			inputArr[0]++;
			inputArr[99]--;
			Arrays.sort(inputArr);
		}
    	res = inputArr[99] - inputArr[0];
        sb.append(String.format("#%d %d\n", tc, res));
    }
    
    public static void main(String[] args) throws Exception {
         
//        br = new BufferedReader(new InputStreamReader(new FileInputStream("res/input.txt")));
        br = new BufferedReader(new InputStreamReader(System.in));
        int T = 10;
         
        for (int tc = 1; tc <= T; tc++) {
            input();
            pro(tc);
        }
        System.out.println(sb);
    }
 
}