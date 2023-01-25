import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(br.readLine());

        B += C;
        if (B > 59) {
            A += B/60;
            B %= 60;
        }
        if (A > 23) A -= 24;

        StringBuffer sb = new StringBuffer();
        sb.append(A).append(' ').append(B);
        System.out.println(sb);
    }
}
