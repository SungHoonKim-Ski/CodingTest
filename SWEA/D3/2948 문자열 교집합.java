import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

class Solution{

    public static void main(String args[]) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int tc = 1; tc <= T; tc++){

            st = new StringTokenizer(br.readLine(), " ");
            int aArrCnt = Integer.parseInt(st.nextToken());
            int bArrCnt = Integer.parseInt(st.nextToken());
            
            HashSet<String> inputSet = new HashSet<>();
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < aArrCnt; i++) {
                inputSet.add(st.nextToken());
            }

            int res = 0;
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < bArrCnt; i++) {
                if (!inputSet.add(st.nextToken())) res++;
            }

            System.out.println("#" + tc + " " + res);
        }
    }
}