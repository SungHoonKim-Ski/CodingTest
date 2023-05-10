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
    static char[][] inputArrHorizon;
    static char[][] inputArrVertical;
    static int N;
     
    public static void input() throws IOException {
         
        N = Integer.parseInt(br.readLine());
        inputArrHorizon = new char[8][];
        inputArrVertical = new char[8][8];
        for (int i = 0; i < 8; i++) {
        	inputArrHorizon[i] = br.readLine().toCharArray(); 
        }
        for (int i = 0; i < 8; i++) {
        	for (int j = 0; j < 8; j++) {
        		inputArrVertical[i][j] = inputArrHorizon[j][i];	
			}
		}
    }
     
    public static void pro(int tc) {
         
        int res = 0, cnt = 0;;
        for (int i = 0; i < 8; i++) {
        	for (int j = 0; j < 8 - N + 1; j++) {
				if (compare(inputArrHorizon[i], j)) res++;
				if (compare(inputArrVertical[i], j)) res++;
			}
		}
        
        sb.append(String.format("#%d %d\n", tc, res));
    }
    
    public static boolean compare(char[] Arr, int startIdx) {
    	
    	for (int i = 0; i < N/2 ; i++) {
			if (Arr[startIdx + i] != Arr[startIdx + N - i - 1]) {
				return false;
			}
		}
    	return true;
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