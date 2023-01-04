import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static BufferedReader br;
    static StringBuffer sb;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuffer();
        StringBuffer sb = new StringBuffer();
        int T = Integer.parseInt(br.readLine());

        for (int i=0; i<T; i++) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            HashSet<Integer> Tset  = new HashSet<>();
            for (int j=0; j<N; j++) {
                Tset.add(Integer.parseInt(st.nextToken()));
            }

            int M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++) {
                int input = Integer.parseInt(st.nextToken());
                if (Tset.contains(input)) {
                    sb.append(1).append('\n');
                }else {
                    sb.append(0).append('\n');
                }
            }
        }
        System.out.println(sb);
    }
}