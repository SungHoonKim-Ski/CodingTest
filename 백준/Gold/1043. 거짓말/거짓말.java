import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer sb = new StringBuffer();
    static StringTokenizer st;
    static int n, m, knownRoot;

    static int[] parents;

    static int[] partyRoot;

    public static void input() throws IOException{


        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        parents = new int[n + 1];
        for (int i = 1; i <= n; i++) parents[i] = i;

        st = new StringTokenizer(br.readLine());
        int knownCnt = Integer.parseInt(st.nextToken());
        if (knownCnt != 0) {
            knownRoot = Integer.parseInt(st.nextToken());
            while (st.hasMoreTokens()) parents[Integer.parseInt(st.nextToken())] = knownRoot;
        }

        partyRoot = new int[m];
    }

    public static void pro() throws IOException{

        int partyCnt = 0;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            int curMember = Integer.parseInt(st.nextToken());
            partyRoot[partyCnt++] = curMember;
            while (st.hasMoreTokens()) {
                int curMember2 = Integer.parseInt(st.nextToken());
                union(curMember, curMember2);
            }
        }

        int honestCnt = 0;
        for (int i = 0; i < m; i++) {
            if (find(partyRoot[i]) != knownRoot) honestCnt++;
        }
        System.out.println(honestCnt);

    }

    public static int find(int a) {
        if (a == parents[a]) return a;
        return find(parents[a]);
    }

    public static boolean union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
        if (aRoot == bRoot) return false;
        if (bRoot == knownRoot) parents[aRoot] = bRoot;
        else parents[bRoot] = aRoot;
        return true;
    }

    public static void main(String[] args) throws IOException{
        input();
        pro();
    }

}
