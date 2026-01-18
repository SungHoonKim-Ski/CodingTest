import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int n;
    static ArrayList<int[]> tmpList;

    static void input() throws IOException {
        n = Integer.parseInt(br.readLine());

        tmpList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            tmpList.add(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }
    }

    static void pro() {
        Collections.sort(tmpList, (o1, o2)-> o1[0] != o2[0] ? Integer.compare(o1[0], o2[0]) : Integer.compare(o2[1], o1[1]));

        ArrayList<int[]> list = new ArrayList<>();

        int s = tmpList.get(0)[0], e = tmpList.get(0)[1];
        for (int[] x : tmpList) {
            if (e >= x[0]) {
                e = Math.max(e, x[1]);
            } else {
                list.add(new int[] {s, e});
                s = x[0];
                e = x[1];
            }
        }
        list.add(new int[] {s, e});

        int[] cur = list.get(0);
        int loc = cur[1], max = cur[1] + cur[1] - cur[0];

        for (int i = 1; i < list.size(); i++) {
            int[] next = list.get(i);
            if (max < next[0]) break;

            loc = Math.max(loc, next[1]);
            max = Math.max(max, next[1] + next[1] - next[0]);
        }

        System.out.println(loc);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
