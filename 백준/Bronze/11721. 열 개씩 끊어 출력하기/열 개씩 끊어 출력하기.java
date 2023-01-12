import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

class Main {

    public static void main(String[] args) throws IOException {

        StringBuffer sb = new StringBuffer();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] c = br.readLine().toCharArray();
        for (int i=1; i<=c.length; i++) {
            sb.append(c[i-1]);
            if (i % 10 == 0) sb.append('\n');
        }

        System.out.println(sb);
    }
}
