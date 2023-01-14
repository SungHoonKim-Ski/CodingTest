import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    public static void main(String[] args) throws IOException {

        StringBuffer sb = new StringBuffer();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int x = 2 * n - 1;
        for (int i=1; i<=x; i++) {
            if (i <= n) {
                for (int j=n; j>0; j--) {
                    if (i < j) sb.append(' ');
                    else sb.append('*');
                }
            }else {
                for (int j=0; j<n; j++) {
                    if ((i-n) <= j) sb.append('*');
                    else sb.append(' ');
                }
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
