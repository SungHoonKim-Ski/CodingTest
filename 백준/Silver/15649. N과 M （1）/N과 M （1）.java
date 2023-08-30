import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int M;
	static boolean[] visit;
	static List<Integer> list;
	static void dfs(int depth) {
		
		if(depth==M) {
			for (int i = 0; i < list.size(); i++) {
				System.out.print(list.get(i)+" ");		
			}
			System.out.println();
			return;
		}
		
		for(int i = 1; i <= N; i++) {
			
			if(!visit[i]) {
				visit[i] = true;
				list.add(i);
//				System.out.println("현재 i "+i);
				dfs(depth+1);
				visit[i] = false;
				list.remove(list.size()-1);
			}			
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stf = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stf.nextToken());
        M = Integer.parseInt(stf.nextToken());
        visit = new boolean[N+1];	//visit만 사용하면 출력할 때 추가한 순서대로가 안됨
        list = new ArrayList<>();
//        StringTokenizer st = new StringTokenizer(br.readLine());
        
        dfs(0);
        
                


	}

}
