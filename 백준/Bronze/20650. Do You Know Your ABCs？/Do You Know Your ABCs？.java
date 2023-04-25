import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;


public class Main {

    static int[] input_val;
    static StringBuffer sb;
    static int a, b, c;
    public static void main(String[] args) throws IOException {


        input();
        pro();
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuffer();

        StringTokenizer st = new StringTokenizer(br.readLine());
        input_val = new int[st.countTokens()];
        for (int i = 0; i < input_val.length; i++) {
            input_val[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void pro() {
        Arrays.sort(input_val);
        a = input_val[0];
        b = input_val[1];
        c = input_val[input_val.length-1] - a - b;
        sb.append(a).append(' ').append(b).append(' ').append(c);
        System.out.println(sb);
    }
}
