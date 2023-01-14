import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    public static void main(String[] args) throws IOException {

        StringBuffer sb = new StringBuffer();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int x = Integer.parseInt(br.readLine());
        for (int i=1; i<=x; i++) {
            for (int j=1; j<=x-i; j++) {
                sb.append(' ');
            }
            for (int j=1; j<=(2 * i - 1); j++) {
                if (i== 1 || i == x ||j == 1 || j == (2*i-1)) sb.append('*');
                else sb.append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
