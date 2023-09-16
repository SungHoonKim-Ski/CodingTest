import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer sb = new StringBuffer();
    static StringTokenizer st;

    static int n;
    static long res = 0;
    static int[] aArr;
    static int[] arrCnt;

    static void input() throws IOException{

        n = Integer.parseInt(br.readLine());
        aArr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) aArr[i] = Integer.parseInt(st.nextToken());
        arrCnt = new int[40001];
    }

    static void pro() {

        for (int i = 0; i < n; i++) {
            arrCnt[aArr[i] + 20000]++; // 초기값 할당
        }
        dfs(0, 0, 0);
        System.out.println(res / 3);
    }

    static void dfs(int depth, int idx, int sum) {

        if (depth == 2) {
            res += arrCnt[20000 + sum];
            return;
        }
        for (int i = idx; i < n; i++) {
            if (arrCnt[20000 + aArr[i]] == 0) continue;
            arrCnt[20000 + aArr[i]]--;
            dfs(depth + 1, i + 1, sum - aArr[i]);
            arrCnt[20000 + aArr[i]]++;
        }

    }

    public static void main(String[] args) throws IOException{
        input();
        pro();

    }

}
