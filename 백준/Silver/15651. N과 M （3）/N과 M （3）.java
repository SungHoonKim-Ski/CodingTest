import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    //	static boolean[] visit;
    static List<Integer> list;
    static StringBuilder str;
    static void dfs(int depth, int num) {

        if(depth==M) {

            for (int i = 0; i < list.size(); i++) {
                str.append(list.get(i)).append(" ");
            }
            str.append("\n");
            return;
        }

        for(int i = 1; i <= N; i++) {

//			if(!visit[i]) {
//				visit[i] = true;
            list.add(i);
//				System.out.println("현재 i "+i);
            dfs(depth+1, i);
//				visit[i] = false;
            list.remove(list.size()-1);
//			}
        }
    }

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stf = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stf.nextToken());
        M = Integer.parseInt(stf.nextToken());
        str = new StringBuilder();
//        visit = new boolean[N+1];
        list = new ArrayList<>();
//        StringTokenizer st = new StringTokenizer(br.readLine());

        dfs(0, 0);

        System.out.println(str);



    }

}
