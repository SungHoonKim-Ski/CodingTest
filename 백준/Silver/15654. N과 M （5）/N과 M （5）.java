import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;


public class Main {

    static int n, m;
    static int[] input_val;
    static HashSet<Integer> hashSet;
    static StringBuffer sb;
    static int[] prev_val;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuffer();
        hashSet = new HashSet<>();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        input_val = new int[n];
        prev_val = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            input_val[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(input_val);
        recur_func(0);
        System.out.println(sb);
    }

    static void recur_func(int depth) {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                sb.append(prev_val[i]).append(' ');
            }
            sb.append('\n');
        }else {
            for (int i = 0; i < n; i++){
                if(hashSet.add(input_val[i])) {
                    prev_val[hashSet.size() - 1] = input_val[i];
                    recur_func(depth + 1);
                    hashSet.remove(input_val[i]);
                }
            }
        }
    }
}
