import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer sb = new StringBuffer();
    static StringTokenizer st;

    static int n;
    static long res, d;
    static Present[] presents;
    static int[] arrCnt;

    static void input() throws IOException{

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        d = Long.parseLong(st.nextToken());
        presents = new Present[n];
        for (int i = 0 ; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            presents[i] = new Present(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
        }
    }

    static void pro() {

        Arrays.sort(presents, new Comparator<Present>() {
            @Override
            public int compare(Present o1, Present o2) {
                return Long.compare(o1.p, o2.p);
            }
        });
        int left = 0, right = 0;
        long maxSumV = presents[0].v;
        long sumV = presents[0].v;
        long minP = presents[0].p;

        while (++right != n) {
            long curP = presents[right].p;
            sumV += presents[right].v;
            if (curP - minP >= d) {
                while (curP - minP >= d) {
                    sumV -= presents[left].v;
                    left++;
                    minP = presents[left].p;
                }
            }
            maxSumV = Math.max(maxSumV, sumV);
        }
        System.out.println(maxSumV);
    }

    static class Present{
        long p, v;
        Present(long _p, long _v) {
            this.p = _p;
            this.v = _v;
        }
    }



    public static void main(String[] args) throws IOException{
        input();
        pro();

    }

}
