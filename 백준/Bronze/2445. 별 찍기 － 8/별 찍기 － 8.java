import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    public static void main(String[] args) throws IOException {

        StringBuffer sb = new StringBuffer();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int x = Integer.parseInt(br.readLine());
        int n=x;
        for (int i=0; i<(2 * x -1); i++, n--) {
            if (i < x){
                for (int j=i; j>=0; j--) sb.append('*');
                for (int j=i; j<(x-1); j++) sb.append(' ');
                for (int j=i; j<(x-1); j++) sb.append(' ');
                for (int j=i; j>=0; j--) sb.append('*');
                sb.append('\n');
            } else {
                for (int j=i-x; j<(x-1); j++) sb.append('*');
                for (int j=i-x; j>=0; j--) sb.append(' ');
                for (int j=i-x; j>=0; j--) sb.append(' ');
                for (int j=i-x; j<(x-1); j++) sb.append('*');
                sb.append('\n');
            }

        }
        System.out.println(sb);
    }
}
