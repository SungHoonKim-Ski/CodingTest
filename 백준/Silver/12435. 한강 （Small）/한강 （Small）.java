import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int MAX = 1_000_000;

    static int n ,m;
    static int[] count;
    static int[] baby;
    static ArrayList<Integer>[] sameBrotherList;

    static void init() {
        count = new int[MAX + 1];
        baby = new int[MAX + 1];

        for (int i = 2; i <= MAX; i++) {
            for (int j = i * 2; j <= MAX; j += i) {
                count[j]++;

                if (baby[j] == 0) baby[j] = i;
            }
        }

        sameBrotherList = new ArrayList[2010];
        for (int i = 0; i < 2010; i++) sameBrotherList[i] = new ArrayList<>();

        for (int i = 2; i <= MAX; i++) {
            sameBrotherList[count[i]].add(i); // 동일한 동생을 가진 집합
        }
    }

    static void input() throws IOException{
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
    }

    static void pro(int tc) {
        int res = 0;

        for (int i = 0; i < sameBrotherList[count[n]].size(); i++) {
            int x = sameBrotherList[count[n]].get(i);

            if (x == n) break;
            if (baby[x] >= m) res++;
        }

        sb.append("Case #").append(tc).append(": ").append(res).append('\n');
    }

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        init();
        for (int i = 1; i <= t; i++) {
            input();
            pro(i);
        }
        System.out.println(sb);
    }
}