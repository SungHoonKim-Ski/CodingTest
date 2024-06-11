import java.io.*;
import java.util.*;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int MAX_VALUE = 10_000_000;
    static int nNum, len, candidateCnt;
    static String n;
    static HashSet<String> validNumSet;
    static HashSet<Integer> nSet;
    static void input() throws IOException{
        n = br.readLine();
        nNum = Integer.parseInt(n);
        validNumSet = new HashSet<>();
    }

    static void pro() {

        char[] nToCharArr = n.toCharArray();
        len = nToCharArr.length;
        nSet = new HashSet<>();

        for (int i = 0; i < len; i++) {
            nSet.add(nToCharArr[i] - '0');
        }

        for (int i : nSet) {
            int[] visit = new int[len];
            visit[0] = i + MAX_VALUE;
            dfs(1, visit, String.valueOf(i));
        }


        System.out.println(candidateCnt);
    }

    static void dfs(int depth, int[] visit, String curNum) {

        if (depth == len) {
            if (curNum.equals(n)) {
                if (validNumSet.add(Arrays.toString(visit))) candidateCnt++;
            }
            return;
        }

        for (int i: nSet) {
            String num1 = curNum + i;
            int[] visit1 = visit.clone();
            visit1[depth] = i + MAX_VALUE;

            dfs(depth + 1, visit1 ,num1);

            String num2 = i + curNum;
            if (num1.equals(num2)) continue;
            int[] visit2 = visit.clone();
            visit2[depth] = -(i + MAX_VALUE);
            dfs(depth + 1, visit2, num2);
        }
    }

    public static void main(String[] args) throws Exception{
        input();
        pro();
    }
}