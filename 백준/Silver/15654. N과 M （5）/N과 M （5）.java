import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    	static boolean[] visit;
    static int[] arr;
    static List<Integer> list;
    static StringBuilder str;
    static void dfs(int depth, int num) {

        if(depth==M) {

            for (int i = 0; i < list.size(); i++) {
//                if(list.get(i)!=0)
                str.append(list.get(i)).append(" ");
            }
            str.append("\n");
            return;
        }

        for(int i = 0; i < N; i++) {

			if(!visit[i]) {
				visit[i] = true;
//            if(i==0) continue;

	            list.add(arr[i]);
	//				System.out.println("현재 i "+i);
	            dfs(depth+1, i);
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
        arr = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
        Arrays.sort(arr);
        str = new StringBuilder();
        visit = new boolean[N];
        list = new ArrayList<>();
//        StringTokenizer st = new StringTokenizer(br.readLine());

        dfs(0, 0);

        System.out.println(str);



    }

}
