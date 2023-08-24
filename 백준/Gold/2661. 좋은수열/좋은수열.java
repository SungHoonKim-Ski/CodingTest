import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer sb = new StringBuffer();
    static StringTokenizer st;

    static int n;

    static boolean isPrint = false;

    static ArrayList<Integer> seqArr;
    static void input() throws IOException{
        n = Integer.parseInt(br.readLine());
    }
    static void pro() {
        seqArr = new ArrayList<>();
        seqArr.add(1); // 맨 앞자리가 1이어야 최소값이지 않을까..?
        dfs();
        System.out.println(sb);
    }

    static void dfs() {
        if (isPrint) return;
        if (seqArr.size() == n) {
            for (int num : seqArr) sb.append(num);
            isPrint = true;
            return;
        }

        for (int j = 1; j <= 3; j++) {
            seqArr.add(j);
            if (candidate()) dfs();
            seqArr.remove(seqArr.size() - 1);
        }
    }

    static boolean candidate() {

        int mid = seqArr.size() / 2;
        StringBuffer num1 = new StringBuffer();
        StringBuffer num2 = new StringBuffer();
        for (int i = 1; i <= mid; i++) {
            for (int j = 0; j < i; j++) {
                num1.append(seqArr.get(seqArr.size() - 1 - j));
                num2.append(seqArr.get(seqArr.size() - 1 - j - i));
            }
            if (num1.toString().equals(num2.toString())) return false;
            num1.setLength(0);
            num2.setLength(0);
        }
        return true;
    }
    public static void main(String[] args) throws IOException{
        input();
        pro();
    }

}