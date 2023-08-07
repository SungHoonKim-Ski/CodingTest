import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

    //  1. 이름별로 별칭인 index를 정하기
    //  2. 별칭인 idx를 이용해 그래프로 만듦
    //  (이름=idx이 정점, 마니또가 간선인 방향그래프)
    //  3. dfs 탐색을 통해 사이클의 수를 계산
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static HashMap<String, Integer> NameIdxMap;
    static HashSet<String> NameSet;
//    static ArrayList<Integer>[] Graph;
    static int[] Graph;
    static int N;

    static boolean[] Visit;
    static int Cnt;
    
    static void input() throws IOException
    {

        NameIdxMap = new HashMap<>(); // 이름 - idx map
        NameSet = new HashSet<>(); // 이름이 이전에 들어왔는지 체크하기 위한 set
        Cnt = 0;
        Visit = new boolean[N];
//        Graph = new ArrayList[N];
//        for (int i = 0; i < N; i++) Graph[i] = new ArrayList<>();

        Graph = new int[N];


        int idx = 0; // 이름 - 인덱스 해시맵으로 만들기 위한 인덱스
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String startName = st.nextToken();
            String endName = st.nextToken();
            
            if (NameSet.add(startName)) {
                NameIdxMap.put(startName, idx++);
            }

            if (NameSet.add(endName)) {
                NameIdxMap.put(endName, idx++);
            }
            
            int s = NameIdxMap.get(startName);
            int e = NameIdxMap.get(endName);

            Graph[s] = e;
        }
        
    }

    static void pro(int tc)
    {

        for (int i = 0; i < N; i++) {
            if (Visit[i]) continue;
            Cnt++;
            dfs(i);

        }

        sb.append(String.format("%d %d", tc, Cnt)).append('\n');
    }

    static void dfs(int start) {

        Visit[start] = true;
        if (!Visit[Graph[start]]) dfs(Graph[start]);
    }


    public static void main(String[] args) throws Exception{

        N = Integer.parseInt(br.readLine());
        int i = 1;
        while (N != 0) {
            input();
            pro(i);
            i++;
            N = Integer.parseInt(br.readLine());
        }
        System.out.println(sb);

    }

}